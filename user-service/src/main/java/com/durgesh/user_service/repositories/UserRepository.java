package com.durgesh.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.durgesh.user_service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
