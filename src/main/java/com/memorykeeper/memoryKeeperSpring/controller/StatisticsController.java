package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.DementiaDataResponse;
import com.memorykeeper.memoryKeeperSpring.service.DementiaDataService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public List<DementiaDataResponse> searchByConditions(
            @RequestParam("year") int year,
            @RequestParam(value="si", required = false, defaultValue = "전국") String si,
            @RequestParam(value="sigungu", required = false) String sigungu,
            @RequestParam(value="gender", required = false, defaultValue = "전체") String gender,
            @RequestParam("chartTitle") String chartTitle
    ) {

        String defaultSigungu = sigungu;
        if (sigungu.isEmpty()) {
            defaultSigungu = si;
        }
        return dementiaDataService.findBySearch(year, si, defaultSigungu, gender, chartTitle);
    }
}
