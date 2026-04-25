/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package equipopokeapi.service.DeserealizarJSON;

/**
 *
 * @author Alien 7
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonJSON {
    
    @JsonProperty("id")
    private Integer id;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("stats")
    private List<StatSlotJSON> stats;
    
    @JsonProperty("weight")
    private Integer weight;
    
    @JsonProperty("height")
    private Integer height;
    
    @JsonProperty("base_experience")
    private Integer baseExperience;
    
    @JsonProperty("cries")
    private CriesJSON cries;

    @JsonProperty("abilities")
    private List<AbilitySlotJSON> abilities;
    
    @JsonProperty("sprites")
    private SpritesJSON sprites;
    
    @JsonProperty("types")
    private List<TypeSlot> types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StatSlotJSON> getStats() {
        return stats;
    }

    public void setStats(List<StatSlotJSON> stats) {
        this.stats = stats;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public void setBaseExperience(Integer baseExperience) {
        this.baseExperience = baseExperience;
    }

    public CriesJSON getCries() {
        return cries;
    }

    public void setCries(CriesJSON cries) {
        this.cries = cries;
    }

    public List<AbilitySlotJSON> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<AbilitySlotJSON> abilities) {
        this.abilities = abilities;
    }

    public SpritesJSON getSprites() {
        return sprites;
    }

    public void setSprites(SpritesJSON sprites) {
        this.sprites = sprites;
    }

    public List<TypeSlot> getTypes() {
        return types;
    }

    public void setTypes(List<TypeSlot> types) {
        this.types = types;
    }
    
}
