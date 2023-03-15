package mx.edu.utez.market.models.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import mx.edu.utez.market.models.subcategory.Subcategory;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 150)
    private String name;

    @Column(name = "status",nullable = false, columnDefinition = "tinyint default 1")
    private Boolean status;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Subcategory> subcategories;
}
