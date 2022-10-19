package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class XMLController {
    @Autowired
    private LocalFile file;

    @GetMapping(produces = "text/xml")
    public String getXml() throws Exception{
//        Path filename = Path.of("src\\main\\resources\\xml\\file.xml");
//        String rsp = Files.readString(filename);
        return file.getFile();
    }
}
