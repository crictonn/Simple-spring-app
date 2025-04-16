package by.cherkas.exam.product.services;

import by.cherkas.exam.product.Product;
import by.cherkas.exam.product.ProductRepository;
import by.cherkas.exam.validators.ProductValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SaveProductService {
    private final ProductRepository productRepository;

    public SaveProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Product> saveProduct(Product product){
        ProductValidator.execute(product);
        product.setCreationTime(new Date(System.currentTimeMillis()));
        product.setUpdateTime(product.getCreationTime());

        return ResponseEntity.ok(productRepository.save(product));
    }
}
