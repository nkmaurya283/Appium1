package com.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class ObjectRepositoryReader {

    Properties properties;
    private final String propertyFilePath = "C:\\Users\\Navneet\\Downloads\\Compressed\\original\\Appium1\\src\\test\\resources\\application.properties";

    public ObjectRepositoryReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String partialXpath1(){
        String partialXpathPart1 = properties.getProperty("partialXpathPart1");
        if(partialXpathPart1!= null) return partialXpathPart1;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String partialXpath2(){
        String partialXpath2 = properties.getProperty("partialXpathPart2");
        if(partialXpath2!= null) return partialXpath2;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String checkBox(){
        String checkBox = properties.getProperty("checkBox");
        if(checkBox!= null) return checkBox;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String classNameWebElement(){
        String className = properties.getProperty("className");
        if(className!= null) return className;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String accesibilityId(){
        String accesibilityId = properties.getProperty("id");
        if(accesibilityId!= null) return accesibilityId;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String textLocator(){
        String textLocator = properties.getProperty("textLocator");
        if(textLocator!= null) return textLocator;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
}
