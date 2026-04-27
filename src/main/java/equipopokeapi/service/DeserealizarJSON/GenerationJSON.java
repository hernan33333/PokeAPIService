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
public class GenerationJSON {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("main_region")
    private NamedResourceJSON main_region;
    
    @JsonProperty("pokemon_species")
    private List<NamedResourceJSON> pokemon_species;
    
    @JsonProperty("types")
    private List<NamedResourceJSON> types;

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

    public NamedResourceJSON getMain_region() {
        return main_region;
    }

    public void setMain_region(NamedResourceJSON main_region) {
        this.main_region = main_region;
    }

    public List<NamedResourceJSON> getPokemon_species() {
        return pokemon_species;
    }

    public void setPokemon_species(List<NamedResourceJSON> pokemon_species) {
        this.pokemon_species = pokemon_species;
    }
    
    public List<NamedResourceJSON> getTypes() {
        return types;
    }

    public void setTypes(List<NamedResourceJSON> types) {
        this.types = types;
    }
    
}
