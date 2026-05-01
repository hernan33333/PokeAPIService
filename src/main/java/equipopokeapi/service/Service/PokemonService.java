/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Service;

import equipopokeapi.service.DeserealizarJSON.EspecieJSON;
import equipopokeapi.service.Ml.Especie;
import equipopokeapi.service.Component.PokemonMapper;
import equipopokeapi.service.DeserealizarJSON.RegionJSON;
import equipopokeapi.service.DeserealizarJSON.GenerationJSON;
import equipopokeapi.service.DeserealizarJSON.HabilidadJSON;
import equipopokeapi.service.DeserealizarJSON.PokemonJSON;
import equipopokeapi.service.DeserealizarJSON.ResultPokeAPI;
import equipopokeapi.service.DeserealizarJSON.TypeJSON;
import equipopokeapi.service.Ml.Generacion;
import equipopokeapi.service.Ml.Habilidad;
import equipopokeapi.service.Ml.Pokemon;
import equipopokeapi.service.Ml.Region;
import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Tipo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author Alien 7
 */
@Service
public class PokemonService {
    
    private static final String rutaAPI = "https://pokeapi.co/api/v2/";
    
    @Autowired
    private WebClient webClient;
    
    @Autowired
    private PokemonMapper pokemonMapper;
    
    private List<PokemonJSON> pokemonesJSON = null;
    private List<HabilidadJSON> habilidadesJSON = null;
    private List<GenerationJSON> generacionesJSON = null;
    private List<TypeJSON> tiposJSON = null;
    private List<RegionJSON> regionesJSON = null;
    private List<EspecieJSON> especiesJSON = null;
    
    private List<Pokemon> pokemonesDTO = new ArrayList<>();
    private List<Habilidad> habilidadesDTO = new ArrayList<>();
    private List<Generacion> generacionesDTO = new ArrayList<>();
    private List<Tipo> tiposDTO = new ArrayList<>();
    private List<Region> regionesDTO = new ArrayList<>();
    private List<Especie> especiesDTO = new ArrayList<>();
    
    private Boolean ordenados = false;
    
    public Result GetAll(){
    
        Result resultAll = new Result();
            
        inicializarInformacion();

        mapearElementos();

        ordenarElementos();

        resultAll.correct = true;

        resultAll.objects = new ArrayList<>(pokemonesDTO.subList(0, 19));
        
        return resultAll;
    
    }
    
    public Result GetAll(Integer offset){
        
        Result resultOffset = new Result();
        
        resultOffset.correct = true;
        resultOffset.objects = new ArrayList<>(pokemonesDTO.subList((offset == null || offset < 19 || offset > pokemonesDTO.size()) ? 0 : offset-19, (offset < 0 || offset > pokemonesDTO.size()) ? 0 : offset));
        
        return resultOffset;
    
    }
    
    public Result Busqueda(Integer generacionId, Integer regionId, Integer tipoId, Integer offset){
    
        Result resultBusqueda = new Result();
        
        if (generacionId.equals(null) && regionId.equals(null) && tipoId.equals(null)) {
         
            resultBusqueda.correct = false;
            resultBusqueda.errorMessage = "No hay filtros plicados.";
            
            return resultBusqueda;
            
        }
        
        List<Pokemon> pokemonesFiltrados = pokemonesDTO.stream()
                                                        .filter(pokemon -> generacionId == null || (pokemon.getGeneracion() == null) ? false : Objects.equals(pokemon.getGeneracion().getId(), generacionId))
                                                        .filter(pokemon -> regionId == null || (pokemon.getGeneracion().getId() == null) ? false : Objects.equals(pokemon.getGeneracion().getRegion().getId(), regionId))
                                                        .filter(pokemon -> tipoId == null || Objects.equals(pokemon.getTipos().stream()
                                                                                                                                .filter(tipo -> tipo.getId() == tipoId)
                                                                                                                                .findFirst()
                                                                                                                                .orElse(new Tipo(-1)).getId(), tipoId)
                                                        )
                                                        .collect(Collectors.toList());
        
        
        if (pokemonesFiltrados.isEmpty()) {
            
            resultBusqueda.correct = false;
            resultBusqueda.errorMessage = "No hay coincidencias";
            
            return resultBusqueda;
            
        }
        
        resultBusqueda.correct = true;
        resultBusqueda.objects = new ArrayList<>(paginarPokemones(offset, pokemonesFiltrados));
        
        return resultBusqueda;
    
    }
    
    private List<Pokemon> paginarPokemones(Integer offset, List<Pokemon> pokemonesFiltrados){
        
        if (pokemonesFiltrados.size() < 20) {
            offset = pokemonesFiltrados.size();
        }
        
        return pokemonesFiltrados.subList((offset == null || offset < 19 || offset > pokemonesFiltrados.size()) ? 0 : offset-19, (offset == null || offset < 0 || offset > pokemonesDTO.size()) ? 0 : offset);
        
    }
    
    public Result GetById(Integer Id){
    
        Result resultById = new Result();
        
        Pokemon pokemonBuscar = pokemonesDTO.stream()
                                            .filter(pokemon -> Objects.equals(pokemon.getId(), Id))
                                            .findFirst()
                                            .orElse(null);

        
        if (pokemonBuscar != null) {

            resultById.correct = true;
            resultById.object = pokemonBuscar;

        } else {

            resultById.correct = false;
            resultById.errorMessage = "No se encontró el pokemon con el ID: " + Id;

        }

        return resultById;
    
    }
    
    public Result GetRegiones(){
    
        Result resultRegion = new Result();
        
        if (regionesDTO.isEmpty()) {
            
            resultRegion.correct = false;
            resultRegion.errorMessage = "No se han inicializado los valores de las regiones";
            
        } else {
        
            resultRegion.correct = true;
            resultRegion.objects = new ArrayList<>(regionesDTO);
        }
        
        return resultRegion;
    
    }
    
    public Result GetGeneraciones(){
    
        Result resultGeneraciones = new Result();

        if (generacionesDTO.isEmpty()) {
            
            resultGeneraciones.correct = false;
            resultGeneraciones.errorMessage = "No se han inicializado los valores de las generaciones.";
            
        } else {
        
            resultGeneraciones.correct = true;
            resultGeneraciones.objects = new ArrayList<>(generacionesDTO);
        
        }
        
        return resultGeneraciones;
    
    }
    
    public Result GetTipos(){
    
        Result resultTipos = new Result();
        
        if (tiposDTO.isEmpty()) {
            
            resultTipos.correct = false;
            resultTipos.errorMessage = "No se han inicializado los valores de las tipos.";
            
        } else {
        
            resultTipos.correct = true;
            resultTipos.objects = new ArrayList<>(tiposDTO);
        
        }
        
        return resultTipos;
    
    }
    
    public boolean checkPokemones(){
    
        return pokemonesDTO.isEmpty();
    
    }
    
    private void inicializarInformacion(){
    
        if (pokemonesJSON == null) {
        
            pokemonesJSON = new ArrayList<PokemonJSON>(obtenerRecursos("pokemon", PokemonJSON.class).block());
            
        }
        
        if (habilidadesJSON == null) {
            
            habilidadesJSON = new ArrayList<HabilidadJSON>(obtenerRecursos("ability", HabilidadJSON.class).block());
            
        }
        
        if (generacionesJSON == null || generacionesDTO.isEmpty()) {
            
            generacionesJSON = new ArrayList<GenerationJSON>(obtenerRecursos("generation", GenerationJSON.class).block());
            
        }
        
        if (tiposJSON == null) {
            
            tiposJSON = new ArrayList<TypeJSON>(obtenerRecursos("type", TypeJSON.class).block());
            
        }
        
        if (regionesJSON == null) {
            
            regionesJSON = new ArrayList<RegionJSON>(obtenerRecursos("region", RegionJSON.class).block());
            
        }
        
        if (especiesJSON == null) {
            
            especiesJSON = new ArrayList<>(obtenerRecursos("pokemon-species/", EspecieJSON.class).block());
            
        }
    
    }
    
    private Mono<List> obtenerRecursos(String api, Class<?> clase){
    
        return webClient.get()
                .uri(api)
                .retrieve()
                .bodyToMono(ResultPokeAPI.class)
                .expand(result -> {
                    if (result.next != null) {
                        return webClient.get()
                                .uri(result.next.split(rutaAPI)[1])
                                .retrieve()
                                .bodyToMono(ResultPokeAPI.class);
                    }
                    
                    return Mono.empty();
                })
                .flatMap(result -> Flux.fromIterable(result.results))
                .flatMap(habilidadResult -> 
                    webClient.get()
                        .uri(habilidadResult.getUrl().split(rutaAPI)[1])
                        .retrieve()
                        .bodyToMono(clase)
                        , 5
                )
                .collect(Collectors.toList());
    
    }

    private void mapearElementos() {
        
        if (habilidadesDTO.isEmpty()) {
         
            for (HabilidadJSON habilidadJSON : habilidadesJSON) {
            
                habilidadesDTO.add(pokemonMapper.habilidadJSONToMl(habilidadJSON));

            }
            
        }
        
        if (regionesDTO.isEmpty()) {
         
            for (RegionJSON regionJSON : regionesJSON) {
            
                regionesDTO.add(pokemonMapper.regionJSONToMl(regionJSON));

            }
            
        }
        
        if (generacionesDTO.isEmpty()) {
            
            for (GenerationJSON generacionJSON : generacionesJSON) {
            
                generacionesDTO.add(pokemonMapper.generacionJSONToMl(generacionJSON, regionesDTO));

            }
            
        }
        
        if (tiposDTO.isEmpty()) {
            
            for (TypeJSON tipoJSON : tiposJSON) {
         
                tiposDTO.add(pokemonMapper.tipoJSONToMl(tipoJSON));

            }
            
        }
        
        if (especiesDTO.isEmpty()) {
            
            for (EspecieJSON especieJSON : especiesJSON) {
                
                especiesDTO.add(pokemonMapper.especieJSONToMl(especieJSON));
                
            }
            
        }
        
        if (pokemonesDTO.isEmpty()) {
            
            for (PokemonJSON pokemonJSON : pokemonesJSON) {
            
                pokemonesDTO.add(pokemonMapper.pokemonJSONToML(pokemonJSON, regionesDTO, generacionesDTO, tiposDTO, habilidadesDTO, especiesDTO));

            }
            
        }
        
    }
    
    private void ordenarElementos(){
    
        if (!ordenados) {
            
            ordenados = !ordenados;
            
            pokemonesDTO = pokemonesDTO.stream()
                .sorted(Comparator.comparing(Pokemon::getId))
                .collect(Collectors.toList());
            
            habilidadesDTO = habilidadesDTO.stream()
                .sorted(Comparator.comparing(Habilidad::getId))
                .collect(Collectors.toList());
            
            generacionesDTO = generacionesDTO.stream()
                .sorted(Comparator.comparing(Generacion::getId))
                .collect(Collectors.toList());
            
            tiposDTO = tiposDTO.stream()
                .sorted(Comparator.comparing(Tipo::getId))
                .collect(Collectors.toList());
            
            regionesDTO = regionesDTO.stream()
                .sorted(Comparator.comparing(Region::getId))
                .collect(Collectors.toList());
            
            especiesDTO = especiesDTO.stream()
                .sorted(Comparator.comparing(Especie::getId))
                .collect(Collectors.toList());
            
        }
    
    }
    
}
