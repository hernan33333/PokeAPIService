/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;


public class Habilidad {
    
    private Integer Id;
    private String Nombre;
    private List<String> EfectosEntrada;
    private List<String> EfectosCambio;
    private Integer Generacion;
    
    @JsonIgnore
    private List<Integer> pokemones;

    public Habilidad() {
    }

    public Habilidad(Integer Id, String Nombre, List<String> EfectosEntrada, List<String> EfectosCambio, Integer Generacion, List<Integer> pokemones) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.EfectosEntrada = EfectosEntrada;
        this.EfectosCambio = EfectosCambio;
        this.Generacion = Generacion;
        this.pokemones = pokemones;
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

    public List<String> getEfectosEntrada() {
        return EfectosEntrada;
    }

    public void setEfectosEntrada(List<String> EfectosEntrada) {
        this.EfectosEntrada = EfectosEntrada;
    }

    public List<String> getEfectosCambio() {
        return EfectosCambio;
    }

    public void setEfectosCambio(List<String> EfectosCambio) {
        this.EfectosCambio = EfectosCambio;
    }

    public Integer getGeneracion() {
        return Generacion;
    }

    public void setGeneracion(Integer Generacion) {
        this.Generacion = Generacion;
    }

    public List<Integer> getPokemones() {
        return pokemones;
    }

    public void setPokemones(List<Integer> pokemones) {
        this.pokemones = pokemones;
    }
}
