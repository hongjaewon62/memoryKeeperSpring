package com.memorykeeper.memoryKeeperSpring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "charts")
public class Chart {        // 메인 차트
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "chart_code", nullable = false, unique = true)
    private String chartCode;

    @Column(name = "chart_type", nullable = false)
    private String chartType;
}
