package com.stepdefination;

import com.browsers.Browsers;
import com.pages.AndriodAppPage;
import com.pages.IosAppPage;
import com.pages.WebAppPage;
import com.utility.ApiumServer;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class MyStepdefs extends Browsers {

    AndroidDriver driver;
    AndroidDriver chromedriver;
    AppiumDriverLocalService service;
    IOSDriver iosDriver;
    Browsers browsers;
    AndriodAppPage page;
    IosAppPage iospage;
    WebAppPage chromePage;
    AndroidDriver driver1;

    public MyStepdefs()  {
    }



    @Given("^I initialize the android driver$")
    public void iInitializeTheAndroidDriver() throws MalformedURLException, InterruptedException {
        browsers=new Browsers();
        driver1=browsers.initiliazes();
        page=new AndriodAppPage(driver1);
    }

    @Given("^I click on \"([^\"]*)\" Link after opening demo application$")
    public void iClickOnLinkAfterOpeningDemoApplication(String menuItems) throws Throwable {
        page.clickOnAnyMenuInDemoApp(menuItems);
    }
    @And("^I click on CheckBox present on the page$")
    public void iClickOnCheckBoxPresentOnThePage() throws InterruptedException {
       page.checkBoxCheckIfNotChecked();
    }
    @And("^I click on \"([^\"]*)\" on the page$")
    public void iClickOnOnThePage(String wifiSetting) throws Throwable {
        page.clickOnWifiSetting(wifiSetting);
    }

    @And("^I enter value in textbox \"([^\"]*)\"$")
    public void iEnterValueInTextbox(String arg0) throws Throwable {
         page.sendKeysInTextBox(arg0);
    }

    @Then("^I validate the \"([^\"]*)\" should present on the page$")
    public void iValidateTheShouldPresentOnThePage(String textOnPage) throws Throwable {
        page.validateTextOnPage(textOnPage);
    }
    @And("^I initializes the chrome$")
    public void iInitializesTheChrome() throws InterruptedException, MalformedURLException {
/*        System.out.println("In webApp background");
        service= ApiumServer.startServer();
        Thread.sleep(4000);
        chromedriver=capabilities();*/
        chromedriver=capabilities();
        chromePage=new WebAppPage(chromedriver);

    }

    @And("^I open the Webpage \"([^\"]*)\"$")
    public void iOpenTheWebpage(String url) throws Throwable {
        //chromedriver.get(url);
        //Thread.sleep(2000);
        chromePage.getURL(url);
    }

    @And("^I search \"([^\"]*)\" in search bar on the page$")
    public void iSearchInSearchBarOnThePage(String arg0) throws Throwable {
/*        Thread.sleep(3000);
        AndroidElement ele= (AndroidElement) chromedriver.findElementByXPath("//input[@name='q']");
        ele.sendKeys(arg0);
        Thread.sleep(3000);*/
        chromePage.keysToSearch(arg0);

    }

    @And("^I clicked on search Button$")
    public void iClickedOnSearchButton() throws InterruptedException {
        AndroidElement ele= (AndroidElement) chromedriver.findElementByXPath("//span[@class='z1asCe MZy1Rb']");
        ele.click();
        Thread.sleep(2000);
    }
    @And("^I click on covid(\\d+) home page link$")
    public void iClickOnCovidHomePageLink(int arg0) throws InterruptedException {
        AndroidElement ele= (AndroidElement) chromedriver.findElementByXPath("//a[contains(text(),'COVID-19 homepage (mohfw.gov.in)')]");
        WebDriverWait wait=new WebDriverWait(chromedriver,20);
        wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
        Thread.sleep(4000);
    }

    @Then("^I validate The text \"([^\"]*)\" on the page$")
    public void iValidateTheTextOnThePage(String arg0) throws Throwable {
        Thread.sleep(2000);
        AndroidElement ele= (AndroidElement) chromedriver.findElementByXPath("//h1[contains(text(),'Ministry of Health ')]");
        String actual= ele.getText();
        System.out.println("actual is"+actual);
        Assert.assertEquals(arg0,actual);

    }
    //=======================================================================
    @Given("^I initializes the IOS driver and there desired capabilities$")
    public void iInitializesTheIOSDriverAndThereDesiredCapabilities() throws MalformedURLException, InterruptedException {
        this.iosDriver= IOScapabilities();
        iospage=new IosAppPage(iosDriver);

    }

    @And("^I click on \"([^\"]*)\" on the page after opening the application$")
    public void iClickOnOnThePageAfterOpeningTheApplication(String arg0) throws Throwable {
/*        IOSElement textButton = (IOSElement) new WebDriverWait(iosDriver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(arg0)));
        textButton.click();*/
         iospage.clickOnButton(arg0);
    }
    @And("^I have pass the value \"([^\"]*)\" in the textbox$")
    public void iHavePassTheValueInTheTextbox(String keysToSend) throws Throwable {
/*        IOSElement textInput = (IOSElement) new WebDriverWait(iosDriver, 30)
                .until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
        textInput.sendKeys(keysToSend);
        String actual=textInput.getText();
        System.out.println("Actual one is"+actual);
        Assert.assertEquals(keysToSend,actual);*/
        iospage.passTheValueInTextBox(keysToSend);
    }
    //=============================Apis step definitaion=======

    @Given("^I perform the get operation$")
    public void iPerformTheGetOperation() {
        given().contentType(ContentType.JSON);
    }


    @Then("^I should validate the respone \"([^\"]*)\"$")
    public void iShouldValidateTheRespone(String postNumber) throws Throwable {
       Response response=when().get(String.format("https://reqres.in/api/users/%s",postNumber)).
               then().contentType(ContentType.JSON).extract().response();
        String usernames = response.jsonPath().getString("data.first_name");
        System.out.println("name is  "+usernames);
    }

    @And("^I quit the IOS driver$")
    public void iQuitTheIOSDriver() {
        iospage.quitIosDriver();
    }
    @After
    public void closeDriver() throws IOException, InterruptedException {
        if(driver1!=null) {
            driver1.quit();
        }if(chromedriver!=null){
            chromedriver.quit();
        if (service != null) {
                service.stop();
                Thread.sleep(2000);
            }
        }

    }

}

