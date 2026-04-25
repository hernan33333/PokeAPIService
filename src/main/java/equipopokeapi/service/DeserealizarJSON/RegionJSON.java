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
public class RegionJSON {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("main_generation")
    private NamedResourceJSON main_generation;

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

    public NamedResourceJSON getMain_generation() {
        return main_generation;
    }

    public void setMain_generation(NamedResourceJSON main_generation) {
        this.main_generation = main_generation;
    }
    
    
    
}
