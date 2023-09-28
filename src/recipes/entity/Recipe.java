package recipes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "recipe")
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotEmpty
    @NotNull
    @Size(min = 1)
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "position")
    private Ingredient[] ingredients;

    @NotEmpty
    @Size(min = 1)
    @OneToMany(cascade = CascadeType.ALL)
    @OrderColumn(name = "position")
    private Direction[] directions;

//    public Recipe() {
//        currId++;
//    }
//
//    public Recipe(Long id, String name, String description, Ingredient[] ingredients, Direction[] directions) {
//        this.id =  currId;
//        this.name = name;
//        this.description = description;
//        this.ingredients = ingredients;
//        this.directions = directions;
//        currId++;
//    }
}
