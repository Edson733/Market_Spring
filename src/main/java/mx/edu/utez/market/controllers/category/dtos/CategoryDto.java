package mx.edu.utez.market.controllers.category.dtos;

import lombok.*;
import mx.edu.utez.market.models.category.Category;
import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;

    @NotEmpty(message = "Campo Obligatorio")
    @Size(min = 4, max = 150, message = "Debe ser entre 4 y 150 caracteres")
    private String name;

    private Boolean status;

    public Category castToCategory(){
        return new Category(getId(), getName(), getStatus(), null);
    }
}
