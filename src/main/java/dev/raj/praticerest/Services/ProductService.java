package dev.raj.praticerest.Services;

import dev.raj.praticerest.Dtos.FakeStoreDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public List<FakeStoreDto> getAllProducts();
    public FakeStoreDto getSingleProduct(Long productId);
}
