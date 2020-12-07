package com.example.demo.api;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/api/users")
    public void createUser(@RequestBody User user)
    {
        userService.createUser(user);
    }

    @GetMapping(value = "/api/users")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }
    @GetMapping(value = "/api/users/deviceId/{deviceId}")
    public List<User> getUsersByDeviceId(@PathVariable long deviceId)
    {
        return userService.getUserByDevice_Id(deviceId);
    }

    @GetMapping(value = "/api/users/{id}")
    public User getUser(@PathVariable long id)
    {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/api/users/{id}")
    public void updateUser(@PathVariable long id, @RequestBody User user)
    {
        userService.updateUser(id,user);
    }

}
