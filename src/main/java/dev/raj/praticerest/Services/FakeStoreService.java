package dev.raj.praticerest.Services;

import dev.raj.praticerest.Dtos.FakeStoreDto;
import dev.raj.praticerest.Dtos.productDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;


@Service
public class FakeStoreService implements ProductService{

    RestTemplateBuilder restTemplatebuilder;
   public FakeStoreService(RestTemplateBuilder restTemplateBuilder){
       this.restTemplatebuilder = restTemplateBuilder;

   }
   //---------------------------------------------resonseentity for any request --------------------------------

    public <T> ResponseEntity<T> responseentity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType ,Object... uriVariables)
            throws RestClientException {
        RestTemplate restTemplate = restTemplatebuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
//-------------------------------------reponse entity for delete ----------------------------------------------------

    public <T> ResponseEntity<T> responseEntitydelete(HttpMethod httpMethod, String url, Class<T> responseType, Object... uriVariables){
       RestTemplate restTemplate = restTemplatebuilder.requestFactory(HttpComponentsClientHttpRequestFactory.class).build();
       ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
       return restTemplate.execute(url, httpMethod,null, responseExtractor,uriVariables);
    }
    //?------------------------------------getallproducts section_------------------------------------------------
    public List<FakeStoreDto> getAllProducts(){
        List<FakeStoreDto> answer = new ArrayList<>();
        RestTemplate resttemplate = restTemplatebuilder.build();
        ResponseEntity<FakeStoreDto[]> responseEntity =  resttemplate.getForEntity("https://fakestoreapi.com/products", FakeStoreDto[].class);
        for( FakeStoreDto fakeStoreDto : responseEntity.getBody()){
                answer.add(fakeStoreDto);
        }

        return answer;
    }


    //--------------------------------------------------single product section--------------------------------------------

    @Override
    public FakeStoreDto  getSingleProduct(Long productId) {
       RestTemplate restTemplate = restTemplatebuilder.build();
       ResponseEntity<FakeStoreDto> fakeStoreresponse =restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreDto.class, productId);
       FakeStoreDto fakeStoreproductsingle = fakeStoreresponse.getBody();
        return  fakeStoreproductsingle;
    }

    public productDto addProduct(productDto Product){
       RestTemplate restTemplate = restTemplatebuilder.build();
      ResponseEntity<productDto> responseadd =  restTemplate.postForEntity("https://fakestoreapi.com/products", Product, productDto.class);
       productDto Productadded = responseadd.getBody();
       return Productadded;
    }
    //-----------------------------------------------update product section--------------------------

    public productDto updateProduct( Long productId, productDto productdto){
     ResponseEntity<productDto> updatedproduct  = responseentity(HttpMethod.PUT, "https://fakestoreapi.com/products/{id}",productdto, productDto.class,productId);
       productDto productupdated =  updatedproduct.getBody();
       return  productupdated;
   }

   //------------------------------------------------delete product service--------------------------------------
    public productDto deleteProduct(Long productId){
        RestTemplate restTemplate = restTemplatebuilder.build();
         ResponseEntity<productDto> deletedproduct =  responseentity(HttpMethod.DELETE, "https://fakestoreapi.com/products/{id}",null,  productDto.class, productId);
         productDto productdeleted = deletedproduct.getBody();
         return productdeleted;

    }



}
