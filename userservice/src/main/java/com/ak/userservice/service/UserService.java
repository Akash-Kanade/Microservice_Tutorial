package com.ak.userservice.service;

import com.ak.userservice.entity.User;

import java.util.List;

public interface UserService {

    //create
    User saveUser(User user);

    //get all  user
    List<User> getAll();

    //get single User
    User getUser(String id);

    // delete user
    User deleteUser(String id);

    // update user
    User updateUser(User user);
}
