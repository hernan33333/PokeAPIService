/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;
import equipopokeapi.service.DeserealizarJSON.NamedResourceJSON;
import java.util.List;

/**
 *
 * @author Alien 7
 */
public class TypeJSON {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("generation")
    private NamedResourceJSON generation;
    
    @JsonProperty("pokemon")
    private List<PokemonSlotJSON> pokemones;

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

    public NamedResourceJSON getGeneration() {
        return generation;
    }

    public void setGeneration(NamedResourceJSON generation) {
        this.generation = generation;
    }

    public List<PokemonSlotJSON> getPokemones() {
        return pokemones;
    }

    public void setPokemones(List<PokemonSlotJSON> pokemones) {
        this.pokemones = pokemones;
    }
    
}
