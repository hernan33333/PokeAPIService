/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Controller;

import equipopokeapi.service.DAO.UsuarioImplementación;
import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/Pokeapi")
public class UsuarioCintroller {
    @Autowired
    private UsuarioImplementación usuarioImplementacion;
    
    @GetMapping
    public ResponseEntity<?>GetAll(){
       
        try{
             Result result = usuarioImplementacion.Get();
             
             if(result.correct){
                 if(result.objects != null &&  !result.objects.isEmpty()){
                 return ResponseEntity.ok(result.objects);
             }else{
                    return ResponseEntity.noContent().build();
                 }
             }else{
                     return ResponseEntity.badRequest().body(result.errorMessage);
                     }
             
            
        }catch(Exception ex){
           return ResponseEntity.status(500).body(ex.getMessage());
        }
    
    }
      @GetMapping("/rol")
    public ResponseEntity<?>GetAlRol(){
       
        try{
             Result result = usuarioImplementacion.GetRol();
             
             if(result.correct){
                 if(result.objects != null &&  !result.objects.isEmpty()){
                 return ResponseEntity.ok(result.objects);
             }else{
                    return ResponseEntity.noContent().build();
                 }
             }else{
                     return ResponseEntity.badRequest().body(result.errorMessage);
                     }
             
            
        }catch(Exception ex){
           return ResponseEntity.status(500).body(ex.getMessage());
        }
    
    }
    @PostMapping("/adduser")
    public ResponseEntity<Result>AddUsuario(   @RequestPart("adduser") Usuario usuario){
        Result result = usuarioImplementacion.Add(usuario);
        
        return result.correct
                ?ResponseEntity.ok(result): ResponseEntity.badRequest().body(result);
     
        
    }

}
