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
@Table(name = "usuario", uniqueConstraints = {
    @UniqueConstraint(name = "pk_idusuario", columnNames = {"IdUsuario"})
})
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private  Integer id_Usuario;
    @Column(name= "nombre")
    private String nombre;
    @Column(name ="contraseña")
    private String contraseña;
    @Column(name = "correo")        
    private String correo;
    
    @JoinColumn(name = "idrol")
    @ManyToOne
    private Rol rol;
    
    
    public Usuario() {
    }

    public Usuario(Integer id_Usuario, String nombre, String contraseña, String correo, Rol rol) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.correo = correo;
        this.rol = rol;
    }

    public Integer getIdUsuario() {
        return id_Usuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.id_Usuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
}
