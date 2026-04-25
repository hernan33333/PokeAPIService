/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;

import java.util.List;


public class Pokemon {
    private Integer IdPokemon;
    private String Nombre;
    private Integer PuntosSalud;
    private Integer Ataque;
    private Integer Defensa;
    private Integer AtaqueEspecial;
    private Integer DefensaEspecial;
    private Integer Velocidad;
    private Integer Peso;
    private Integer Altura;
    private Integer ExperienciaBase;
    private String Sonido;
    private String Region;
    private Sprites Sprites;
    
    private List<Tipo> Tipos;
    private List<Habilidad> Habilidades;

    public Pokemon() {
    }

    public Pokemon(Integer IdPokemon, String Nombre, Integer PuntosSalud, Integer Ataque, Integer Defensa, Integer AtaqueEspecial, Integer DefensaEspecial, Integer Velocidad, Integer Peso, Integer Altura, Integer ExperienciaBase, String Sonido, String Region, Sprites Sprites, List<Tipo> Tipos, List<Habilidad> Habilidades) {
        this.IdPokemon = IdPokemon;
        this.Nombre = Nombre;
        this.PuntosSalud = PuntosSalud;
        this.Ataque = Ataque;
        this.Defensa = Defensa;
        this.AtaqueEspecial = AtaqueEspecial;
        this.DefensaEspecial = DefensaEspecial;
        this.Velocidad = Velocidad;
        this.Peso = Peso;
        this.Altura = Altura;
        this.ExperienciaBase = ExperienciaBase;
        this.Sonido = Sonido;
        this.Region = Region;
        this.Sprites = Sprites;
        this.Tipos = Tipos;
        this.Habilidades = Habilidades;
    }

    public Integer getIdPokemon() {
        return IdPokemon;
    }

    public void setIdPokemon(Integer IdPokemon) {
        this.IdPokemon = IdPokemon;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getPuntosSalud() {
        return PuntosSalud;
    }

    public void setPuntosSalud(Integer PuntosSalud) {
        this.PuntosSalud = PuntosSalud;
    }

    public Integer getAtaque() {
        return Ataque;
    }

    public void setAtaque(Integer Ataque) {
        this.Ataque = Ataque;
    }

    public Integer getDefensa() {
        return Defensa;
    }

    public void setDefensa(Integer Defensa) {
        this.Defensa = Defensa;
    }

    public Integer getAtaqueEspecial() {
        return AtaqueEspecial;
    }

    public void setAtaqueEspecial(Integer AtaqueEspecial) {
        this.AtaqueEspecial = AtaqueEspecial;
    }

    public Integer getDefensaEspecial() {
        return DefensaEspecial;
    }

    public void setDefensaEspecial(Integer DefensaEspecial) {
        this.DefensaEspecial = DefensaEspecial;
    }

    public Integer getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(Integer Velocidad) {
        this.Velocidad = Velocidad;
    }

    public Integer getPeso() {
        return Peso;
    }

    public void setPeso(Integer Peso) {
        this.Peso = Peso;
    }

    public Integer getAltura() {
        return Altura;
    }

    public void setAltura(Integer Altura) {
        this.Altura = Altura;
    }

    public Integer getExperienciaBase() {
        return ExperienciaBase;
    }

    public void setExperienciaBase(Integer ExperienciaBase) {
        this.ExperienciaBase = ExperienciaBase;
    }

    public String getSonido() {
        return Sonido;
    }

    public void setSonido(String Sonido) {
        this.Sonido = Sonido;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public Sprites getSprites() {
        return Sprites;
    }

    public void setSprites(Sprites Sprites) {
        this.Sprites = Sprites;
    }

    public List<Tipo> getTipos() {
        return Tipos;
    }

    public void setTipos(List<Tipo> Tipos) {
        this.Tipos = Tipos;
    }

    public List<Habilidad> getHabilidad() {
        return Habilidades;
    }

    public void setHabilidad(List<Habilidad> Habilidades) {
        this.Habilidades = Habilidades;
    }

    

}
