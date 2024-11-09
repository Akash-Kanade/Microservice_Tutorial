package com.ak.userservice.external.config;

import com.ak.userservice.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTELSERVICE")
public interface HotelClient {

    @GetMapping("hotels/{id}")
    Hotel getHotel(@PathVariable String id);

}
