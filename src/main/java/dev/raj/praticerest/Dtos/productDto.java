package dev.raj.praticerest.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class productDto {
    String title;
    int price;
    String description;
    String image;
    String category;
}
