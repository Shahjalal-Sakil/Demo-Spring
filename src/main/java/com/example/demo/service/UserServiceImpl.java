package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User getUserById(long id) {
        Optional<User> response = userRepository.findById(id);
        return response.get();

    }

    @Override
    public void updateUser(long id, User user) {
        User userToBeUpdated = getUserById(id);

        userToBeUpdated.setAge(user.getAge());
        userRepository.save(userToBeUpdated);
    }
}
