package recipes.mapper;

import org.springframework.stereotype.Component;
import recipes.dto.RecipeAddedResponse;
import recipes.dto.RecipeResponse;
import recipes.entity.Recipe;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    public RecipeAddedResponse mapRecipeToRecipeAddedResponse(Recipe recipe) {
        return new RecipeAddedResponse(recipe.getId());
    }

    public RecipeResponse mapRecipeToRecipeResponse(Recipe recipe) {
        return new RecipeResponse(recipe.getName(),
                recipe.getDescription(),
                Arrays.stream(recipe.getIngredients()).map(ingredient -> ingredient.getName()).toArray(String[]::new),
                Arrays.stream(recipe.getDirections()).map(direction -> direction.getDescription()).toArray(String[]::new));
    }

}
