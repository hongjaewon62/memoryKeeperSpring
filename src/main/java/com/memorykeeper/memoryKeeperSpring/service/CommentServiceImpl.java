package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.CommentRequest;
import com.memorykeeper.memoryKeeperSpring.dto.CommentResponse;
import com.memorykeeper.memoryKeeperSpring.entity.Border;
import com.memorykeeper.memoryKeeperSpring.entity.Comment;
import com.memorykeeper.memoryKeeperSpring.entity.User;
import com.memorykeeper.memoryKeeperSpring.repository.BorderRepository;
import com.memorykeeper.memoryKeeperSpring.repository.CommentRepository;
import com.memorykeeper.memoryKeeperSpring.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final BorderRepository borderRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public List<CommentResponse> getCommentsByBorderId(Integer borderId) {
        List<Comment> comments = commentRepository.findByBorderId(borderId);
        return comments.stream()
                .map(CommentResponse::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addComment(CommentRequest request) {
        Border border = borderRepository.findById(request.getBorderId())
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저가 존재하지 않습니다."));

        Comment comment = request.toEntity(border, user);
        commentRepository.save(comment);
    }

    @Override
    @Transactional
    public void deleteComment(Integer commentId, Integer userId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않습니다."));

        if (!comment.getUser().getId().equals(userId)) {
            throw new IllegalAccessError("본인 댓글만 삭제할 수 있습니다.");
        }

        commentRepository.deleteById(commentId);
    }
}