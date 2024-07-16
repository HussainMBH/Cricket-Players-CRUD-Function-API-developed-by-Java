package com.dailycodebuffer.cricket.repository;

import com.dailycodebuffer.cricket.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Integer> {
    List<PlayerEntity> findAllByRole(String role);
}
