package dev.raj.praticerest.Controllers;

import dev.raj.praticerest.Dtos.FakeStoreDto;
import dev.raj.praticerest.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }


//---------------------------------products section--------------------------------------------------
    @GetMapping("/products")
    public List<FakeStoreDto> getAllproducts() {
        return productService.getAllProducts();
    }

// ---------------------------------single product section---------------------------------------------
    @GetMapping("/products/{productId}")
            public FakeStoreDto getSingleProduct(@PathVariable("productId") Long productId){
               FakeStoreDto fakestoresinle=   productService.getSingleProduct(productId);
                return fakestoresinle;

    }



//-----------------------------------------Add product section-----------------------------------------------------    //
    @PostMapping("/products/{productId}")
    public String addProduct(){
        return "love";
}
}
