/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Service;

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
import java.util.HashSet;
import java.util.Set;
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
    
    private HashSet<PokemonJSON> pokemonesJSON = null;
    private HashSet<HabilidadJSON> habilidadesJSON = null;
    private HashSet<GenerationJSON> generacionesJSON = null;
    private HashSet<TypeJSON> tiposJSON = null;
    private HashSet<RegionJSON> regionesJSON = null;
    
    private HashSet<Pokemon> pokemonesDTO = null;
    private HashSet<Habilidad> habilidadesDTO = null;
    private HashSet<Generacion> generacionesDTO = null;
    private HashSet<Tipo> tiposDTO = null;
    private HashSet<Region> regionesDTO = null;
    
    public Result GetAllPokemones(){
    
        Result resultAll = new Result();
        
        try {
            
            inicializarInformacion();
            
            mapearElementos();
            
            resultAll.correct = true;
            
            resultAll.objects = new HashSet<>(habilidadesJSON);
            
        } catch (Exception ex) {
            
            resultAll.correct = false;
            resultAll.errorMessage = ex.getLocalizedMessage();
            resultAll.ex = ex;
            
        }
        
        return resultAll;
    
    }
    
    private void inicializarInformacion(){
    
//        if (pokemonesDTO == null) {
//        
//            pokemonesJSON = new HashSet<>(obtenerRecursos("pokemon", PokemonJSON.class).block().stream()
//                .filter(PokemonJSON.class::isInstance)
//                .map(PokemonJSON.class::cast)
//                .collect(Collectors.toSet())
//            );
//            
//        }
        
        if (habilidadesJSON == null) {
            
            habilidadesJSON = new HashSet<>(obtenerRecursos("ability", HabilidadJSON.class).block().stream()
                    .filter(HabilidadJSON.class::isInstance)
                    .map(HabilidadJSON.class::cast)
                    .collect(Collectors.toSet())
            );
            
        }
        
        if (generacionesJSON == null) {
            
            generacionesJSON = new HashSet<>(obtenerRecursos("generation", GenerationJSON.class).block().stream()
                .filter(GenerationJSON.class::isInstance)
                .map(GenerationJSON.class::cast)
                .collect(Collectors.toSet())
            
            );
            
        }
        
        if (tiposJSON == null) {
            
            tiposJSON = new HashSet<>(obtenerRecursos("type", TypeJSON.class).block().stream()
                .filter(TypeJSON.class::isInstance)
                .map(TypeJSON.class::cast)
                .collect(Collectors.toSet())
            
            );
            
        }
        
        if (regionesJSON == null) {
            
            regionesJSON = new HashSet<>(obtenerRecursos("region", RegionJSON.class).block().stream()
                .filter(RegionJSON.class::isInstance)
                .map(RegionJSON.class::cast)
                .collect(Collectors.toSet())
            
            );
            
        }
    
    }
    
    private Mono<Set<Object>> obtenerRecursos(String api, Class<?> clase){
    
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
                .collect(Collectors.toSet());
    
    }

    private void mapearElementos() {
        
        for (GenerationJSON generacionJSON : generacionesJSON) {
            
            generacionesDTO.add(pokemonMapper.generacionJSONToMl(generacionJSON));
            
        }
        
    }
    
}
