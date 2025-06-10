package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.Border;
import com.memorykeeper.memoryKeeperSpring.entity.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BorderResponse {
    private Integer id;
    private String category;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private int viewCount;
    private boolean isFixed;
    private Integer userId;

    public static BorderResponse toDto(Border border) {
        return BorderResponse.builder()
                .id(border.getId())
                .category(border.getCategory())
                .title(border.getTitle())
                .content(border.getContent())
                .username(border.getUser().getUsername())
                .userId(border.getUser().getId())
                .createdAt(border.getCreatedAt())
                .viewCount(border.getViewCount())
                .isFixed(border.isFixed())
                .build();
    }

    public static Border fromDto(BorderResponse dto) {
        return Border.builder()
                .id(dto.getId())
                .category(dto.getCategory())
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdAt(dto.getCreatedAt())
                .viewCount(dto.getViewCount())
                .isFixed(dto.isFixed())
                .build();
    }
}
