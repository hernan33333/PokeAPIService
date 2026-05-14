package equipopokeapi.service.DAO;

import equipopokeapi.service.Ml.PokemonDTO;
import equipopokeapi.service.Ml.Result;


public interface IPokemon {
    Result ObtenerFavoritos(int IdUsuario);
    
    Result GetAllFavoritos();
    
    Result AgregarFavorito(int IdUsuario, PokemonDTO pokemon);
    
    boolean ConsultarPokemon(int IdPokemon);
    
    Result EliminarFavorito(int IdUsuario, int IdPokemon);
}
