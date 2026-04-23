/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;


public class Region {
    private int IdRegion;
    private String Nombre;

    public Region() {
    }

    public Region(int IdRegion, String Nombre) {
        this.IdRegion = IdRegion;
        this.Nombre = Nombre;
    }

    public int getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(int IdRegion) {
        this.IdRegion = IdRegion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    

}
