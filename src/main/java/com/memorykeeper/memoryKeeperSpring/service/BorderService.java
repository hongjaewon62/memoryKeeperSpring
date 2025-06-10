package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.BorderRequest;
import com.memorykeeper.memoryKeeperSpring.dto.BorderResponse;

import java.util.List;

public interface BorderService {
    List<BorderResponse> getBordersByCategory(String category);
    BorderResponse getBorderById(Integer id);
    void createBorder(BorderRequest request);
    void deleteBorder(Integer id, Integer userId);
    void updateBorder(Integer id, BorderRequest request);
}
