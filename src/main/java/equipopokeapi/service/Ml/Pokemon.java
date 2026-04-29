/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package equipopokeapi.service.Ml;

import java.util.List;


public class Pokemon {
    private Integer Id;
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
    private Generacion Generacion;
    private Sprites Sprites;
    
    private List<Tipo> Tipos;
    private List<Habilidad> Habilidades;
    private Especie Especie;

    public Pokemon(Integer Id, String Nombre, Integer PuntosSalud, Integer Ataque, Integer Defensa, Integer AtaqueEspecial, Integer DefensaEspecial, Integer Velocidad, Integer Peso, Integer Altura, Integer ExperienciaBase, String Sonido, Generacion Generacion, Sprites Sprites, List<Tipo> Tipos, List<Habilidad> Habilidades, Especie Especie) {
        this.Id = Id;
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
        this.Generacion = Generacion;
        this.Sprites = Sprites;
        this.Tipos = Tipos;
        this.Habilidades = Habilidades;
        this.Especie = Especie;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
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

    public Generacion getGeneracion() {
        return Generacion;
    }

    public void setGeneracion(Generacion Generacion) {
        this.Generacion = Generacion;
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

    public List<Habilidad> getHabilidades() {
        return Habilidades;
    }

    public void setHabilidades(List<Habilidad> Habilidades) {
        this.Habilidades = Habilidades;
    }

    public Especie getEspecie() {
        return Especie;
    }

    public void setEspecie(Especie Especie) {
        this.Especie = Especie;
    }

    

}
