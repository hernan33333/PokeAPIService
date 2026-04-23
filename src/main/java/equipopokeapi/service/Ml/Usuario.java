/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;


public class Usuario {
    
    private int IdUsuario;
    private String Nombre;
    private String Cintraseña;
    private String Correo;
    
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int IdUsuario, String Nombre, String Cintraseña, String Correo, Rol rol) {
        this.IdUsuario = IdUsuario;
        this.Nombre = Nombre;
        this.Cintraseña = Cintraseña;
        this.Correo = Correo;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCintraseña() {
        return Cintraseña;
    }

    public void setCintraseña(String Cintraseña) {
        this.Cintraseña = Cintraseña;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
}
