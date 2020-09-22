package com.pisi.marketplace.data.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pisi.marketplace.data.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
//public interface GuestRepository extends CrudRepository<Guest, Long>{
}
