package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.BorderResponse;
import com.memorykeeper.memoryKeeperSpring.entity.Border;
import com.memorykeeper.memoryKeeperSpring.repository.BorderRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BorderServiceImpl implements BorderService{
    private final BorderRepository borderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BorderResponse> getBordersByCategory(String category) {
        List<Border> borders = borderRepository.findByCategory(category);
        return borders.stream()
                .map(BorderResponse::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BorderResponse getBorderById(Integer id) {
        Border border = borderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        return BorderResponse.toDto(border);
    }
}
