package com.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties properties;
    private final String propertyFilePath = "src/test/resources/configuration.properties";
    //public String partialXpathPart3 = properties.getProperty("partialXpathPart1");
    //public String partialXpathPart4 = properties.getProperty("partialXpathPart2");

    public ConfigReader() {
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
    public String getLocaHostPath(){
        String localhostPath = properties.getProperty("localhost");
        if(localhostPath!= null) return localhostPath;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getDeviceName(){
        String emulatorName = properties.getProperty("DEVICE_NAME");
        if(emulatorName!= null) return emulatorName;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getAppPackage(){
        String appPackage = properties.getProperty("APP_PACKAGE");
        if(appPackage!= null) return appPackage;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getAppActivity(){
        String appActivity = properties.getProperty("APP_ACTIVITY");
        if(appActivity!= null) return appActivity;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getPlatform(){
        String appPlatForm = properties.getProperty("PLATFORM");
        if(appPlatForm!= null) return appPlatForm;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getIosDevice(){
        String iosDevice = properties.getProperty("DEVICE");
        if(iosDevice!= null) return iosDevice;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getIosVersion(){
        String iosVersion = properties.getProperty("OS_VERSION");
        if(iosVersion!= null) return iosVersion;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getIosProject(){
        String iosProject = properties.getProperty("PROJECT");
        if(iosProject!= null) return iosProject;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getIosBuild(){
        String iosBuild = properties.getProperty("BUILD");
        if(iosBuild!= null) return iosBuild;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getIosTestName(){
        String iosTestName = properties.getProperty("TEST_NAME");
        if(iosTestName!= null) return iosTestName;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getIosApp(){
        String iosApp = properties.getProperty("APP");
        if(iosApp!= null) return iosApp;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }
    public String getEnv(){
        String app = properties.getProperty("ENV_LOCAL");
        if(app!= null) return app;
        else throw new RuntimeException("LocalHost Path not specified in the Configuration.properties");
    }


}
