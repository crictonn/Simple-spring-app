package by.cherkas.exam.product.services;

import by.cherkas.exam.product.Product;
import by.cherkas.exam.product.ProductRepository;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GetProductService {

    private final ProductRepository productRepository;

    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CachePut(value = "productsCache", key = "#id")
    public ResponseEntity<Product> getProductById(UUID id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent())
            return ResponseEntity.ok(optionalProduct.get());
        throw new RuntimeException();
    }
}
