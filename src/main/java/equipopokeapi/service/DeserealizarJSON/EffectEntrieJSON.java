/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;


public class EffectEntrieJSON {
   @JsonProperty("effect")
    private String effect;
    
    @JsonProperty("language")
    private NamedResourceJSON language;

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public NamedResourceJSON getLanguage() {
        return language;
    }

    public void setLanguage(NamedResourceJSON language) {
        this.language = language;
    }
    
}