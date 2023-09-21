package recipes.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import recipes.dto.RecipeAddedResponse;
import recipes.dto.RecipeResponse;
import recipes.entity.Recipe;
import recipes.mapper.RecipeMapper;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class RecipeService {
    private Map<Long, Recipe> recipeMap = new HashMap<>();
    private RecipeMapper recipeMapper;


    public ResponseEntity findRecipe(Long id) {
        Recipe recipe = recipeMap.get(id);
        if (recipe == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(recipeMapper.mapRecipeToRecipeResponse(recipe));
    }

    public RecipeAddedResponse addRecipe(Recipe recipe) {
        recipeMap.put(Recipe.currId - 1, recipe);
        return recipeMapper.mapRecipeToRecipeAddedResponse(recipe);
    }
}
