package com.bh.learnsphere.controller;

import com.bh.learnsphere.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/upload")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileStorageService storageService;

    @PostMapping("/video")
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) {
        try {
            String filename = storageService.storeFile(file, "video");
            return ResponseEntity.ok("/api/videos/" + filename); // return accessible URL
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Video upload failed: " + e.getMessage());
        }
    }

    @PostMapping("/pdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
        try {
            String filename = storageService.storeFile(file, "pdf");
            return ResponseEntity.ok("/api/pdfs/" + filename); // return accessible URL
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("PDF upload failed: " + e.getMessage());
        }
    }
}

