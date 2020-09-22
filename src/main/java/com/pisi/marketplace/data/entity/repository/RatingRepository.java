package com.pisi.marketplace.data.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pisi.marketplace.data.entity.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

}