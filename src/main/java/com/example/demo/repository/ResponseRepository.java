package com.example.demo.repository;

import com.example.demo.entity.Response;

import java.util.Optional;
import java.util.UUID;

public interface ResponseRepository {
    void save(Response response);
    Response findById(UUID id);
}
