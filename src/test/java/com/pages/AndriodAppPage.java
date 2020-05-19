package com.pages;

import com.appium.interactions.WebDriverInteractions;
import com.properties.ConfigReader;
import com.properties.ObjectRepositoryReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static io.restassured.RestAssured.*;



public class AndriodAppPage extends ConfigReader {

    //private String partialXpathPart1="//android.widget.TextView[@text='";
    //private String partialXpathPart2="']";
    //@FindBy(id = "android:id/checkbox")
    //public WebElement checkBox;
    //@FindBy(className = "android.widget.EditText")
    //public WebElement className;



    AppiumDriver driver;
    ObjectRepositoryReader reader=null;
    WebDriverInteractions interactions=null;

    public AndriodAppPage(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void clickOnAnyMenuInDemoApp(String menuToClick) throws InterruptedException {
        reader=new ObjectRepositoryReader();
        interactions=new WebDriverInteractions();
       AndroidElement element= (AndroidElement) driver.findElementByXPath(reader.partialXpath1()+menuToClick+reader.partialXpath2());
       interactions.click(element);

        Thread.sleep(2000);
    }
    public String getValueFromApp(String textToValidate) throws InterruptedException {
        Thread.sleep(2000);
        String wifiText=driver.findElementByXPath(reader.partialXpath1()+textToValidate+reader.partialXpath2()).getText();
        wifi=wifiText;
        return wifiText;
    }
    public void checkBoxCheckIfNotChecked()  {
        WebElement ele=driver.findElementById(reader.checkBox());
        if(ele.getAttribute("checked").equals("true")){
        }else {
            //ele.click();
            interactions.click(ele);
        }
    }
    public void clickOnWifiSetting(String menuToClick) throws InterruptedException {
        driver.findElementByXPath(reader.partialXpath1()+menuToClick+reader.partialXpath2()).click();
        Thread.sleep(2000);
    }
    public void sendKeysInTextBox(String textToSend) throws InterruptedException {
        Thread.sleep(4000);
        WebElement element=driver.findElementByClassName(reader.classNameWebElement());
        //ele.sendKeys(textToSend);
        interactions.KeysToSend(element,textToSend);
        String actual= element.getText();
        System.out.println("Actual in app is"+actual);
        Assert.assertEquals(textToSend,actual);
    }


    //===============Apis=======================
    public static void contentType(){

        given().contentType(ContentType.JSON);
    }

    static String wifi;
    public static String getWifiText(){
        System.out.println("Wifi text is:-"+wifi);
        return wifi;
    }

}
