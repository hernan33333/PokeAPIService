package equipopokeapi.service.Ml;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity(name = "Pokemon")
public class PokemonDTO {
    
    @Id
    @Column(name = "Idpokemon")
    private int IdPokemon;
    
    @Column(name = "Nombre")
    private String Nombre;

    @ManyToMany(mappedBy = "Favoritos")
    @JsonIgnore
    public List<Usuario> Usuarios;

    public PokemonDTO() {
    }

    public PokemonDTO(int IdPokemon, String Nombre, List<Usuario> Usuarios) {
        this.IdPokemon = IdPokemon;
        this.Nombre = Nombre;
        this.Usuarios = Usuarios;
    }
    
   
    public int getIdPokemon() {
        return IdPokemon;
    }

    public void setIdPokemon(int IdPokemon) {
        this.IdPokemon = IdPokemon;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
