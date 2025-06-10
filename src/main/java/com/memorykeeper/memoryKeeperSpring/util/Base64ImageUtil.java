package com.memorykeeper.memoryKeeperSpring.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class Base64ImageUtil {
    public static String saveBase64Image(String base64, String uploadDir) throws IOException {
        // "data:image/jpeg;base64,/9j/4AAQ..." 헤더 제거
        String[] parts = base64.split(",");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid base64 format");

        String mimePart = parts[0]; // data:image/jpeg;base64
        String dataPart = parts[1];

        String extension = mimePart.contains("jpeg") ? "jpg" :
                mimePart.contains("png") ? "png" :
                        mimePart.contains("gif") ? "gif" : "bin";

        byte[] imageBytes = Base64.getDecoder().decode(dataPart);
        String filename = UUID.randomUUID() + "." + extension;
        Path path = Paths.get(uploadDir, filename);

        Files.createDirectories(path.getParent());
        Files.write(path, imageBytes);

        return "/uploads/" + filename;
    }
}
