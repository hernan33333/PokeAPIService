/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import equipopokeapi.service.DeserealizarJSON.NamedResourceJSON;


public class AbilitySlotJSON {
        @JsonProperty("ability")
    public NamedResourceJSON ability;
    
    @JsonProperty("is_hidden")
    public Boolean isHidden;
    
    @JsonProperty("slot")
    public Integer slot;

    public NamedResourceJSON getAbility() {
        return ability;
    }

    public void setAbility(NamedResourceJSON ability) {
        this.ability = ability;
    }

    public Boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Boolean isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }
    
    
}