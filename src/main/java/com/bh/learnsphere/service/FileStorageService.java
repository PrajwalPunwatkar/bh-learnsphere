package com.bh.learnsphere.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageService {

    @Value("${storage.video-path:uploads/videos}")
    private String videoDir;

    @Value("${storage.pdf-path:uploads/pdfs}")
    private String pdfDir;

    public String storeFile(MultipartFile file, String type) throws IOException {
        String directory = type.equalsIgnoreCase("video") ? videoDir : pdfDir;

        Path storagePath = Paths.get(directory).toAbsolutePath().normalize();
        Files.createDirectories(storagePath);

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path target = storagePath.resolve(fileName);

        Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        return fileName; // return only filename, not absolute path
    }
}
