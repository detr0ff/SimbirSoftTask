package com.example.task.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {


    public static String getProperty(String path, String key){
        Properties property = new Properties();
        try {
            FileInputStream fis = new FileInputStream(path);
            property.load(fis);
            return property.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Property file not found");
        }
    }
}
