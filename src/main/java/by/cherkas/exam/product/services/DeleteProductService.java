package by.cherkas.exam.product.services;

import by.cherkas.exam.exceptions.ProductNotFoundException;
import by.cherkas.exam.product.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteProductService {

    private final ProductRepository repository;

    public DeleteProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Caching(
            evict = {
                    @CacheEvict(value = "productsCache", allEntries = true),
                    @CacheEvict(value = "productCache", allEntries = true)
            }
    )
    public ResponseEntity<Void> delete(UUID id) {
        if(repository.existsById(id)){

            repository.deleteById(id);

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new ProductNotFoundException();
    }
}
