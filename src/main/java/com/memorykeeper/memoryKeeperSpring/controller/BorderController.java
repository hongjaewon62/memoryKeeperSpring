package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.BorderRequest;
import com.memorykeeper.memoryKeeperSpring.dto.BorderResponse;
import com.memorykeeper.memoryKeeperSpring.service.BorderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deleteBorder(@PathVariable("id") Integer id, @RequestParam("userId") Integer userId) {
        borderService.deleteBorder(id, userId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Void> updateBorder(@PathVariable("id") Integer id, @RequestBody BorderRequest request) {
        borderService.updateBorder(id, request);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> createBorder(@RequestBody BorderRequest request) {
        borderService.createBorder(request);
        return ResponseEntity.ok().build();
    }
}
