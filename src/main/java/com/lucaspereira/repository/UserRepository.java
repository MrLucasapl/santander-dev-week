package com.lucaspereira.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucaspereira.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}