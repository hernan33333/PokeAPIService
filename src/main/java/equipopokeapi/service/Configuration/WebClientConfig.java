/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author Alien 7
 */
@Configuration
public class WebClientConfig {
    
    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
    
    @Bean
    public WebClient webClient(WebClient.Builder builder){
    
        return builder
                .codecs(configurer -> configurer
                    .defaultCodecs()
                    .maxInMemorySize(16*1024*1024))
                .baseUrl("https://pokeapi.co/api/v2/")
                .defaultHeader("Content-Type", "application/json")
                .build();
    
    }
    
}
