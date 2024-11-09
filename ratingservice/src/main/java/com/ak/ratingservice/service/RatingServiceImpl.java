package com.ak.ratingservice.service;

import com.ak.ratingservice.entity.Rating;
import com.ak.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    RatingRepository repository;
    @Override
    public Rating create(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return repository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return repository.findAll();
    }

    @Override
    public Rating getById(String id) {
        return null;
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String hotelId) {
        return repository.findByHotelId(hotelId);
    }
}
