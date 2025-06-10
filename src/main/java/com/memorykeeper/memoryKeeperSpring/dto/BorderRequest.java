package com.memorykeeper.memoryKeeperSpring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BorderRequest {
    private String category;
    private String title;
    private String content;
    private Integer userId;
}