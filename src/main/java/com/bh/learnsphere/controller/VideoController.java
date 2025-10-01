package com.bh.learnsphere.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRange;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoController {

    private final Path videoStorage = Paths.get("uploads/videos");

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> streamVideo(@PathVariable String filename, @RequestHeader HttpHeaders headers) throws MalformedURLException {
        Path filePath = videoStorage.resolve(filename).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        List<HttpRange> ranges = headers.getRange();
        if (ranges.isEmpty()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_TYPE, "video/mp4")
                    .body(resource);
        }

        // If you want to handle partial streaming with ranges, you’ll need a custom implementation
        return new ResponseEntity<>(resource, HttpStatus.PARTIAL_CONTENT);
    }
}
