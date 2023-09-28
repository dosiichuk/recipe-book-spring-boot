package recipes.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import recipes.dto.RecipeAddedResponse;
import recipes.dto.RecipeResponse;
import recipes.entity.Recipe;
import recipes.mapper.RecipeMapper;
import recipes.repositories.RecipeRepository;

import java.util.Optional;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private RecipeMapper recipeMapper;

    public RecipeService(RecipeRepository recipeRepository, RecipeMapper recipeMapper) {
        this.recipeRepository = recipeRepository;
        this.recipeMapper = recipeMapper;
    }

    public ResponseEntity findRecipe(Long id) {
        Optional<Recipe> recipeOpt = recipeRepository.findById(id);
        if (!recipeOpt.isPresent()) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok().body(recipeMapper.mapRecipeToRecipeResponse(recipeOpt.get()));
    }

    public RecipeAddedResponse addRecipe(Recipe recipe) {
        recipeRepository.save(recipe);
        return recipeMapper.mapRecipeToRecipeAddedResponse(recipe);
    }

    public ResponseEntity deleteRecipe(Long id) {
        Optional<Recipe> recipeOpt = recipeRepository.findById(id);
        if (!recipeOpt.isPresent()) {
            return ResponseEntity.status(404).body(null);
        }
        recipeRepository.deleteById(id);
        return ResponseEntity.status(204).body(null);
    }
}
