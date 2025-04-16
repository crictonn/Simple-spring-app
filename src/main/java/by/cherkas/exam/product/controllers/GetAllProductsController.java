package by.cherkas.exam.product.controllers;

import by.cherkas.exam.product.ProductDTO;
import by.cherkas.exam.product.services.GetAllProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllProductsController {
    private final GetAllProductsService getAllProductsService;

    public GetAllProductsController(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAll(){
        return getAllProductsService.getAllProducts();
    }

    @GetMapping("/products/description")
    public ResponseEntity<List<ProductDTO>> getAllDescription(@RequestParam String desc){
        return getAllProductsService.getAllWhereDesc(desc);
    }

    @GetMapping("/products/category")
    public ResponseEntity<List<ProductDTO>> getAllCategory(@RequestParam String category){
        return getAllProductsService.getAllWhereCategory(category);
    }
}
