package com.memorykeeper.memoryKeeperSpring.dto;

import com.memorykeeper.memoryKeeperSpring.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private Integer borderId;
    private Integer userId;
    private String content;

    public Comment toEntity(com.memorykeeper.memoryKeeperSpring.entity.Border border, com.memorykeeper.memoryKeeperSpring.entity.User user) {
        return com.memorykeeper.memoryKeeperSpring.entity.Comment.builder()
                .border(border)
                .user(user)
                .content(content)
                .createdAt(java.time.LocalDateTime.now())
                .build();
    }
}
