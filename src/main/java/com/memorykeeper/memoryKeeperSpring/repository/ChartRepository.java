package com.memorykeeper.memoryKeeperSpring.repository;

import com.memorykeeper.memoryKeeperSpring.entity.Chart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChartRepository extends JpaRepository<Chart, Integer> {
    Optional<Chart> findByChartCode(String chartCode);
}
