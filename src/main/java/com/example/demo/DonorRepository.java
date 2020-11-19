package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor,Long> {

    @Query("select d from Donor d where d.bloodGroup = ?1")
    List<Donor> findByBloodGroup(String bloodGroup);

    Donor findById(long id);

    @Query(value = "select * from Donor order by id desc",nativeQuery = true)
    List<Donor> findAll();



}