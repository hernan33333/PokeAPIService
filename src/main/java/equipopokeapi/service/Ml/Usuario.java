/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", uniqueConstraints = {
    @UniqueConstraint(name = "pk_idusuario", columnNames = {"IdUsuario"})
})
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private  Integer idUsuario;
    @Column(name= "Nombre")
    private String nombre;
    @Column(name ="Contraseña")
    private String contraseña;
    @Column(name = "correo")        
    private String correo;
    
//
    
    
    public Usuario() {
    }

    public Usuario(Integer IdUsuario, String Nombre, String Cintraseña, String Correo) {
        this.idUsuario = IdUsuario;
        this.nombre = Nombre;
        this.contraseña = Cintraseña;
        this.correo = Correo;
//        this.rol = rol;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer IdUsuario) {
        this.idUsuario = IdUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.contraseña = Contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

//    public Rol getRol() {
//        return rol;
//    }
//
//    public void setRol(Rol rol) {
//        this.rol = rol;
//    }
    
    
}
