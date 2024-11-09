package com.ak.userservice.service;

import com.ak.userservice.entity.Hotel;
import com.ak.userservice.entity.Rating;
import com.ak.userservice.entity.User;
import com.ak.userservice.exception.ResourceNotFoundException;
import com.ak.userservice.external.config.HotelClient;
import com.ak.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository repository;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HotelClient client;
    @Override
    public User saveUser(User user) {
        String uid = UUID.randomUUID().toString();
        user.setUserId(uid);
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getUser(String id) {
        System.out.println("********** Fetching the ratings");
        User u = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource with "+id +" not found!!"));
        Rating [] rating = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+ u.getUserId(), Rating[].class);
        System.out.println("Rating fetched!!! Fetching hotel for rating");
        log.info("*************Trying to logging rating ***************************:\n{}",rating);
        List<Rating> RWH = Arrays.stream(rating).map(r -> {
//            ResponseEntity<Hotel> hot = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+ r.getHotelId(), Hotel.class);
//            Hotel hotel = hot.getBody();
            Hotel hotel = client.getHotel(r.getHotelId());
            r.setHotel(hotel);
            return r;
        }).toList();
        u.setRatings(RWH);
        return u;

    }

    @Override
    public User deleteUser(String id) {
        User u = repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Resource not found with "+id));
        repository.delete(u);
        return u;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
