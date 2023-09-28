package recipes.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "position")
    @JsonIgnore
    private Integer index;

    @NotEmpty
    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    public Direction(String description) {
        this.description = description;
    }
}
