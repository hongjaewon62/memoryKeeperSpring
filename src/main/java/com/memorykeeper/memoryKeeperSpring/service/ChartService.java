package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.ChartResponse;

public interface ChartService {
    ChartResponse getChartData(String chartCode);
}
