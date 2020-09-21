package com.example.demo.data.entity.repository;

import com.example.demo.data.entity.Room;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


//To work with Spring Data JPA repositories you don't need to implement them. You can just extend them:
//    public interface MyEntityRepo extends JpaRepository<MyEntity, Integer> {}
// where MyEntity is your entity which you want to store/read from the database, and Integer is a type of MyEntity primary key marked by @Id annotation:

@Repository
public interface RoomRepository extends CrudRepository<Room, Long>{

}
