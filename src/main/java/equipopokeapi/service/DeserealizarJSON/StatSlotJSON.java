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
public class StatSlotJSON {
    
    @JsonProperty("base_stat")
    private Integer base_stat;
    
    @JsonProperty("effort")
    private Integer effort;
    
    @JsonProperty("stat")
    private NamedResourceJSON stat;

    public Integer getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(Integer base_stat) {
        this.base_stat = base_stat;
    }

    public Integer getEffort() {
        return effort;
    }

    public void setEffort(Integer effort) {
        this.effort = effort;
    }

    public NamedResourceJSON getStat() {
        return stat;
    }

    public void setStat(NamedResourceJSON stat) {
        this.stat = stat;
    }
    
    
    
}
