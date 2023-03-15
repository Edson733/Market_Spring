package mx.edu.utez.market.controllers.person.dtos;

import lombok.*;
import mx.edu.utez.market.models.person.Person;
import mx.edu.utez.market.models.user.User;
import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDto {
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 40)
    private String name;

    private String surname;

    private String lastname;

    private String birthday;

    private String curp;

    private Boolean status;

    private String gender;

    private User user;

    public Person getPerson(){
        return new Person(getId(), getName(), getSurname(), getLastname(), getBirthday(), getCurp(), getStatus(), getGender(), getUser());
    }
}
