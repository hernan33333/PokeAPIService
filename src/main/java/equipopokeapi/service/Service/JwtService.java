/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Service;

import io.jsonwebtoken.Claims;
import java.util.Date;
import io.jsonwebtoken.Jwts;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.function.Function;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    private final String SecretKey = "jbdiuwoklmlmslzmxo90oiokmdsomJhfbdsjknpoPPHIBJlpij";    
    private final long EXPIRATION_TIME = 86400000;
    
  public String generateToken(String email, Integer idRol) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("rol", idRol);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SecretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }
    public Integer extractRol(String token) {
        return extractClaim(token, claims -> claims.get("rol", Integer.class));
    }
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        final Claims claims = extractAllClaims(token);
        return resolver.apply(claims);
    }

    public boolean isTokenValid(String token, String email) {
        final String username = extractUsername(token);
        return (username.equals(email) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
private Claims extractAllClaims(String token) {
    return Jwts.parser()
            .setSigningKey(SecretKey)
            .parseClaimsJws(token)
            .getBody();
}
}