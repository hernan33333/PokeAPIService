/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;


public class Sprites {
    private int IdSprites;
    private String Nombre;
    
    private Pokemon pokemon;

    public Sprites() {
    }

    public Sprites(int IdSprites, String Nombre, Pokemon pokemon) {
        this.IdSprites = IdSprites;
        this.Nombre = Nombre;
        this.pokemon = pokemon;
    }

    public int getIdSprites() {
        return IdSprites;
    }

    public void setIdSprites(int IdSprites) {
        this.IdSprites = IdSprites;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    
    

}
