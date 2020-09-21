package com.example.demo.data.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.data.entity.Guest;

@Repository
//public interface GuestRepository extends JpaRepository<Guest, Long>{
public interface GuestRepository extends CrudRepository<Guest, Long>{
}
