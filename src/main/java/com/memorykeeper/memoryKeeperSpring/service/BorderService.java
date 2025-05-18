package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.BorderResponse;

import java.util.List;

public interface BorderService {
    List<BorderResponse> getBordersByCategory(String category);
    BorderResponse getBorderById(Integer id);
}
