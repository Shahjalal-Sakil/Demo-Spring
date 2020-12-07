package com.example.demo.service;

import com.example.demo.entity.Device;
import com.example.demo.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    DeviceRepository deviceRepository;

    @Override
    public void createDevice(Device device) {
        deviceRepository.save(device);
    }

    @Override
    public List<Device> getAllDevice() {
        return deviceRepository.findAll();
    }
}
