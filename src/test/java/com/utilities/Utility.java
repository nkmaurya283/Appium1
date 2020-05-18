package com.utilities;

import com.google.common.io.Files;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Utility {


    @Attachment(type = "image/png")
    public static byte[] screenshot(AppiumDriver driver)/* throws IOException */ {
        try {
            File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);
        } catch (IOException e) {
            return null;
        }
    }
}
