package com.ak.hotelservice.service;

import com.ak.hotelservice.entity.Hotel;
import com.ak.hotelservice.exception.ResourceNotFoundException;
import com.ak.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements  HotelService{

    @Autowired
    private HotelRepository repository;
    @Override
    public Hotel create(Hotel hotel) {
        String id = UUID.randomUUID().toString();
        hotel.setId(id);
        return repository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with "+id +" not found!!"));
    }
}
