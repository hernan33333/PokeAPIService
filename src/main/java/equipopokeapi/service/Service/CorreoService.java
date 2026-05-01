/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Service;

import jakarta.mail.internet.MimeMessage;
import org.hibernate.resource.beans.internal.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class CorreoService {
    @Autowired
    private JavaMailSender javaMailSender;
    
  
public void enviar(String destino, String asunto, String contenido) {

    System.out.println("===== CORREO SIMULADO =====");
    System.out.println("Para: " + destino);
    System.out.println("Asunto: " + asunto);
    System.out.println("Contenido: " + contenido);
}

}