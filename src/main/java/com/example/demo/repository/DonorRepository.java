package com.example.demo.repository;

import com.example.demo.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor,Long> {

    @Query("select d from Donor d where d.bloodGroup = ?1")
    List<Donor> findByBloodGroup(String bloodGroup);

    Donor findById(long id);

    @Query(value = "select * from Donor order by id desc",nativeQuery = true)
    List<Donor> findAll();

    Donor getDonorById(long id);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Donor d SET d.name = :name , d.bloodGroup =:bloodGroup, d.contact =:contact WHERE d.id=:id",nativeQuery = true)
    int updateDonor(@Param("name") String name, @Param("bloodGroup") String bloodGroup, @Param("contact") String contact,@Param("id") long id);

    void deleteById(long id);

}