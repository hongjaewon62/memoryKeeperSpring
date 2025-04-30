package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.DementiaDataResponse;
import com.memorykeeper.memoryKeeperSpring.entity.DementiaData;
import com.memorykeeper.memoryKeeperSpring.repository.DementiaDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DementiaDataServiceImpl implements DementiaDataService {

    private final DementiaDataRepository dementiaDataRepository;

    public DementiaDataServiceImpl(DementiaDataRepository dementiaDataRepository) {
        this.dementiaDataRepository = dementiaDataRepository;
    }

    @Override
    public List<DementiaDataResponse> findByYear(int year) {
        List<DementiaData> entities = dementiaDataRepository.findByYear(year);
        return entities.stream()
                .map(DementiaDataResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
