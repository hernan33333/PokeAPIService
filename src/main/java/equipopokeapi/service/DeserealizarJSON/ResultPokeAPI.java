/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 *
 * @author Alien 7
 */
public class ResultPokeAPI {
    
    @JsonProperty("count")
    public int count;
    
    @JsonProperty("next")
    public String next;
    
    @JsonProperty("previous")
    public String previous;
    
    @JsonProperty("results")
    public List<NamedResourceJSON> results;
}
