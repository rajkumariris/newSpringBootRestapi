package dev.raj.praticerest.Controllers;

import dev.raj.praticerest.Dtos.FakeStoreDto;
import dev.raj.praticerest.Dtos.productDto;
import dev.raj.praticerest.Services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/products")
    public productDto addProduct(@RequestBody productDto product ){
        productDto productaddedone =  productService.addProduct(product);
      return productaddedone;
}


//-------------------------------------------update product section-----------------------------------------------------------------
    @PutMapping ("/products/{productId}")
    public productDto updateProduct(@PathVariable("productId") Long productId, @RequestBody productDto productdto){
       productDto productupdated=  productService.updateProduct(productId, productdto);
       return productupdated;
    }

    @DeleteMapping ("/products/{productId}")
    public productDto deleteproduct(@PathVariable("productId") Long productId){
        productDto deltedproduct = productService.deleteProduct(productId);
        return deltedproduct;
    }
}
