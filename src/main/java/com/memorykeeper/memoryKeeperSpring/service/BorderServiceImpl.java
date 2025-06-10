package com.memorykeeper.memoryKeeperSpring.service;

import com.memorykeeper.memoryKeeperSpring.dto.BorderRequest;
import com.memorykeeper.memoryKeeperSpring.dto.BorderResponse;
import com.memorykeeper.memoryKeeperSpring.entity.Border;
import com.memorykeeper.memoryKeeperSpring.entity.User;
import com.memorykeeper.memoryKeeperSpring.repository.BorderRepository;
import com.memorykeeper.memoryKeeperSpring.repository.UserRepository;
import com.memorykeeper.memoryKeeperSpring.util.Base64ImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BorderServiceImpl implements BorderService{
    private final BorderRepository borderRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BorderResponse> getBordersByCategory(String category) {
        List<Border> borders = borderRepository.findByCategory(category);
        return borders.stream()
                .map(BorderResponse::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BorderResponse getBorderById(Integer id) {
        Border border = borderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));
        border.setViewCount(border.getViewCount() + 1);     // 조회수 증가
        return BorderResponse.toDto(border);
    }

    @Transactional
    public void deleteBorder(Integer id, Integer userId) {
        Border border = borderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        // 작성자 ID
        Integer writerId = border.getUser().getId();

        if (!writerId.equals(userId)) {
            throw new IllegalAccessError("작성자만 삭제할 수 있습니다.");
        }
        borderRepository.deleteById(id);
    }

    @Transactional
    public void updateBorder(Integer id, BorderRequest request) {
        Border border = borderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        //작성자 ID
        Integer writerId = border.getUser().getId();

        // 수정 시도한 사람
        Integer currentUserId = request.getUserId();

        if (!writerId.equals(currentUserId)) {
            throw new IllegalAccessError("작성자만 수정할 수 있습니다.");
        }

        border.setCategory(request.getCategory());
        border.setTitle(request.getTitle());
        border.setContent(request.getContent());
        borderRepository.save(border);
    }

    public void createBorder(BorderRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Border border = Border.builder()
                .category(request.getCategory())
                .title(request.getTitle())
                .content(request.getContent())
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();

        borderRepository.save(border);
    }
    /*
    @Override
    @Transactional
    public void createBorder(BorderRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        String content = request.getContent();
        String uploadDir = "src/main/resources/static/uploads"; // 또는 외부 경로

        // 이미지 태그 내 base64 추출 및 치환
        Pattern pattern = Pattern.compile("<img[^>]+src\\s*=\\s*\"(data:image/[^\">]+)\"");
        Matcher matcher = pattern.matcher(content);
        StringBuilder newContent = new StringBuilder();

        while (matcher.find()) {
            String base64Image = matcher.group(1);
            try {
                String imageUrl = Base64ImageUtil.saveBase64Image(base64Image, uploadDir);
                matcher.appendReplacement(newContent, "<img src=\"" + imageUrl + "\"");
            } catch (IOException e) {
                log.error("Base64 이미지 저장 실패", e);
            }
        }
        matcher.appendTail(newContent);

        Border border = Border.builder()
                .category(request.getCategory())
                .title(request.getTitle())
                .content(newContent.toString()) // 치환된 content 저장
                .user(user)
                .createdAt(LocalDateTime.now())
                .build();

        borderRepository.save(border);
    }
    */
}
