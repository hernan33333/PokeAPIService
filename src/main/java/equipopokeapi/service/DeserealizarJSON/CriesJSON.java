/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Alien 7
 */
public class CriesJSON {
    
    @JsonProperty("latest")
    private String latest;

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }
    
    
}