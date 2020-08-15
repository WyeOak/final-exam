package com.example.exam.repository;

import com.example.exam.model.PlacePhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacePhotoRepository extends JpaRepository<PlacePhoto, Integer> {
    List<PlacePhoto> findAllByPlaceId(Integer placeId);
}
