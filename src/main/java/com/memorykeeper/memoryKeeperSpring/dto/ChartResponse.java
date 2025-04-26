package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.Chart;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Slf4j
public class ChartResponse {
    private String chartType;
    private List<ChartItemResponse> items;

    public Chart toEntity(String chartCode) {
        Chart chart = new Chart();
        chart.setChartCode(chartCode);
        chart.setChartType(this.chartType);
        return chart;
    }
}
