package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.DementiaDataResponse;

import java.util.List;

public interface DementiaDataService {
    List<DementiaDataResponse> findByYear(int year);
    List<DementiaDataResponse> findBySearch(int year, String si, String sigungu, String gender, String chartTitle);
}
