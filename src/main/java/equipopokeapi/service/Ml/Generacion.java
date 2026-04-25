/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Ml;

import java.util.List;

/**
 *
 * @author Alien 7
 */
public class Generacion {
    
    private Integer Id;
    private String Nombre;
    private Integer MainRegion;
    private List<Integer> Tipos;

    public Generacion(Integer Id, String Nombre, Integer MainRegion, List<Integer> Tipos) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.MainRegion = MainRegion;
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

    public Integer getMainRegion() {
        return MainRegion;
    }

    public void setMainRegion(Integer MainRegion) {
        this.MainRegion = MainRegion;
    }

    public List<Integer> getTipos() {
        return Tipos;
    }

    public void setTipos(List<Integer> Tipos) {
        this.Tipos = Tipos;
    }
}
