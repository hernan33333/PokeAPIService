/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;

import java.util.List;
import java.util.Objects;


public class Tipo {
    private Integer Id;
    private String Nombre;
    private Integer Generacion;
    private List<Integer> Pokemones;

    public Tipo() {
    }
    
    public Tipo(Integer Id){
        this.Id = Id;
    }

    public Tipo(Integer Id, String Nombre, Integer Generacion, List<Integer> Pokemones) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Generacion = Generacion;
        this.Pokemones = Pokemones;
    }

    public Integer getGeneracion() {
        return Generacion;
    }

    public void setGeneracion(Integer Generacion) {
        this.Generacion = Generacion;
    }

    public List<Integer> getPokemones() {
        return Pokemones;
    }

    public void setPokemones(List<Integer> Pokemones) {
        this.Pokemones = Pokemones;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

}
