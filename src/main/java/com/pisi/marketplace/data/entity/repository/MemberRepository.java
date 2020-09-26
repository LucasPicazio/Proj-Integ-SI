package com.pisi.marketplace.data.entity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pisi.marketplace.data.entity.Member;


//To work with Spring Data JPA repositories you don't need to implement them. You can just extend them:
//    public interface MyEntityRepo extends JpaRepository<MyEntity, Integer> {}
// where MyEntity is your entity which you want to store/read from the database, and Integer is a type of MyEntity primary key marked by @Id annotation:

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findMemberByUsername(String username);
}
