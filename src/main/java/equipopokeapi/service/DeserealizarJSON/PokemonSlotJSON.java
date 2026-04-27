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
public class PokemonSlotJSON {
    
    @JsonProperty("slot")
    private Integer slot;
    
    @JsonProperty("pokemon")
    private NamedResourceJSON pokemon;

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public NamedResourceJSON getPokemon() {
        return pokemon;
    }

    public void setPokemon(NamedResourceJSON pokemon) {
        this.pokemon = pokemon;
    }
    
    
    
}
