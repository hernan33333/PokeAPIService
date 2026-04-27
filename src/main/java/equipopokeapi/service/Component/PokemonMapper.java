/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Component;

import equipopokeapi.service.DeserealizarJSON.AbilitySlotJSON;
import equipopokeapi.service.DeserealizarJSON.EffectChangeJSON;
import equipopokeapi.service.DeserealizarJSON.EffectEntrieJSON;
import equipopokeapi.service.DeserealizarJSON.GenerationJSON;
import equipopokeapi.service.DeserealizarJSON.HabilidadJSON;
import equipopokeapi.service.DeserealizarJSON.NamedResourceJSON;
import equipopokeapi.service.DeserealizarJSON.PokemonJSON;
import equipopokeapi.service.DeserealizarJSON.PokemonSlotJSON;
import equipopokeapi.service.DeserealizarJSON.RegionJSON;
import equipopokeapi.service.DeserealizarJSON.TypeJSON;
import equipopokeapi.service.DeserealizarJSON.TypeSlot;
import equipopokeapi.service.Ml.Generacion;
import equipopokeapi.service.Ml.Habilidad;
import equipopokeapi.service.Ml.Pokemon;
import equipopokeapi.service.Ml.Region;
import equipopokeapi.service.Ml.Sprites;
import equipopokeapi.service.Ml.Tipo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alien 7
 */

@Component
public class PokemonMapper {
    
    public Pokemon pokemonJSONToML(PokemonJSON pokemonJSON, List<Region> regionesDTO, List<Generacion> generacionesDTO, List<Tipo> tiposDTO, List<Habilidad> habilidadesDTO){
    
        Sprites sprites = new Sprites(
                pokemonJSON.getSprites().other.home.getFront_default(),
                pokemonJSON.getSprites().other.home.getFront_female(),
                pokemonJSON.getSprites().other.home.getFront_shiny(),
                pokemonJSON.getSprites().other.home.getFront_shiny_female());
                
        List<Tipo> tipos =  new ArrayList<>();
        List<Habilidad> habilidades = new ArrayList<>();
        
        for (TypeSlot typeSlot : pokemonJSON.getTypes()) {
            
            tipos.add(tiposDTO.stream()
                    .filter(tipo -> tipo.getId() == Integer.parseInt(splitaerURI(typeSlot.getType().getUrl())))
                    .findFirst()
                    .orElse(null)
                    
            );
            
        }
        
        for (AbilitySlotJSON ability : pokemonJSON.getAbilities()) {
            
            habilidades.add(habilidadesDTO.stream()
                .filter(habilidad -> habilidad.getId() == Integer.parseInt(splitaerURI(ability.getAbility().getUrl())))
                .findFirst()
                .orElse(null)
            );
            
        }
        
        Pokemon pokemon =  new Pokemon(
                pokemonJSON.getId(),
                pokemonJSON.getName(),
                pokemonJSON.getStats().get(0).getBase_stat(),
                pokemonJSON.getStats().get(1).getBase_stat(),
                pokemonJSON.getStats().get(2).getBase_stat(),
                pokemonJSON.getStats().get(3).getBase_stat(),
                pokemonJSON.getStats().get(4).getBase_stat(),
                pokemonJSON.getStats().get(5).getBase_stat(),
                pokemonJSON.getWeight(),
                pokemonJSON.getHeight(),
                pokemonJSON.getBaseExperience(),
                pokemonJSON.getCries().getLatest(),
                generacionesDTO.stream()
                    .filter(generacion -> generacion.getPokemones().contains(pokemonJSON.getId()))
                    .findFirst()
                    .orElse(null)
                ,
                sprites,
                tipos,
                habilidades
                );
    
        return pokemon;
        
    }
    
    public Habilidad habilidadJSONToMl(HabilidadJSON habilidadJSON){
    
        List<String> efectosEntrada = new ArrayList<>();
        List<String> efectosCambio = new ArrayList<>();
        List<Integer> pokemonesID = new ArrayList<>();
        
        for (PokemonSlotJSON pokemonSlot : habilidadJSON.getPokemon()) {
            
            pokemonesID.add(Integer.valueOf(splitaerURI(pokemonSlot.getPokemon().getUrl())));
            
        }
        
        for (EffectEntrieJSON efectEntry : habilidadJSON.getEfectEntries()) {
            
            efectosEntrada.add(efectEntry.effect);
            
        }
        
        for (EffectChangeJSON efectChanges : habilidadJSON.getEfectChanges()) {
            
            for (EffectEntrieJSON efectEntry : efectChanges.effectEntries) {
                
                efectosCambio.add(efectEntry.effect);
                
            }
            
        }
        
        Habilidad habilidad = new Habilidad(
                habilidadJSON.getId(),
                habilidadJSON.getName(),
                efectosEntrada,
                efectosCambio,
                Integer.valueOf(splitaerURI(habilidadJSON.getGeneration().getUrl())),
                pokemonesID);
        
        return habilidad;
    
    }
    
    public Generacion generacionJSONToMl(GenerationJSON generacionJSON, List<Region> regionesDTO){
    
        List<Integer> tiposID = new ArrayList<>();
        List<Integer> pokemonesID =  new ArrayList<>();
        
        for (NamedResourceJSON tipo : generacionJSON.getTypes()) {
            
            tiposID.add(Integer.valueOf(splitaerURI(tipo.getUrl())));
            
        }
        
        for (NamedResourceJSON pokemon : generacionJSON.getPokemon_species()) {
            
            pokemonesID.add(Integer.valueOf(splitaerURI(pokemon.getUrl())));
            
        }
        
        Generacion generacion = new Generacion(
                generacionJSON.getId(),
                generacionJSON.getName(),
                regionesDTO.stream()
                    .filter(region -> region.getId() == Integer.parseInt(splitaerURI(generacionJSON.getMain_region().getUrl())))
                    .findFirst()
                    .orElse(null)
                ,
                pokemonesID,
                tiposID
        );
        
        return generacion;
    
    }
    
    public Tipo tipoJSONToMl(TypeJSON tipoJSON){
    
        List<Integer> pokemonesID = new ArrayList<>();
        
        for (PokemonSlotJSON pokemon : tipoJSON.getPokemones()) {
            
            pokemonesID.add(Integer.valueOf(splitaerURI(pokemon.getPokemon().getUrl())));
            
        }
        
        Tipo tipo = new Tipo(
                tipoJSON.getId(),
                tipoJSON.getName(),
                Integer.valueOf(splitaerURI(tipoJSON.getGeneration().getUrl())),
                pokemonesID
        );
    
        return tipo;
        
    }
    
    public Region regionJSONToMl(RegionJSON regionJSON){
    
        NamedResourceJSON main_generation = regionJSON.getMain_generation();
               
        Region region = new Region(
                regionJSON.getId(),
                regionJSON.getName(),
                (main_generation == null) ? null : Integer.valueOf(splitaerURI(main_generation.getUrl()))
        );
        
        return region;
    
    }
    
    private String splitaerURI(String url){
    
        return url.split("/")[6];
    
    }
    
}
