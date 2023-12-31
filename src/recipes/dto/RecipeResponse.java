package recipes.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponse {
    private String name;
    private String description;
    private String[] ingredients;
    private String[] directions;
}
