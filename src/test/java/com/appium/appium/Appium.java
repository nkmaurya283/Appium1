package com.appium.appium;/*
package com.appium.appium;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class Appium {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Demo");
        cap.setCapability(MobileCapabilityType.APP, "C:\\Users\\Navneet\\Desktop\\Appium\\Andriod\\apk\\ApiDemos-debug.apk");
        //AndroidDriver  driver=new AndroidDriver(new URL("http://192.168.0.2:4723/wd/hub"), cap);
       // AndroidDriver  driver=new AndroidDriver(new URL("http://192.168.81.1:4723/wd/hub"), cap);
        AndroidDriver  driver=new AndroidDriver(new URL("http://192.168.1.3:4723/wd/hub"), cap);

    }

}
*/
