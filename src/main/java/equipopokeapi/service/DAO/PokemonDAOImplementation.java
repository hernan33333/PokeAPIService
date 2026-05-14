package equipopokeapi.service.DAO;

import equipopokeapi.service.Ml.FavoritoDTO;
import equipopokeapi.service.Ml.PokemonDTO;
import equipopokeapi.service.Ml.Result;
import equipopokeapi.service.Ml.Usuario;
import jakarta.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PokemonDAOImplementation implements IPokemon {

    @Autowired
    private EntityManager entitimanager;

    @Override
    public Result ObtenerFavoritos(int IdUsuario) {
        Result Resultado = new Result();

        try {
            Resultado.objects = new ArrayList<>();

            List<PokemonDTO> Favoritos = entitimanager.createQuery("SELECT o FROM Usuario u JOIN u.Favoritos o WHERE u.id = :idUsuario", PokemonDTO.class)
                    .setParameter("idUsuario", IdUsuario)
                    .getResultList();

            Resultado.objects.addAll(Favoritos);

            Resultado.correct = true;
        } catch (Exception ex) {
            Resultado.correct = false;
            Resultado.errorMessage = ex.getLocalizedMessage();
            Resultado.ex = ex;
        }

        return Resultado;
    }

    @Override
    public Result GetAllFavoritos() {
        Result Resultado = new Result();

        String ruta = FavoritoDTO.class.getName();

        try {

            List<FavoritoDTO> pokemonsFavoritos = entitimanager.createQuery(""
                    + "SELECT new " + ruta + "(p, COUNT(u))"
                    + "FROM Pokemon p "
                    + "JOIN p.Usuarios u "
                    + "GROUP BY p "
                    + "ORDER BY COUNT(u) DESC",
                    FavoritoDTO.class)
                    .setMaxResults(5)
                    .getResultList();

            Resultado.objects = new ArrayList<>();
            Resultado.objects.addAll(pokemonsFavoritos);

            Resultado.correct = true;
        } catch (Exception ex) {
            Resultado.correct = false;
            Resultado.errorMessage = ex.getLocalizedMessage();
            Resultado.ex = ex;
        }

        return Resultado;
    }

    @Override
    @Transactional
    public Result AgregarFavorito(int IdUsuario, PokemonDTO pokemon) {
        Result Resultado = new Result();

        try {

            Usuario usuario = entitimanager.find(Usuario.class, IdUsuario);

            if (!ConsultarPokemon(pokemon.getIdPokemon())) {

                entitimanager.persist(pokemon);

            } else {

                entitimanager.merge(pokemon);

            }

            if (!usuario.Favoritos.contains(pokemon)) {

                usuario.Favoritos.add(pokemon);
            }

            Resultado.correct = true;
        } catch (Exception ex) {
            Resultado.correct = false;
            Resultado.errorMessage = ex.getLocalizedMessage();
            Resultado.ex = ex;
        }

        return Resultado;
    }

    @Override
    public boolean ConsultarPokemon(int IdPokemon) {

        PokemonDTO pokemon = entitimanager.find(PokemonDTO.class, IdPokemon);

        if (pokemon == null) {
            return false;
        }

        return true;
    }

    @Override
    @Transactional
    public Result EliminarFavorito(int IdUsuario, int IdPokemon) {
        Result Resultado = new Result();

        try {
            
            Usuario usuario = entitimanager.find(Usuario.class, IdUsuario);
            
            PokemonDTO pokemon = usuario.Favoritos.stream()
                    .filter(p -> p.getIdPokemon() == IdPokemon)
                    .findFirst()
                    .orElse(null);
            
            usuario.removeObjeto(pokemon);

            Resultado.correct = true;
        } catch (Exception ex) {
            Resultado.correct = false;
            Resultado.errorMessage = ex.getLocalizedMessage();
            Resultado.ex = ex;
        }

        return Resultado;
    }

    

}
