package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.DementiaDataResponse;

import java.util.List;

public interface DementiaDataService {
    List<DementiaDataResponse> findByYear(int year);
}
