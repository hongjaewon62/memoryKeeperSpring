package com.memorykeeper.memoryKeeperSpring.controller;


import com.memorykeeper.memoryKeeperSpring.dto.ChartResponse;
import com.memorykeeper.memoryKeeperSpring.service.ChartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/charts")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // React 연동시 CORS 허용
public class ChartController {
    private final ChartService chartService;

    @GetMapping("/{chartCode}")
    public ChartResponse getChart(@PathVariable("chartCode") String chartCode) {
        return chartService.getChartData(chartCode);
    }
}
