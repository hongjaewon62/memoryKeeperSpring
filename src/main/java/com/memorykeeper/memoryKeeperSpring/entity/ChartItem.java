package com.memorykeeper.memoryKeeperSpring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.memorykeeper.memoryKeeperSpring.dto.ChartItemResponse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "chart_items")
public class ChartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chart_id", nullable = false)
    private Chart chart;

    @Column(nullable = false)
    private String label;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false, length = 7)
    private String color;

    public ChartItemResponse toDTO() {
        return new ChartItemResponse(
                this.label,
                this.value,
                this.color
        );
    }
}
