package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonorRepository extends CrudRepository<Donor,Long>{
    List<Donor> findByBloodGroup(String bloodGroup);
    Donor findById(long id);
    List<Donor> findAll();

}