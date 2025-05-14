package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.CenterDataResponse;
import com.memorykeeper.memoryKeeperSpring.service.CenterDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/search")
    public List<CenterDataResponse> searchCenters(
            @RequestParam(name="roadnameaddress", required = false) String roadnameaddress,
            @RequestParam(name = "name", required = false) String name) {

        roadnameaddress = (roadnameaddress != null && !roadnameaddress.trim().isEmpty()) ? roadnameaddress : null;
        name = (name != null && !name.trim().isEmpty()) ? name : null;

        return centerDataService.findBySearch(roadnameaddress, name);
    }
}
