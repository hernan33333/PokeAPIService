/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import equipopokeapi.service.DeserealizarJSON.NamedResourceJSON;

/**
 *
 * @author Alien 7
 */
class AbilitySlotJSON {
    
    @JsonProperty("ability")
    public NamedResourceJSON ability;
    
    @JsonProperty("is_hidden")
    public Boolean isHidden;
    
    @JsonProperty("slot")
    public Integer slot;
}
