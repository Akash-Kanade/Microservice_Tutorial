package com.ak.hotelservice.controller;

import com.ak.hotelservice.entity.Hotel;
import com.ak.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/hotels")
@RestController
public class HotelController {
@Autowired
    HotelService service;
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
    {
     return ResponseEntity.status(HttpStatus.CREATED).body(service.create(hotel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hotel> get(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.get(id));
    }

    @GetMapping()
    public ResponseEntity<List<Hotel>> gatAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }
}
