package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.Chart;
import com.memorykeeper.memoryKeeperSpring.entity.ChartItem;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString @Slf4j
public class ChartItemResponse {
    private String label;
    private Double value;
    private String color;

    public ChartItem toEntity(Chart chart) {
        ChartItem item = new ChartItem();
        item.setChart(chart);
        item.setLabel(this.label);
        item.setValue(this.value);
        item.setColor(this.color);
        return item;
    }

    public static ChartItemResponse fromEntity(ChartItem item) {
        return new ChartItemResponse(
                item.getLabel(),
                item.getValue(),
                item.getColor()
        );
    }
}
