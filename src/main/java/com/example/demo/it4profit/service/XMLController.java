package com.example.demo.it4profit.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class XMLController {

    @GetMapping(produces = "text/xml")
    public String getXml() throws Exception{
        Path filename = Path.of("src/main/resources/xml/file2.xml");
        String rsp = Files.readString(filename);
        return rsp;
    }
}
