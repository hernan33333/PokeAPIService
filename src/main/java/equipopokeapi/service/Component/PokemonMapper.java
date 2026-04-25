/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Component;

import equipopokeapi.service.DeserealizarJSON.GenerationJSON;
import equipopokeapi.service.DeserealizarJSON.NamedResourceJSON;
import equipopokeapi.service.DeserealizarJSON.PokemonJSON;
import equipopokeapi.service.Ml.Generacion;
import equipopokeapi.service.Ml.Pokemon;
import equipopokeapi.service.Ml.Sprites;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Alien 7
 */

@Component
public class PokemonMapper {
    
    public Pokemon pokemonJSONToML(PokemonJSON pokemonJSON){
    
        Sprites sprites = new Sprites(
                pokemonJSON.getSprites().other.home.getFront_default(),
                pokemonJSON.getSprites().other.home.getFront_female(),
                pokemonJSON.getSprites().other.home.getFront_shiny(),
                pokemonJSON.getSprites().other.home.getFront_shiny_female());
                
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
                "regonn",
                sprites,
                new ArrayList<>(),
                new ArrayList<>()
                );
    
        return pokemon;
        
    }
    
    public Generacion generacionJSONToMl(GenerationJSON generacionJSON){
    
        List<Integer> tipos = new ArrayList<>();
        
        for (NamedResourceJSON tipo : generacionJSON.getTypes()) {
            
            tipos.add(Integer.parseInt(splitaerURI(tipo.getUrl().split("/")[6])));
            
        }
        
        Generacion generacion = new Generacion(
                generacionJSON.getId(),
                generacionJSON.getName(),
                Integer.parseInt(splitaerURI(generacionJSON.getMain_region().getUrl())),
                tipos
        );
        
        return generacion;
    
    }
    
    private String splitaerURI(String url){
    
        return url.split("/")[6];
    
    }
    
}
