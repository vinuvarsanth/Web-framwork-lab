package com.priyanshu.q_09.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanshu.q_09.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}