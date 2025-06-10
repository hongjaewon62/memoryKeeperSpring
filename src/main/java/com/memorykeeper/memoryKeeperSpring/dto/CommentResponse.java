package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentResponse {
    private Integer id;
    private String username;
    private Integer userId;
    private String content;
    private LocalDateTime createdAt;

    public static CommentResponse toDto(Comment comment) {
        CommentResponse dto = new CommentResponse();
        dto.setId(comment.getId());
        dto.setUsername(comment.getUser().getUsername());
        dto.setUserId(comment.getUser().getId());
        
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }

    public static Comment fromDto(CommentResponse dto, com.memorykeeper.memoryKeeperSpring.entity.Border border, com.memorykeeper.memoryKeeperSpring.entity.User user) {
        return Comment.builder()
                .id(dto.getId())
                .border(border)
                .user(user)
                .content(dto.getContent())
                .createdAt(dto.getCreatedAt())
                .build();
    }
}
