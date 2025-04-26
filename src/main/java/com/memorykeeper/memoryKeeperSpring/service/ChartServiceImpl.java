package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.ChartItemResponse;
import com.memorykeeper.memoryKeeperSpring.dto.ChartResponse;
import com.memorykeeper.memoryKeeperSpring.entity.Chart;
import com.memorykeeper.memoryKeeperSpring.entity.ChartItem;
import com.memorykeeper.memoryKeeperSpring.repository.ChartItemRepository;
import com.memorykeeper.memoryKeeperSpring.repository.ChartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChartServiceImpl implements ChartService{

    private final ChartRepository chartRepository;
    private final ChartItemRepository chartItemRepository;

    @Override
    public ChartResponse getChartData(String chartCode) {
        Chart chart = chartRepository.findByChartCode(chartCode)
                .orElseThrow(() -> new IllegalArgumentException("Chart not found"));

        List<ChartItem> items = chartItemRepository.findByChart(chart);
        List<ChartItemResponse> itemResponses = items.stream()
                .map(ChartItem::toDTO)
                .collect(Collectors.toList());

        return new ChartResponse(chart.getChartType(), itemResponses);
    }
}
