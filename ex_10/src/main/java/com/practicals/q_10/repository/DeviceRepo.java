package com.practicals.q_10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicals.q_10.model.Device;

public interface DeviceRepo extends JpaRepository<Device, Integer> {
    List<Device> findByUserId(int userId);
}
