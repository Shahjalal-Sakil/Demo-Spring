package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

     void createUser(User user);
     List<User> getUserByDevice_Id(long device_id);
     List<User> getUsers();


}
