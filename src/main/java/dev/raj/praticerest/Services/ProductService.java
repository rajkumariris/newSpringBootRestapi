package dev.raj.praticerest.Services;

import dev.raj.praticerest.Dtos.FakeStoreDto;
import dev.raj.praticerest.Dtos.productDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public List<FakeStoreDto> getAllProducts();
    public FakeStoreDto getSingleProduct(Long productId);
    public productDto addProduct(productDto product);
    public productDto updateProduct(Long productId, productDto productdto);

    public productDto deleteProduct(Long productId);
}
