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
public class HabilidadJSON {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("effect_changes")
    private List<EffectChangeJSON> efectChanges;
    
    @JsonProperty("effect_entries")
    private List<EffectEntrieJSON> efectEntries;
    
    @JsonProperty("generation")
    private NamedResourceJSON generation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EffectChangeJSON> getEfectChanges() {
        return efectChanges;
    }

    public void setEfectChanges(List<EffectChangeJSON> efectChanges) {
        this.efectChanges = efectChanges;
    }

    public List<EffectEntrieJSON> getEfectEntries() {
        return efectEntries;
    }

    public void setEfectEntries(List<EffectEntrieJSON> efectEntries) {
        this.efectEntries = efectEntries;
    }

    public NamedResourceJSON getGeneration() {
        return generation;
    }

    public void setGeneration(NamedResourceJSON generation) {
        this.generation = generation;
    }
    
}
