package mx.edu.utez.market.controllers.user.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.user.User;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;

    @NotEmpty(message = "Campo Obligatorio")
    @Size(min = 4, max = 150, message = "Debe ser entre 4 y 150 caracteres")
    private String username;

    private Boolean status;

    private String password;

    private String lastAccess;

    private Boolean blocked;

    private String token;

    public User castToUser(){
        return new User(getId(), getUsername(), getPassword(), getStatus(), getLastAccess(), getBlocked(), getToken(), null, null);
    }
}
