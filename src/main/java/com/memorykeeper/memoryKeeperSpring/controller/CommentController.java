package com.memorykeeper.memoryKeeperSpring.controller;

import com.memorykeeper.memoryKeeperSpring.dto.CommentRequest;
import com.memorykeeper.memoryKeeperSpring.dto.CommentResponse;
import com.memorykeeper.memoryKeeperSpring.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/{borderId}")
    public List<CommentResponse> getComments(@PathVariable("borderId") Integer borderId) {
        return commentService.getCommentsByBorderId(borderId);
    }

    @PostMapping
    public ResponseEntity<Void> addComment(@RequestBody CommentRequest request) {
        commentService.addComment(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Integer commentId, @RequestParam("userId") Integer userId) {
        commentService.deleteComment(commentId, userId);
    }
}