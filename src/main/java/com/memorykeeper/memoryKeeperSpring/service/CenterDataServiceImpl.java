package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.CenterDataResponse;
import com.memorykeeper.memoryKeeperSpring.entity.CenterData;
import com.memorykeeper.memoryKeeperSpring.repository.CenterDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CenterDataServiceImpl implements CenterDataService{

    private final CenterDataRepository centerDataRepository;

    public CenterDataServiceImpl(CenterDataRepository centerDataRepository) {
        this.centerDataRepository = centerDataRepository;
    }

    @Override
    public List<CenterDataResponse> findAllCenters() {
        List<CenterData> centerData = centerDataRepository.findAll();
        return centerData.stream().map(CenterDataResponse::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CenterDataResponse> findBySearch(String roadnameaddress, String name) {
        roadnameaddress = (roadnameaddress != null && !roadnameaddress.trim().isEmpty()) ? roadnameaddress : null;
        name = (name != null && !name.trim().isEmpty()) ? name : null;

        List<CenterData> centers = centerDataRepository.searchCenters(roadnameaddress, name);
        return centers.stream()
                .map(CenterDataResponse::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CenterDataResponse> findByLocation(Double latitude, Double longitude) {
        return null;
    }
}
