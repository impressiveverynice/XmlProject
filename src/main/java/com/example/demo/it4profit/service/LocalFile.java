package com.example.demo.it4profit.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;

@Service
public class LocalFile {
    public String createFile(String xml) throws Exception{
        File file = new File("src/main/resources/xml/file2.xml");
        if(!file.exists()) file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile(),false);
        fw.write(xml);
        fw.close();
        return "";
    }
}
