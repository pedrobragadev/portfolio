package com.pbd.gifty.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.lang.invoke.MethodHandles;

@RestController
public class UploadController {

    private final static Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${multipart.location}")
    private String location;

    @PostMapping(value = "/upload", produces = MediaType.IMAGE_GIF_VALUE)
    public String upload(@RequestPart("file") MultipartFile file,
                         @RequestParam("start") int start,
                         @RequestParam("end") int end,
                         @RequestParam("speed") int speed,
                         @RequestParam("repeat") boolean repeat) {


        return "";
    }
}
