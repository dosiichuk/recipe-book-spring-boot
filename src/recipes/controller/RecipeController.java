package recipes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recipes.dto.RecipeAddedResponse;
import recipes.dto.RecipeResponse;
import recipes.entity.Recipe;
import recipes.service.RecipeService;

import javax.validation.Valid;

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
    public RecipeAddedResponse addRecipe(@Valid @RequestBody Recipe recipe) {
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/recipe/{id}")
    public ResponseEntity deleteRecipe(@PathVariable("id") Long id) {
        return recipeService.deleteRecipe(id);
    }
}
