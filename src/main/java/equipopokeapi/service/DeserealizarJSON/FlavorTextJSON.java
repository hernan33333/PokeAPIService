/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;


public class FlavorTextJSON {
    @JsonProperty("flavor_text")
    private String flavor_text;
    
    @JsonProperty("language")
    private NamedResourceJSON language;

    public FlavorTextJSON(String flavor_text) {
        this.flavor_text = flavor_text;
    }
    
    public String getFlavor_text() {
        return flavor_text;
    }

    public void setFlavor_text(String flavor_text) {
        this.flavor_text = flavor_text;
    }

    public NamedResourceJSON getLanguage() {
        return language;
    }

    public void setLanguage(NamedResourceJSON language) {
        this.language = language;
    }

}
