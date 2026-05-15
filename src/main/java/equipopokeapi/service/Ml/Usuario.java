package equipopokeapi.service.Ml;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "USUARIO", uniqueConstraints = {
    @UniqueConstraint(name = "pk_idusuario", columnNames = {"IdUsuario"})
})
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private  Integer id_Usuario;
    @Column(name= "nombre")
    private String nombre;
    @Column(name ="passwords")
    private String password;
    @Column(name = "correo")        
    private String correo;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "activation_token")
       private String activationToken;

    @Column(name  = "reset_token")
    private String resetToken;
    @Column(name = "reset_expiracion")
    private LocalDateTime ResetExpiracion;
    
    @ManyToOne
    @JoinColumn(name ="idrol")
    private Rol rol;
    
    @ManyToMany
    @JoinTable(
      name = "favorito", 
      joinColumns = @JoinColumn(name = "idusuario"), 
      inverseJoinColumns = @JoinColumn(name = "idpokemon")
    )
    public List<PokemonDTO> Favoritos;
    
    public void removeObjeto(PokemonDTO objeto) {
        this.Favoritos.remove(objeto);
        objeto.Usuarios.remove(this);
    }
    
    public Usuario() {
    }

    public Usuario(Integer id_Usuario, String nombre, String contraseña, String correo, Boolean activo, String activationToken, String ResetToken, LocalDateTime ResetExpiracion, Rol rol) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.password = contraseña;
        this.correo = correo;
        this.activo = activo;
        this.activationToken = activationToken;
        this.resetToken = ResetToken;
        this.ResetExpiracion = ResetExpiracion;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public String getActivationToken() {
        return activationToken;
    }

    public void setActivationToken(String activationToken) {
        this.activationToken = activationToken;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String ResetToken) {
        this.resetToken = ResetToken;
    }

    public LocalDateTime getResetExpiracion() {
        return ResetExpiracion;
    }

    public void setResetExpiracion(LocalDateTime ResetExpiracion) {
        this.ResetExpiracion = ResetExpiracion;
    }
}