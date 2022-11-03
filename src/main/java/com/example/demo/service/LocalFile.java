package com.example.demo.service;

import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;

@Service
@Getter
public class LocalFile {
    private String file;
    public String createFile(String xml) throws Exception{
        file = xml;
//        File file = new File("/file.xml");
//        if(!file.exists()) file.createNewFile();
//        FileWriter fw = new FileWriter(file.getAbsoluteFile(),false);
//        fw.write(xml);
//        fw.close();
        return "";
    }
}
