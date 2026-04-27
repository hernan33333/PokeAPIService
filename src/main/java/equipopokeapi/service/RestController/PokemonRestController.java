/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.RestController;

import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

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
    
    @Autowired
    private PokemonService pokemonService;
    
    @GetMapping
    public ResponseEntity GetAll(){
        
        Result resultAll = new Result();

        try {
            
            resultAll = pokemonService.GetAll();
            
            if (resultAll.correct) {
                
                if (resultAll.objects != null) {
                    
                    
                    return ResponseEntity.ok(resultAll.objects.size());
                    
                } else {
                
                    return ResponseEntity.noContent().build();
                    
                }
                
            } else {
            
                return ResponseEntity.internalServerError().body(resultAll);
            
            }
            
        } catch (Exception ex) {
            
            resultAll.correct = false;
            resultAll.errorMessage = ex.getLocalizedMessage();
            
            return ResponseEntity.internalServerError().body(resultAll);
            
        }
        
    }
    
    @GetMapping("/{IdPokemon}")
    public ResponseEntity GetById(@PathVariable("IdPokemon") Integer IdPokemon){
    
        Result resultById = new Result();
            
        resultById = pokemonService.GetById(IdPokemon);

        if (resultById.correct) {

            return ResponseEntity.ok().body(resultById);

        } else {

            return ResponseEntity.notFound().build();

        }

    }
    
}
