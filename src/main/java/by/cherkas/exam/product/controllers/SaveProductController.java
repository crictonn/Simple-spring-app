package by.cherkas.exam.product.controllers;

import by.cherkas.exam.product.Product;
import by.cherkas.exam.product.services.SaveProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaveProductController {

    private final SaveProductService saveProductService;

    public SaveProductController(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }

    @PostMapping("/save/product")
    public ResponseEntity<Product> saveUser(@RequestBody Product product){
        return saveProductService.saveProduct(product);
    }

}
