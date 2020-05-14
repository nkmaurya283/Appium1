package com.browsers;

import com.utility.ApiumServer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Browsers {

    DesiredCapabilities capabilities;
    //AppiumDriverLocalService service;
    AndroidDriver driver;
    AndroidDriver appDriver;
    IOSDriver iosDriver;
    AppiumDriverLocalService service;
    public static String accessKey = "LiCD6ivdvTsMkYkL5KJA";
    public static String userName = "navneetmaurya1";

    public  AndroidDriver capabilities() throws InterruptedException, MalformedURLException {
        capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;

    }
    public AndroidDriver initiliazes() throws InterruptedException, MalformedURLException {
        service= ApiumServer.startServer();
        Thread.sleep(4000);
        capabilities=new DesiredCapabilities();
        capabilities.setCapability("no",true);
        capabilities.setCapability("newCommandTimeout", 100000);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("noRest", true);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3a");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.appium.android.apis");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.appium.android.apis.ApiDemos");
        //capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Navneet\\Desktop\\Appium\\Andriod\\apk\\ApiDemos-debug.apk");
        appDriver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(1000);
        return appDriver;
    }
    public  IOSDriver IOScapabilities() throws InterruptedException, MalformedURLException {
        capabilities=new DesiredCapabilities();
        capabilities.setCapability("device", "iPhone 11 Pro");
        capabilities.setCapability("os_version", "13");
        capabilities.setCapability("project", "My First Project");
        capabilities.setCapability("build", "My First Build");
        capabilities.setCapability("name", "Bstack-[Java] Sample Test");
        capabilities.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");

        IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(
                new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

        return iosDriver;

    }
}
