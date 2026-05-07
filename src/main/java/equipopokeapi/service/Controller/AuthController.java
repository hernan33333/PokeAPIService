/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Controller;

import equipopokeapi.service.Ml.LoginRequest;
import equipopokeapi.service.Ml.ResetPasswordRequest;
import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Usuario;
import equipopokeapi.service.Repository.UsuarioRepository;
import equipopokeapi.service.Service.AuthService;
import equipopokeapi.service.Service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    
    @PostMapping("/register")
    public ResponseEntity<?>registro(@RequestBody    Usuario usuario){
        Result result = new Result();
        try{
               authService.register(usuario);
               result.correct = true;
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

            return ResponseEntity.status(422).body(result);
        }
      return    ResponseEntity.ok(result);
    }
    
@GetMapping("/activate")
public ResponseEntity<?> activarCuenta(@RequestParam String token,
                          HttpServletResponse response) throws IOException {
    Result result = new Result();
    try {
        String jwt = authService.activarCuenta(token);
        result.object = jwt;
        result.correct = true;
        
    } catch (Exception ex) {
result.correct = false;
result.errorMessage = ex.getLocalizedMessage();
result.ex = ex;
       
    }
    return ResponseEntity.ok(result);
}

    
@PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        Result result = new Result();
        try{

            String token = authService.login(request);
            result.object = token;
            result.correct = true;
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            return ResponseEntity.status(401).body(result);
        }
        return ResponseEntity.ok(result);
    }
   
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgot(@RequestParam String correo){
        Result result = new Result();
        try{
              authService.forgotPassword(correo);
              result.correct = true;
        }catch(Exception ex){
            result.correct = true;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            return ResponseEntity.status(404).body(result);
        }
      return ResponseEntity.ok(result);
    }
    
    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody ResetPasswordRequest resetPassword){
        Result result = new Result();
        
        try{
               authService.restPassword(resetPassword);
               result.correct= true;
        }catch(Exception ex){
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            return ResponseEntity.status(400).body(result);
        }
        return ResponseEntity.ok(result);
    }
}