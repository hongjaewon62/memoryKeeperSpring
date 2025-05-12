package com.memorykeeper.memoryKeeperSpring.repository;

import com.memorykeeper.memoryKeeperSpring.entity.CenterData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterDataRepository extends JpaRepository<CenterData, Integer> {
}
