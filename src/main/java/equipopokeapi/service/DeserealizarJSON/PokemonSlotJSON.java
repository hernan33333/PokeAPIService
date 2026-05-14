/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.DeserealizarJSON;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PokemonSlotJSON {
    
  @JsonProperty("slot")
  private Integer Slot;
  @JsonProperty("pokemon")
  private NamedResourceJSON pokemon;
  
  
  public Integer getSlot(){
      return Slot;
  }
  public void setSlot(Integer Slot){
      this.Slot =Slot;
  }
  
  public NamedResourceJSON getPokemon(){
      return pokemon;
  }
  public void setPokemon(NamedResourceJSON pokemon){
      this.pokemon = pokemon;
  }    
}