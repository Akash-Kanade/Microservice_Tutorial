package com.ak.userservice.repository;

import com.ak.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
