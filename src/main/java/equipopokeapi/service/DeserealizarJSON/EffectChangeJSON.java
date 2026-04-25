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
public class EffectChangeJSON {
    
    @JsonProperty("effect_entries")
    public List<EffectEntrieJSON> effectEntries;
    
}
