package by.cherkas.exam.product;

import by.cherkas.exam.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findProductsByDescriptionContainingOrderByPrice(String desc);
    List<Product> findProductsByCategoryOrderByPrice(Category category);
    List<Product> findAllByOrderByPrice();
}
