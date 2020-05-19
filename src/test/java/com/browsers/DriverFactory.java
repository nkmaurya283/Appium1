package com.browsers;

import com.properties.ConfigReader;
import com.common.component.ApiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    DesiredCapabilities capabilities;
    ConfigReader reader=null;
    //AppiumDriverLocalService service;
    AppiumDriver driver;
    //AndroidDriver appDriver;
    //IOSDriver iosDriver;
    AppiumDriverLocalService service;
    public static String accessKey = "LiCD6ivdvTsMkYkL5KJA";
    public static String userName = "navneetmaurya1";

/*    public  AndroidDriver capabilities() throws InterruptedException, MalformedURLException {
        capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;

    }*/
/*    public AndroidDriver initiliazes() throws InterruptedException, MalformedURLException {
        service= ApiumServer.startServer();
        Thread.sleep(4000);
        reader=new ConfigReader();
        capabilities=new DesiredCapabilities();
        capabilities.setCapability("no",true);
        capabilities.setCapability("newCommandTimeout", 100000);
        capabilities.setCapability("noReset", true);
        capabilities.setCapability("noRest", true);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, reader.getPlatform());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, reader.getDeviceName());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,reader.getAppPackage());
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,reader.getAppActivity());
        appDriver=new AndroidDriver(new URL(reader.getLocaHostPath()), capabilities);
        Thread.sleep(1000);
        return appDriver;
    }*/
/*    public  IOSDriver IOScapabilities() throws InterruptedException, MalformedURLException {
        capabilities=new DesiredCapabilities();
        reader=new ConfigReader();
        capabilities.setCapability("device", reader.getIosDevice());
        capabilities.setCapability("os_version", reader.getIosVersion());
        capabilities.setCapability("project", reader.getIosProject());
        capabilities.setCapability("build", reader.getIosBuild());
        capabilities.setCapability("name", reader.getIosTestName());
        capabilities.setCapability("app", reader.getIosApp());

        IOSDriver<IOSElement> iosDriver = new IOSDriver<IOSElement>(
                new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

        return iosDriver;

    }*/

    public AppiumDriver initiateDriver(String nameOfDriver) throws InterruptedException, MalformedURLException {
        service= ApiumServer.startServer();
        if(nameOfDriver.equals("AndriodApp")){
            Thread.sleep(4000);
            reader=new ConfigReader();
            capabilities=new DesiredCapabilities();
            capabilities.setCapability("no",true);
            capabilities.setCapability("newCommandTimeout", 100000);
            capabilities.setCapability("noReset", true);
            capabilities.setCapability("noRest", true);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, reader.getPlatform());
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, reader.getDeviceName());
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,reader.getAppPackage());
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,reader.getAppActivity());
            driver=new AndroidDriver(new URL(reader.getLocaHostPath()), capabilities);
            Thread.sleep(1000);
            //return appDriver;
        }
        else if (nameOfDriver.equals("AndroidChrome")){
            capabilities=new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
            driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            //return driver;

        }
        else if (nameOfDriver.equals("browserStack")){
            capabilities=new DesiredCapabilities();
            reader=new ConfigReader();
            capabilities.setCapability("device", reader.getIosDevice());
            capabilities.setCapability("os_version", reader.getIosVersion());
            capabilities.setCapability("project", reader.getIosProject());
            capabilities.setCapability("build", reader.getIosBuild());
            capabilities.setCapability("name", reader.getIosTestName());
            capabilities.setCapability("app", reader.getIosApp());

            driver = new IOSDriver<IOSElement>(
                    new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"), capabilities);

        }
        return driver;
    }
}
