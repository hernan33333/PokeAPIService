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
public class TypeSlot {
    
    @JsonProperty("slot")
    private Integer slot;
    
    @JsonProperty("type")
    private NamedResourceJSON type;

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public NamedResourceJSON getType() {
        return type;
    }

    public void setType(NamedResourceJSON type) {
        this.type = type;
    }
    
    
    
}
