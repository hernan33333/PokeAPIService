/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;


public class Habilidad {
    private int IdHabilidad;
    private String Nombre;
    private String Efecto;

    public Habilidad() {
    }

    public Habilidad(int IdHabilidad, String Nombre, String Efecto) {
        this.IdHabilidad = IdHabilidad;
        this.Nombre = Nombre;
        this.Efecto = Efecto;
    }

    public int getIdHabilidad() {
        return IdHabilidad;
    }

    public void setIdHabilidad(int IdHabilidad) {
        this.IdHabilidad = IdHabilidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEfecto() {
        return Efecto;
    }

    public void setEfecto(String Efecto) {
        this.Efecto = Efecto;
    }
    
    

}
