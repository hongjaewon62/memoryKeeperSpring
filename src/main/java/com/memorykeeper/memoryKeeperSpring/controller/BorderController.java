package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.BorderResponse;
import com.memorykeeper.memoryKeeperSpring.service.BorderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/borders")
@RequiredArgsConstructor
public class BorderController {
    private final BorderService borderService;

    @GetMapping("/{category}")
    public List<BorderResponse> getBordersByCategory(@PathVariable("category") String category) {
        return borderService.getBordersByCategory(category);
    }

    @GetMapping("/id/{id}")
    public BorderResponse getBorderById(@PathVariable("id") Integer id) {
        return borderService.getBorderById(id);
    }
}
