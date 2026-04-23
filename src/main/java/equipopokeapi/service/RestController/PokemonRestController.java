/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.RestController;

import equipopokeapi.service.DTO.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author Alien 7
 */
@RestController
@RequestMapping("pokemon")
public class PokemonRestController {
    
    private static String rutaBase = "https://pokeapi.co/api/v2/";
    
    @Autowired
    private WebClient webClient;
    
    @GetMapping
    public ResponseEntity GetAll(){
        
        Mono<Pokemon> pokemonMono = webClient.get()
                .uri("pokemon/25/")
                .retrieve()
                .bodyToMono(Pokemon.class);
        
        return ResponseEntity.ok().body(pokemonMono);
        
    }
    
}
