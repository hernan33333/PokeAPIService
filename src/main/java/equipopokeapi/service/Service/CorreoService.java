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

  MimeMessage mensaje = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);
            helper.setTo(destino);
            helper.setSubject(asunto);
            helper.setText(contenido, true);

            javaMailSender.send(mensaje);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
