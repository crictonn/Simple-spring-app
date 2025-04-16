package by.cherkas.exam.product.services;

import by.cherkas.exam.exceptions.ProductNotFoundException;
import by.cherkas.exam.product.Product;
import by.cherkas.exam.product.ProductRepository;
import by.cherkas.exam.validators.ProductValidator;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateProductService {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @CachePut(value = "productCache", key = "#id")
    public ResponseEntity<Product> updateProductById(UUID id, Product product){

        ProductValidator.execute(product);
        product.setId(id);
        product.setUpdateTime(new Date(System.currentTimeMillis()));

        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty())
            throw new ProductNotFoundException();

        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(product);
    }
}
