package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.DementiaDataResponse;
import com.memorykeeper.memoryKeeperSpring.service.DementiaDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private final DementiaDataService dementiaDataService;

    public StatisticsController(DementiaDataService dementiaDataService) {
        this.dementiaDataService = dementiaDataService;
    }

    @GetMapping("/year/{year}")
    public List<DementiaDataResponse> getByYear(@PathVariable("year") int year) {
        return dementiaDataService.findByYear(year);
    }
}
