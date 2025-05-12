package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.CenterDataResponse;
import com.memorykeeper.memoryKeeperSpring.service.CenterDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/centers")
public class CenterDataController {

    private  final CenterDataService centerDataService;

    public CenterDataController(CenterDataService centerDataService) {
        this.centerDataService = centerDataService;
    }

    @GetMapping
    public List<CenterDataResponse> findAllCenters() {
        return centerDataService.findAllCenters();
    }
}
