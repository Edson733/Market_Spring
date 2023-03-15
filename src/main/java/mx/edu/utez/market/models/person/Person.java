package mx.edu.utez.market.models.person;

import lombok.*;
import mx.edu.utez.market.models.user.User;
import javax.persistence.*;

@Entity
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    private String lastname;

    private String birthday;

    @Column(unique = true)
    private String curp;

    private Boolean status;

    private String gender;

    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private User user;
}
