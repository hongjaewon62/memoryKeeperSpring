package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.CommentRequest;
import com.memorykeeper.memoryKeeperSpring.dto.CommentResponse;

import java.util.List;

public interface CommentService {
    List<CommentResponse> getCommentsByBorderId(Integer borderId);
    void addComment(CommentRequest request);
    void deleteComment(Integer commentId, Integer userId);
}
