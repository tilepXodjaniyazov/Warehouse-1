package com.example.warehouse.controller;

import com.example.warehouse.Entity.Attachment;
import com.example.warehouse.Model.Result;
import com.example.warehouse.Servis.AttachmentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {
    @Autowired
    AttachmentService attachmentService;
    @PostMapping("/upload")
    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Result result = attachmentService.uploadFile(request);
        return result;
    }
    @GetMapping("/{id}")
    public void downlodeFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        attachmentService.downladeFile(id, response);
    }
    @GetMapping("/info")
    public List<Attachment> info(HttpServletResponse response) {
        List<Attachment> info = attachmentService.getInfo(response);
        return info;
    }

}
