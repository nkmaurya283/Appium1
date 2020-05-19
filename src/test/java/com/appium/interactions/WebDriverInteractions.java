package com.appium.interactions;

import org.openqa.selenium.WebElement;


public class WebDriverInteractions {

    public void click(WebElement element){
        element.click();
    }
    public void KeysToSend(WebElement element,String inputValue){
        element.sendKeys(inputValue);
    }
    public void getTextOnWebElement(WebElement element){

        element.getText();
    }
}
