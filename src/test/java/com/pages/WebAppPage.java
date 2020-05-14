package com.pages;

import com.browsers.Browsers;
import com.utility.ApiumServer;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class WebAppPage extends Browsers {

    @FindBy(xpath = "//input[@name='q']")
    public WebElement searchXpath;


    AndroidDriver driver;

    public WebAppPage(AndroidDriver driver){
        this.driver=driver;
    }

/*    public void initiliazeChromeDriver() throws InterruptedException, MalformedURLException {
        System.out.println("In webApp background");
        service= ApiumServer.startServer();
        Thread.sleep(4000);
        //driver=capabilities();
    }*/
    public void getURL(String url) throws InterruptedException, MalformedURLException {
        driver.get(url);
        Thread.sleep(2000);
    }
    public void keysToSearch(String text) throws InterruptedException {
        Thread.sleep(3000);
        //AndroidElement ele= (AndroidElement) chromedriver.findElementByXPath("//input[@name='q']");
        searchXpath.sendKeys(text);
        System.out.println("search xpath is"+searchXpath);
        Thread.sleep(3000);
    }
}
