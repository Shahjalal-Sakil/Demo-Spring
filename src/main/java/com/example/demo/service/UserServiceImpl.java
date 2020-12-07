package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUserByDevice_Id(long device_id) {
        return userRepository.findUsersByDevice_Id(device_id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
