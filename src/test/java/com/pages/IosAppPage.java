package com.pages;

import com.properties.ObjectRepositoryReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IosAppPage {

    @iOSXCUITFindBy(accessibility = "Text Button")
    private MobileElement id;
    @iOSXCUITFindBy(accessibility = "Text Input")
    private MobileElement textLocator;


    AppiumDriver driver;
    ObjectRepositoryReader obj=null;
    public IosAppPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    public void clickOnButton(String button){
        obj=new ObjectRepositoryReader();
        IOSElement ele= (IOSElement) driver.findElementByAccessibilityId(obj.accesibilityId());
        IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(ele));
        textButton.click();

    }
    public void passTheValueInTextBox(String keysToSend){
        IOSElement ele= (IOSElement) driver.findElementByAccessibilityId(obj.textLocator());
        IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(ele));
        textInput.sendKeys(keysToSend);
        String actual=textInput.getText();
        System.out.println("Actual one is"+actual);
        Assert.assertEquals(keysToSend,actual);

    }
    public void quitIosDriver(){
       driver.quit();
    }
}
