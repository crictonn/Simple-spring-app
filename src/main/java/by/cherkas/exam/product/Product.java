package by.cherkas.exam.product;

import by.cherkas.exam.category.Category;
import by.cherkas.exam.region.Regions;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;
    private Double price;
    private String manufacturer;

    @ManyToOne()
    private Category category;

    @Column(name = "created")
    private Date creationTime;

    @Column(name = "updated")
    private Date updateTime;

    @Enumerated
    private Regions region;
}
