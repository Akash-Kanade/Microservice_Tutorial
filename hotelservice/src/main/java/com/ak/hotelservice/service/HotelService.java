package com.ak.hotelservice.service;

import com.ak.hotelservice.entity.Hotel;
import com.ak.hotelservice.exception.ResourceNotFoundException;

import java.util.List;

public interface HotelService {
     public Hotel create(Hotel hotel);
     public List<Hotel> getAll();
     public Hotel get(String id) throws ResourceNotFoundException;
}
