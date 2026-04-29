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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alien 7
 */
@RestController
@RequestMapping("pokeapi")
public class PokemonRestController {
    
    @Autowired
    private PokemonService pokemonService;
    
    @GetMapping
    public ResponseEntity GetAll(){
        
        Result resultAll = new Result();
            
        resultAll = pokemonService.GetAll();

        if (resultAll.correct) {

            if (resultAll.objects != null) {

                return ResponseEntity.ok(resultAll);

            } else {

                return ResponseEntity.noContent().build();

            }

        } else {

            return ResponseEntity.internalServerError().body(resultAll);

        }
        
    }
    
    @GetMapping(params = "offset")
    public ResponseEntity GetAll(@RequestParam Integer offset){
    
        Result resultOffset = new Result();
        
        if (pokemonService.checkPokemones()) {
            
            resultOffset.correct = false;
            resultOffset.errorMessage = "No se han cargado los pokemones.";
            
            return ResponseEntity.internalServerError().body(resultOffset);
            
        }
        
        resultOffset = pokemonService.GetAll(offset);
        
        if (resultOffset.correct) {
            
            return ResponseEntity.ok().body(resultOffset);
            
        } else {
        
            return ResponseEntity.notFound().build();
        
        }
    
    }
    
    @GetMapping("/{IdPokemon}")
    public ResponseEntity GetById(@PathVariable("IdPokemon") Integer IdPokemon){
    
        Result resultById = new Result();
            
        if (pokemonService.checkPokemones()) {
            
            resultById.correct = false;
            resultById.errorMessage = "No se han cargado los pokemones.";
            
            return ResponseEntity.internalServerError().body(resultById);
            
        }
        
        resultById = pokemonService.GetById(IdPokemon);

        if (resultById.correct) {

            return ResponseEntity.ok().body(resultById);

        } else {

            return ResponseEntity.notFound().build();

        }

    }
    
    @GetMapping("/region")
    public ResponseEntity GetAllRegiones(){
    
        Result resultRegiones = new Result();
        
        resultRegiones = pokemonService.GetRegiones();
        
        if (resultRegiones.correct) {
            
            return ResponseEntity.ok().body(resultRegiones);
            
        } else {
        
            return ResponseEntity.internalServerError().body(resultRegiones);
        
        }
    
    }
    
}
