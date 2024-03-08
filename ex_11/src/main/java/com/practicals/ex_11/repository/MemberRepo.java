package com.practicals.ex_11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicals.ex_11.model.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {
}
