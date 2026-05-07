/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Service;

import equipopokeapi.service.Ml.ResetPasswordRequest;
import equipopokeapi.service.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import equipopokeapi.service.Ml.Usuario;
import equipopokeapi.service.Ml.LoginRequest;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private CorreoService correoService;
    
    public void register(Usuario usuario){
     usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
     usuario.setActivo(false);
     
     String token =     UUID.randomUUID().toString();
     usuario.setActivationToken(token);
     
     usuarioRepository.save(usuario);
     
     String link = "http://192.167.1.49:4200/activate?token="+ token;
     
     correoService.enviar(usuario.getCorreo(), "Activar cuenta ", "<h1>Bienbenid@,  "+usuario.getNombre()+"</h1>"+"<p>Para nosotros es un placer que te unas a nuestra comunidad, "
             + "para poder verivicar tu cuenta presiona</p>"+"<a href='" + link + "'>Activar cuenta</a>"+"<p>esperamos esta plataforma sea de tu agrado!!!</p>");
 }   
 public String activarCuenta(String token) {

    Usuario usuario = usuarioRepository.findByActivationToken(token);

    if(usuario == null){
        throw new RuntimeException("Token inválido");
    }
    usuario.setActivo(true);
    usuario.setActivationToken(null);
    usuarioRepository.save(usuario);
    return jwtService.generateToken(usuario.getCorreo(), Integer.SIZE);
}
 public String login(LoginRequest request){
     Usuario usuario = usuarioRepository.findByCorreo(request.getCorreo());
     
      if(!passwordEncoder.matches(request.getContraseña(), usuario.getPassword()) ){
         throw new RuntimeException("Credenciales invalidas");
     }
     if(!usuario .isActivo()){
         throw new RuntimeException("Cuenta no activa");
     }
     return jwtService.generateToken(usuario.getCorreo(), Integer.SIZE);
 }
 public void forgotPassword(String correo){
     Usuario usuario = usuarioRepository.findByCorreo(correo);
         if (usuario == null) {
        throw new RuntimeException("Usuario no encontrado");
    }
    String token = UUID.randomUUID().toString();
    usuario.setResetToken(token);
    usuario.setResetExpiracion(LocalDateTime.now().plusMinutes(15));

    usuarioRepository.save(usuario);     
    
            String link = "http://localhost:4200/reset-password?token=" + token;

            correoService.enviar(
                correo,
                "Recuperar contraseña",
                "<a href='" + link + "'>Restablecer contraseña</a>"
        );
} 
 public void  restPassword(ResetPasswordRequest resetpassword){
     Usuario usuari = usuarioRepository.findByResetToken(resetpassword.getToken());
     
     if (usuari.getResetExpiracion().isBefore(LocalDateTime.now())){
         throw new RuntimeException("Token expirado");
     }
     usuari .setPassword(passwordEncoder.encode(resetpassword.getNewPassword()));
     usuari.setResetToken(null);
     usuari.setResetExpiracion(null);
    
     usuarioRepository.save(usuari);
 }
}