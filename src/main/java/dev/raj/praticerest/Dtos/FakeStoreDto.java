package dev.raj.praticerest.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreDto {
    int Id;
    String title;
    int price;
    String Category;
    String description;
    String image;
}
