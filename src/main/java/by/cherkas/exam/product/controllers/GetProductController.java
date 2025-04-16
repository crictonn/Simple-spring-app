package by.cherkas.exam.product.controllers;

import by.cherkas.exam.product.Product;
import by.cherkas.exam.product.services.GetProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class GetProductController {

    private final GetProductService getProductService;

    public GetProductController(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable UUID id){
        return getProductService.getProductById(id);
    }
}
