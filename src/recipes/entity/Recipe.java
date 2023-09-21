package recipes.entity;

import lombok.Data;

@Data
public class Recipe {
    public static Long currId = 0L;
    private Long id = currId;
    private String name;
    private String description;
    private Ingredient[] ingredients;
    private Direction[] directions;

    public Recipe() {
        currId++;
    }

    public Recipe(Long id, String name, String description, Ingredient[] ingredients, Direction[] directions) {
        this.id =  currId;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
        currId++;
    }
}
