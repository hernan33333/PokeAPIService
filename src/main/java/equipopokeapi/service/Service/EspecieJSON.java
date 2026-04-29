/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import equipopokeapi.service.DeserealizarJSON.NamedResourceJSON;
import java.util.List;

/**
 *
 * @author Alien 7
 */
public class EspecieJSON {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("base_happiness")
    private Integer base_happiness;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("color")
    private NamedResourceJSON color;
    
    @JsonProperty("habitat")
    private NamedResourceJSON habitat;
    
    @JsonProperty("flavor_text_entries")
    private List<FlavorTextJSON> flavor_text_entries;
    
    @JsonProperty("shape")
    private NamedResourceJSON shape;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBase_happiness() {
        return base_happiness;
    }

    public void setBase_happiness(Integer base_happiness) {
        this.base_happiness = base_happiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public NamedResourceJSON getColor() {
        return color;
    }

    public void setColor(NamedResourceJSON color) {
        this.color = color;
    }

    public NamedResourceJSON getHabitat() {
        return habitat;
    }

    public void setHabitat(NamedResourceJSON habitat) {
        this.habitat = habitat;
    }

    public List<FlavorTextJSON> getFlavor_text_entries() {
        return flavor_text_entries;
    }

    public void setFlavor_text_entries(List<FlavorTextJSON> flavor_text_entries) {
        this.flavor_text_entries = flavor_text_entries;
    }

    public NamedResourceJSON getShape() {
        return shape;
    }

    public void setShape(NamedResourceJSON shape) {
        this.shape = shape;
    }
    
}
