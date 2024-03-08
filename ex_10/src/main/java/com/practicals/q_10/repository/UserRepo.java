package com.practicals.q_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.practicals.q_10.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
