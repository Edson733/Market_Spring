package mx.edu.utez.market.models.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.market.models.subcategory.Subcategory;

import javax.persistence.*;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(columnDefinition = "text")
    private String description;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fileBlob", columnDefinition = "longblob")
    private byte[] fileBase64;
    private int cuantity;
    private double price;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;
}
