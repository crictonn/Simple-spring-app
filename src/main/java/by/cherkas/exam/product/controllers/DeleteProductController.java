package by.cherkas.exam.product.controllers;

import by.cherkas.exam.product.services.DeleteProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class DeleteProductController {
    private final DeleteProductService deleteProductService;

    public DeleteProductController(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }

    @DeleteMapping("/delete/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        return deleteProductService.delete(id);
    }
}
