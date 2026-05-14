/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;


public class Region {
    private     Integer IdRegion;
    private String Nombre;
    private Integer Generacion;

    public Region() {
    }

    public Region(int IdRegion, String Nombre) {
        this.IdRegion = IdRegion;
        this.Nombre = Nombre;
       
    }

    public Region(Integer IdRegion, String Nombre, Integer Generacion) {
        this.IdRegion = IdRegion;
        this.Nombre = Nombre;
        this.Generacion = Generacion;
    }
    

    public Integer getIdRegion() {
        return IdRegion;
    }

    public void setIdRegion(Integer IdRegion) {
        this.IdRegion = IdRegion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getGeneracion() {
        return Generacion;
    }

    public void setGeneracion(Integer Generacion) {
        this.Generacion = Generacion;
    }
    
    
    

}
