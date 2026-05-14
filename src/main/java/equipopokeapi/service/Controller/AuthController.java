/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Controller;

import equipopokeapi.service.DAO.UsuarioImplementación;
import equipopokeapi.service.Ml.LoginRequest;
import equipopokeapi.service.Ml.ResetPasswordRequest;
import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Usuario;
import equipopokeapi.service.Service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private UsuarioImplementación usuarioImplementation;

    @PostMapping("/register")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario) {
        Result result = new Result();
        try {
            authService.register(usuario);
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;

            return ResponseEntity.status(422).body(result);
        }
        return ResponseEntity.ok(result);
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
        try {

            String token = authService.login(request);
            result.object = token;
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            return ResponseEntity.status(401).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgot(@RequestParam String correo) {
        Result result = new Result();
        try {
            authService.forgotPassword(correo);
            result.correct = true;
        } catch (Exception ex) {
            result.correct = true;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            return ResponseEntity.status(404).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> reset(@RequestBody ResetPasswordRequest resetPassword) {
        Result result = new Result();

        try {
            authService.restPassword(resetPassword);
            result.correct = true;
        } catch (Exception ex) {
            result.correct = false;
            result.errorMessage = ex.getLocalizedMessage();
            result.ex = ex;
            return ResponseEntity.status(400).body(result);
        }
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/{Username}")
    public ResponseEntity ConsultarDisponibilidad(@PathVariable("Username") String Username){
        
        Result Resultado = usuarioImplementation.GetByUsername(Username);
        
        if(Resultado.correct){
            
            return ResponseEntity.ok(Resultado);
            
        }

        return ResponseEntity.badRequest().body(Resultado);
    }
    
    
    @PostMapping("/comprobarCorreo/{correo}")
    public ResponseEntity ConsultarCorreo(@PathVariable("correo") String Correo){
        
        Result Resultado = usuarioImplementation.GetByCorreo(Correo);
        
        if(Resultado.correct){
            return ResponseEntity.ok(Resultado);
        }
        
        return ResponseEntity.badRequest().body(Resultado);
    }

}
