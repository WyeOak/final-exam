package com.example.exam.DTO;

import com.example.exam.model.Place;
import lombok.*;


@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PlaceDTO {
    private int id;
    private String image;
    private String name;
    private String description;
    private double rating;

    public static PlaceDTO from(Place place) {
        return builder()
                .id(place.getId())
                .image(place.getImage())
                .name(place.getName())
                .description(place.getDescription())
                .rating(Math.round(place.getRating()*10)/10.0)
                .build();
    }
}
