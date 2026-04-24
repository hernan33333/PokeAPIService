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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Rol", uniqueConstraints = {
    @UniqueConstraint(name = "pk_idRol", columnNames = {"IdRol"})
})
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdRol")
private Integer idRol;
    @Column(name = "Nombre")
private String Nombre;

    public Rol() {
    }

    public Rol(Integer IdRol, String Nombre) {
        this.idRol = IdRol;
        this.Nombre = Nombre;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer IdRol) {
        this.idRol = IdRol;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }


}
