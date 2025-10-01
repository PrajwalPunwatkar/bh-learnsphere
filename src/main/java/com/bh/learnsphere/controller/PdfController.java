package com.bh.learnsphere.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/pdfs")
public class PdfController {

    private final Path pdfStorage = Paths.get("uploads/pdfs");

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getPdf(@PathVariable String filename) throws MalformedURLException {
        Path filePath = pdfStorage.resolve(filename).normalize();
        Resource resource = new UrlResource(filePath.toUri());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(resource);
    }
}
