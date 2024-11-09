package com.ak.ratingservice.service;

import com.ak.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating create(Rating rating);

    List<Rating> getAll();

    Rating getById(String id);

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
