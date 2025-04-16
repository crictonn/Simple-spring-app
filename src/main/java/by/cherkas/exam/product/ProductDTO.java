package by.cherkas.exam.product;

import by.cherkas.exam.category.Category;
import by.cherkas.exam.region.Regions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProductDTO {
    private UUID id;
    private String name;
    private String description;
    private Double price;
    private String manufacturer;
    private Category category;
    private Regions region;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.manufacturer = product.getManufacturer();
        this.category = product.getCategory();
        this.region = product.getRegion();
    }
}
