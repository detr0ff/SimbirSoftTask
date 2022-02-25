package com.example.task.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String propertyFilePath = "src/test/resources/config.properties";

    public static String getProperty(String key){
        Properties property = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propertyFilePath);
            property.load(fis);
            return property.getProperty(key);
        } catch (IOException e) {
            throw new RuntimeException("Property file not found");
        }
    }
}
