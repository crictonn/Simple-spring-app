package by.cherkas.exam.product.services;

import by.cherkas.exam.category.Category;
import by.cherkas.exam.category.CategoryRepository;
import by.cherkas.exam.product.ProductDTO;
import by.cherkas.exam.product.ProductRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetAllProductsService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public GetAllProductsService(ProductRepository productRepository,
                                 CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Cacheable(value = "productsCache")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productRepository.findAllByOrderByPrice()
                        .stream()
                        .map(ProductDTO::new)
                        .toList()
                );
    }
    @Cacheable(value = "productsCache")
    public ResponseEntity<List<ProductDTO>> getAllWhereDesc(String desc){
        return ResponseEntity.ok(productRepository.findProductsByDescriptionContainingOrderByPrice(desc)
                .stream()
                .map(ProductDTO::new)
                .toList()
        );
    }

    @Cacheable(value = "productsCache")
    public ResponseEntity<List<ProductDTO>> getAllWhereCategory(String categoryName){
        Optional<Category> category = categoryRepository.findById(categoryName);
        if(category.isEmpty())
            throw new RuntimeException("Category does not exist");

        return ResponseEntity.ok(
                productRepository.findProductsByCategoryOrderByPrice(category.get())
                        .stream()
                        .map(ProductDTO::new)
                        .toList()
        );
    }
}
