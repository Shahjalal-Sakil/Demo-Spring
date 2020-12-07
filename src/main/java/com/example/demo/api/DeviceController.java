package com.example.demo.api;

import com.example.demo.entity.Device;
import com.example.demo.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping(value = "/api/devices")
    public void createDevice(@RequestBody Device device)
    {
        deviceService.createDevice(device);
    }

    @GetMapping(value = "/api/devices")
    public List<Device> getAllDevice()
    {
        return deviceService.getAllDevice();
    }
}
