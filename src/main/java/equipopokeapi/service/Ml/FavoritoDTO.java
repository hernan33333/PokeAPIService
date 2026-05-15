package equipopokeapi.service.Ml;


public class FavoritoDTO {
    private PokemonDTO Pokemon;
    private Long cantidad;

    public FavoritoDTO() {
    }

    public FavoritoDTO(PokemonDTO Pokemon, Long cantidad) {
        this.Pokemon = Pokemon;
        this.cantidad = cantidad;
    }

    public PokemonDTO getPokemon() {
        return Pokemon;
    }

    public void setPokemon(PokemonDTO Pokemon) {
        this.Pokemon = Pokemon;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
