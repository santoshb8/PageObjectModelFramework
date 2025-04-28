package com.qa.opencart.base;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.listeners.ExtentReportListener;
import com.qa.opencart.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.Properties;
//@Listeners(ExtentReportListener.class)
public class BaseTest {
     DriverFactory df;
     WebDriver driver;
     protected Properties prop;

    protected LoginPage loginpage;
    protected AccountsPage accpage;
    protected SearchResultsPage searchResultsPage;
    protected ProductInfoPage productInfoPage;
    protected SoftAssert softAssert;
    protected RegistartionPage registartionPage;

    @Parameters({"browser","browserversion","testname"})
    @BeforeTest
    public void setup(String BrowserName,String browserversion,String testname)
    {
        System.out.println(BrowserName +"   "+browserversion);
        df = new DriverFactory();

        prop = df.initProp();
        if(BrowserName!=null && browserversion!=null)
        {
            prop.setProperty("browser",BrowserName);
            prop.setProperty("browserversion",browserversion);
            prop.setProperty("testname",testname);



        }
       driver = df.initDriver(prop);
        loginpage = new LoginPage(driver);
        softAssert = new SoftAssert();
        // Cast WebDriver to RemoteWebDriver to access SessionId
//        SessionId sessionId = ((RemoteWebDriver) driver).getSessionId();
//        System.out.println("Session ID: " + sessionId.toString());
    }

    @AfterTest
    public void tearDown()
    {
          driver.quit();
    }
}
