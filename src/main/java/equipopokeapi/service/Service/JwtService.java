/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final String SecretKey = "jbdiuwoklmlmslzmxo90oiokmdsomJhfbdsjknpoPPHIBJlpij";
    
  public String generateToken(String email) {
     return Jwts.builder()
          .setSubject(email)
     .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + 86400000))        
             .signWith(SignatureAlgorithm.HS256, SecretKey)
            .compact();
  }
}