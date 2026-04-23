/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;


public class Pokemon {
    private int IdPokemon;
    private String Nombre;
    private String PuntosSalud;
    private String Ataque;
    private String Defensa;
    private String AtaqueEspecial;
    private String DefensaEspecial;
    private String Velocidad;
    private String Peso;
    private String ExperienciaBase;
    private String Sonido;
    
    private Tipo tipo;
    
    private Region region;
    
    private Habilidad habilidad;

    public Pokemon() {
    }

    public Pokemon(int IdPokemon, String Nombre, String PuntosSalud, String Ataque, String Defensa, String AtaqueEspecial, String DefensaEspecial, String Velocidad, String Peso, 
            String ExperienciaBase, String Sonido,  Tipo tipo, Region region, Habilidad habilidad) {
        this.IdPokemon = IdPokemon;
        this.Nombre = Nombre;
        this.PuntosSalud = PuntosSalud;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.AtaqueEspecial = AtaqueEspecial;
        this.DefensaEspecial = DefensaEspecial;
        this.Velocidad = Velocidad;
        this.Peso = Peso;
        this.ExperienciaBase = ExperienciaBase;
        this.Sonido = Sonido;
        this.tipo = tipo;
        this.habilidad = habilidad;
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

    public String getPuntosSalud() {
        return PuntosSalud;
    }

    public void setPuntosSalud(String PuntosSalud) {
        this.PuntosSalud = PuntosSalud;
    }

    public String getAtaque() {
        return Ataque;
    }

    public void setAtaque(String Ataque) {
        this.Ataque = Ataque;
    }

    public String getDefensa() {
        return Defensa;
    }

    public void setDefensa(String Defensa) {
        this.Defensa = Defensa;
    }

    public String getAtaqueEspecial() {
        return AtaqueEspecial;
    }

    public void setAtaqueEspecial(String AtaqueEspecial) {
        this.AtaqueEspecial = AtaqueEspecial;
    }

    public String getDefensaEspecial() {
        return DefensaEspecial;
    }

    public void setDefensaEspecial(String DefensaEspecial) {
        this.DefensaEspecial = DefensaEspecial;
    }

    public String getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(String Velocidad) {
        this.Velocidad = Velocidad;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String Peso) {
        this.Peso = Peso;
    }

    public String getExperienciaBase() {
        return ExperienciaBase;
    }

    public void setExperienciaBase(String ExperienciaBase) {
        this.ExperienciaBase = ExperienciaBase;
    }

    public String getSonido() {
        return Sonido;
    }

    public void setSonido(String Sonido) {
        this.Sonido = Sonido;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Habilidad getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidad habilidad) {
        this.habilidad = habilidad;
    }
    
    

}
