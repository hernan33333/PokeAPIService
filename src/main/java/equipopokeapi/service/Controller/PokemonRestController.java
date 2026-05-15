/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Controller;

import equipopokeapi.service.DAO.PokemonDAOImplementation;
import equipopokeapi.service.Ml.Pokemon;
import equipopokeapi.service.Ml.PokemonDTO;
import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Service.PokemonService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("pokemon")
@CrossOrigin(origins = "http://localhost:8080")
public class PokemonRestController {
    
 
    @Autowired
    private PokemonService pokemonService;
    
    @Autowired
    private PokemonDAOImplementation pokemonDAOImplementation;

    @GetMapping
    @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
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
     @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
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

    @GetMapping("/buscar")
       @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity Busqueda(
            @RequestParam(name = "Generacion", required = false) Integer GeneracionId,
            @RequestParam(name ="Region", required = false) Integer RegionId,
            @RequestParam(name = "Tipo", required = false) Integer TipoId,
            @RequestParam(name = "offset", required = false) Integer Offset){
        
        Result resultBusqueda = new Result();
        
        resultBusqueda = pokemonService.Busqueda(GeneracionId, RegionId, TipoId, Offset);
        
        if (resultBusqueda.correct) {
            
            return ResponseEntity.ok().body(resultBusqueda);
            
        } else {
        
            return ResponseEntity.badRequest().body(resultBusqueda);
        
        }
    
    }
    
    @GetMapping("/region")
         @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity GetAllRegiones(){

        Result resultRegiones = new Result();

        resultRegiones = pokemonService.GetRegiones();

        if (resultRegiones.correct) {

            return ResponseEntity.ok().body(resultRegiones);

        } else {

            return ResponseEntity.internalServerError().body(resultRegiones);

        }

    }

    @GetMapping("/generacion")
     @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity GetAllGeneraciones(){

        Result resultGeneraciones = new Result();

        resultGeneraciones = pokemonService.GetGeneraciones();

        if (resultGeneraciones.correct) {

            return ResponseEntity.ok().body(resultGeneraciones);

        } else {

            return ResponseEntity.internalServerError().body(resultGeneraciones);

        }

    }

    @GetMapping("/tipos")
    @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity GetAllTipos(){

        Result resultTipos = new Result();

        resultTipos = pokemonService.GetTipos();

        if (resultTipos.correct) {

            return ResponseEntity.ok().body(resultTipos);

        } else {

            return ResponseEntity.internalServerError().body(resultTipos);

        }

    }
    
    @GetMapping("/favoritos/{IdUsuario}")
    @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity GetFavoritos(@PathVariable("IdUsuario") int IdUsuario){
        
        Result Resultado = pokemonDAOImplementation.ObtenerFavoritos(IdUsuario);
        
        if(Resultado.correct){
            
            if(Resultado.objects.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            
            Result result = new Result();
            result.objects = new ArrayList<>();
            
            for(Object pokemon: Resultado.objects){
                
                PokemonDTO Pokemon = (PokemonDTO)pokemon;
                result.objects.add(pokemonService.GetById(Pokemon.getIdPokemon()));
                
            }
            result.correct = true;
            return ResponseEntity.ok(result);
            
            
        }else{
            
            
           return ResponseEntity.badRequest().body(Resultado);
           
           
        }
    }
    
    @GetMapping("/favoritos")
    @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity GetAllFavoritos(){
        Result Resultado = pokemonDAOImplementation.GetAllFavoritos();
        
        if(Resultado.correct){
            
            if(Resultado.objects.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(Resultado);
        }else{
            
            return ResponseEntity.badRequest().body(Resultado);
            
        }
    }
    
    @PostMapping("/favoritos/{IdUsuario}")
    @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity AddFavorito(@PathVariable("IdUsuario") int IdUsuario, @RequestBody PokemonDTO pokemon){
        
        Result Resultado = pokemonDAOImplementation.AgregarFavorito(IdUsuario, pokemon);
        
        if(Resultado.correct){
            return ResponseEntity.ok(Resultado);
        }
        
        return ResponseEntity.badRequest().body(Resultado);
    }
    
    
    @DeleteMapping("/favoritos/{IdUsuario}/{IdPokemon}")
    @PreAuthorize("hasAnyRole('SuperMaestroPokemon', 'MaestroPokemon')")
    public ResponseEntity DeleteFavorito(@PathVariable("IdUsuario") int IdUsuario, @PathVariable("IdPokemon") int IdPokemon){
        
        Result Resultado = pokemonDAOImplementation.EliminarFavorito(IdUsuario, IdPokemon);
        
        if(Resultado.correct){
            
            return ResponseEntity.ok(Resultado);
            
        }
        
        return ResponseEntity.badRequest().body(Resultado);
        
        
    }
        
}