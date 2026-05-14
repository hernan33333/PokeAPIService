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
    private String Efecto;
    private List<String> EfectoEntrada;
    private List<String> EfectoCambio;
    private Integer Generacion;
    @JsonIgnore
    private List<Integer> pokemon;
    
    
    public Habilidad(){
        
    }


 public Habilidad(Integer Id, String Nombre, List<String> EfectosEntrada, List<String> EfectosCambio, Integer Generacion, List<Integer> pokemones) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Efecto = Efecto;
        this.EfectoEntrada = EfectosEntrada;
        this.EfectoCambio = EfectosCambio;
        this.Generacion = Generacion;
        this.pokemon = pokemones;
    }

public  Integer getId(){
    return Id;
}
public void setId(Integer id){
    this.Id = id;
}

public String getNombre(){
    return Nombre;
}
public void setNombre(String Nombre){
    this.Nombre = Nombre;
}

public String getEfecto(){
    return Efecto;
}
public void setEfecto(String Efecto){
    this.Efecto = Efecto;
}

public List<String> getEfectoEntrada(){
    return EfectoEntrada;
}
public void setEfectoEntrada(List<String> EfectoEntrada){
    this.EfectoEntrada = EfectoEntrada;
}

public List<String> EfectoCambio(){
    return EfectoCambio;
}
public void setEfectoCambio(List<String> EfectoCambio){
    this.EfectoCambio = EfectoCambio;
}

public Integer getGeneracion(){
    return Generacion;
}
public void setGeneracion(Integer Generacion){
    this.Generacion = Generacion;
}

public List<Integer> getPokemon(){
    return pokemon;
}
public void setPokemon(List<Integer> pokemon){
    this.pokemon = pokemon;
}
}