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

    public void register(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setActivo(false);

        String token = UUID.randomUUID().toString();
        usuario.setActivationToken(token);

        usuarioRepository.save(usuario);

        String link = "http://localhost:4200/activate?token=" + token;
        correoService.enviar(usuario.getCorreo(),
                "Activar cuenta ",
                "<meta name=\"color-scheme\" content=\"light dark\"><meta name=\"supported-color-schemes\" content=\"light dark\">"
                +"<div style='font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px;'>"
                + "  <div style='max-width: 600px; margin: 0 auto; background-color: #71A3BA; border-radius: 12px; overflow: hidden;'>"
                + "    <div style='padding: 20px; text-align: center;'>"
                + "      <img src='https://1000logos.net/wp-content/uploads/2017/05/Pokemon-Logo.png' style='max-width: 400px; margin-bottom: 20px;'>"
                + "      <h1 style='color: white;'>¡Saludos Entrenador@!</h1>"
                + "      <p style='color: white; font-size: 16px;'>Es un placer para nosotros que te unas a nuestra comunidad. Para verificar tu cuenta, por favor presiona el botón.</p>"
                + "      <br>"
                + "      <a href='" + link + "' style='background-color: #198754; color: white; padding: 12px 25px; text-decoration: none; border-radius: 5px; font-weight: bold; display: inline-block;'>"
                + "        Activar cuenta"
                + "      </a>"
                + "      <br><br>"
                + "      <img src='https://media.tenor.com/b4YzfTiBP7MAAAAC/bye-bye-pokemon.gif' style='max-width: 250px; border-radius: 10px;'>"
                + "    </div>"
                + "  </div>"
                + "</div>");
    }

    public String activarCuenta(String token) {

        Usuario usuario = usuarioRepository.findByActivationToken(token);

        if (usuario == null) {
            throw new RuntimeException("Token inválido");
        }
        usuario.setActivo(true);
        usuario.setActivationToken(null);
        usuarioRepository.save(usuario);
        return jwtService.generateToken(usuario.getCorreo(), Integer.SIZE);
    }

    public String login(LoginRequest request) {
        Usuario usuario = usuarioRepository.findByCorreo(request.getCorreo());

        if (!passwordEncoder.matches(request.getContraseña(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales invalidas");
        }
        if (!usuario.isActivo()) {
            throw new RuntimeException("Cuenta no activa");
        }
        return jwtService.generateToken(usuario.getCorreo(), Integer.SIZE);
    }

    public void forgotPassword(String correo) {
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

    public void restPassword(ResetPasswordRequest resetpassword) {
        Usuario usuari = usuarioRepository.findByResetToken(resetpassword.getToken());

        if (usuari.getResetExpiracion().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Token expirado");
        }
        usuari.setPassword(passwordEncoder.encode(resetpassword.getNewPassword()));
        usuari.setResetToken(null);
        usuari.setResetExpiracion(null);

        usuarioRepository.save(usuari);
    }
}
