package com.appium.appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BrowserStackIOS {
    public static String accessKey = "LiCD6ivdvTsMkYkL5KJA";
    public static String userName = "navneetmaurya1";

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", "iPhone 11 Pro");
        caps.setCapability("os_version", "13");
        caps.setCapability("project", "My First Project");
        caps.setCapability("build", "My First Build");
        caps.setCapability("name", "Bstack-[Java] Sample Test");
        caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(
                new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), caps);

        IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
        textButton.click();
        IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys("Testing the field");

        //driver.findElementByAccessibilityId("Next").click();
        Thread.sleep(5000);

        IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));

        if (textOutput != null && textOutput.getText().equals("Testing the field"))
            assert (true);
        else
            assert (false);

        driver.quit();
    }
}
