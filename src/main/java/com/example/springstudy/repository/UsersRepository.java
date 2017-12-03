package com.example.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springstudy.Entities.User;

public interface UsersRepository extends JpaRepository<User, String> {

}
