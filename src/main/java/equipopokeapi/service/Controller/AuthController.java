/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Controller;

import equipopokeapi.service.Ml.LoginRequest;
import equipopokeapi.service.Ml.ResetPasswordRequest;
import equipopokeapi.service.Ml.Usuario;
import equipopokeapi.service.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void register(@RequestBody    Usuario usuario){
        authService.register(usuario);
    }
    
    @GetMapping("activate")
    public void activarcuenta(@RequestParam String token){
        authService.activarCuenta(token);
    }
    
    @PostMapping("/login")
    public void login(@RequestBody LoginRequest login){
        authService.login(login);
    }
    
    @PostMapping("/forgot-password")
    public void forgot(@RequestParam String correo){
        authService.forgotPassword(correo);
    }
    
    @PostMapping("/reset-password")
    public void reset(@RequestBody ResetPasswordRequest resetPassword){
        authService.restPassword(resetPassword);
    }
            
    
    

}
