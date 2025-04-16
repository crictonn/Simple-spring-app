package by.cherkas.exam.product.controllers;

import by.cherkas.exam.product.Product;
import by.cherkas.exam.product.services.UpdateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UpdateProductController {

    private final UpdateProductService updateProductService;

    public UpdateProductController(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }

    @PutMapping("product/{id}")
    public ResponseEntity<Product> updateProductById(@PathVariable UUID id, @RequestBody Product product){
        return updateProductService.updateProductById(id, product);
    }
}
