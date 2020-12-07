package com.example.demo.service;

import com.example.demo.entity.Device;

import java.util.List;

public interface DeviceService {
    void createDevice(Device device);
    List<Device> getAllDevice();
}
