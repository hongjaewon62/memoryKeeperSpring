package com.memorykeeper.memoryKeeperSpring.repository;

import com.memorykeeper.memoryKeeperSpring.entity.DementiaData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DementiaDataRepository extends JpaRepository<DementiaData, Integer> {
    List<DementiaData> findByYear(int year);
}
