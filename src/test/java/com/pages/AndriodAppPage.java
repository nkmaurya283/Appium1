package com.pages;

import io.appium.java_client.android.AndroidDriver;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static io.restassured.RestAssured.*;



public class AndriodAppPage {

    private String partialXpathPart1="//android.widget.TextView[@text='";
    private String partialXpathPart2="']";
    @FindBy(id = "android:id/checkbox")
    public WebElement checkBox;
    @FindBy(className = "android.widget.EditText")
    public WebElement className;



    AndroidDriver driver;

    public AndriodAppPage(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public void clickOnAnyMenuInDemoApp(String menuToClick) throws InterruptedException {
        driver.findElementByXPath(partialXpathPart1+menuToClick+partialXpathPart2).click();
        Thread.sleep(2000);
    }
    public void validateTextOnPage(String textToValidate) throws InterruptedException {
        Thread.sleep(2000);
        String wifiText=driver.findElementByXPath(partialXpathPart1+textToValidate+partialXpathPart2).getText();
        wifi=wifiText;
        System.out.println("text On the page is  :-  "+textToValidate);
        System.out.println("Text on Wifi Setting"+wifiText);
        Assert.assertEquals(textToValidate,wifiText);
        Thread.sleep(2000);
    }
    public void checkBoxCheckIfNotChecked()  {
        if(checkBox.getAttribute("checked").equals("true")){
            System.out.println("Checking element is selected or not"+checkBox.isSelected());

        }else {
            checkBox.click();
        }
    }
    public void clickOnWifiSetting(String menuToClick) throws InterruptedException {
        driver.findElementByXPath(partialXpathPart1+menuToClick+partialXpathPart2).click();
        Thread.sleep(2000);
    }
    public void sendKeysInTextBox(String textToSend) throws InterruptedException {
        Thread.sleep(4000);
        className.sendKeys(textToSend);
        String actual= className.getText();
        System.out.println("Actual in app is"+actual);
        Assert.assertEquals(textToSend,actual);
    }


    //===============Apis=======================
    public static void contentType(){
        given().contentType(ContentType.JSON);
    }
    static String wifi;
    public static void validateResponseWithNativeApp(String postNumber){
        Response response=when().get(String.format("https://reqres.in/api/users/%s",postNumber)).
                then().contentType(ContentType.JSON).extract().response();
        String usernames = response.jsonPath().getString("data.first_name");
        System.out.println("name is  "+usernames);
        System.out.println("From response body Wifi text:-"+wifi);
        Assert.assertEquals(wifi,usernames);
    }

}
