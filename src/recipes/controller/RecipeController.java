package recipes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.dto.RecipeAddedResponse;
import recipes.dto.RecipeResponse;
import recipes.entity.Recipe;
import recipes.service.RecipeService;

@RestController
@RequestMapping("/api")
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(@Autowired RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity getRecipe(@PathVariable("id") Long id) {
        return recipeService.findRecipe(id);
    }

    @PostMapping("/recipe/new")
    public RecipeAddedResponse addRecipe(@RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }
}
