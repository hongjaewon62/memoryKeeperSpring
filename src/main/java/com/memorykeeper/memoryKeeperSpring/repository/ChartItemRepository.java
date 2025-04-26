package com.memorykeeper.memoryKeeperSpring.repository;

import com.memorykeeper.memoryKeeperSpring.entity.Chart;
import com.memorykeeper.memoryKeeperSpring.entity.ChartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChartItemRepository extends JpaRepository<ChartItem, Integer> {
    List<ChartItem> findByChart(Chart chart);
}
