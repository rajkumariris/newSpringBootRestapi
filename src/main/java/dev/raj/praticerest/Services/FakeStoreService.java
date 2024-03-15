package dev.raj.praticerest.Services;

import dev.raj.praticerest.Dtos.FakeStoreDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FakeStoreService implements ProductService{

    RestTemplateBuilder restTemplatebuilder;
   public FakeStoreService(RestTemplateBuilder restTemplateBuilder){
       this.restTemplatebuilder = restTemplateBuilder;

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


}
