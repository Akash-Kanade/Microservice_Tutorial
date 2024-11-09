package com.ak.ratingservice.controller;

import com.ak.ratingservice.entity.Rating;
import com.ak.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    RatingService service;
    //create rating
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {

        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId)
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByHotelId(hotelId));
    }



}
