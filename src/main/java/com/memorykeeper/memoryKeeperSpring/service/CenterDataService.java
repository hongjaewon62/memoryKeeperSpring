package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.CenterDataResponse;

import java.util.List;

public interface CenterDataService {
    List<CenterDataResponse> findAllCenters();
    List<CenterDataResponse> findBySearch(String roadnameaddress, String name);
    List<CenterDataResponse> findByLocation(Double latitude, Double longitude);
}
