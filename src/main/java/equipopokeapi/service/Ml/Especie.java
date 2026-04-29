/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.Ml;

/**
 *
 * @author Alien 7
 */
public class Especie {
    
    private Integer Id;
    private Integer FelicidadBase;
    private String Nombre;
    private String Color;
    private String Habitat;
    private String Descripcion;
    private String Forma;

    public Especie(Integer Id, Integer FelicidadBase, String Nombre, String Color, String Habitat, String Descripcion, String Forma) {
        this.Id = Id;
        this.FelicidadBase = FelicidadBase;
        this.Nombre = Nombre;
        this.Color = Color;
        this.Habitat = Habitat;
        this.Descripcion = Descripcion;
        this.Forma = Forma;
    }      

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public Integer getFelicidadBase() {
        return FelicidadBase;
    }

    public void setFelicidadBase(Integer FelicidadBase) {
        this.FelicidadBase = FelicidadBase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getHabitat() {
        return Habitat;
    }

    public void setHabitat(String Habitat) {
        this.Habitat = Habitat;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getForma() {
        return Forma;
    }

    public void setForma(String Forma) {
        this.Forma = Forma;
    }
    
}
