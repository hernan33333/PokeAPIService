/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;

import java.util.ArrayList;
import java.util.List;


public class Generacion {
    private Integer Id;
    private String Nombre;
    private Region Region;
    private List<Integer> Pokemones;
    private List<Integer> Tipos;

    public Generacion() {
    }

    public Generacion(Integer Id, String Nombre, Region Region, List<Integer> Pokemones, List<Integer> Tipos) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Region = Region;
        this.Pokemones = Pokemones;
        this.Tipos = Tipos;
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

    public Region getRegion() {
        return Region;
    }

    public void setRegion(Region Region) {
        this.Region = Region;
    }

    public List<Integer> getPokemones() {
        return Pokemones;
    }

    public void setPokemones(List<Integer> Pokemones) {
        this.Pokemones = Pokemones;
    }

    public List<Integer> getTipos() {
        return Tipos;
    }

    public void setTipos(List<Integer> Tipos) {
        this.Tipos = Tipos;
    }
    
    
    
}