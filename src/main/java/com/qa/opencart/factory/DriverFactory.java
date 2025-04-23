package com.qa.opencart.factory;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.exceptions.FrameworkException;
import com.qa.opencart.logger.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

import javax.swing.plaf.basic.BasicRootPaneUI;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DriverFactory {
    WebDriver driver;
    Properties prop;
    OptionsManager optionsManager;
    public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
    public static String highlight;
    public WebDriver initDriver(Properties prop) {
String Browsername = prop.getProperty("browser");
       // System.out.println("Browser is " + Browsername);
        Log.info("Browser info" + Browsername);
        highlight = prop.getProperty("highlight");
        optionsManager = new OptionsManager(prop);
        switch (Browsername.trim().toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(optionsManager.getChromeOption());
                tldriver.set(driver);
                break;

            case "firefox":
                driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
                tldriver.set(driver);
                break;
            case "edge":
                driver = new EdgeDriver(optionsManager.getEdgeOption());
                tldriver.set(driver);
                break;
            case "safari":
                driver = new SafariDriver();
                tldriver.set(driver);
                break;
            default:
                Log.error("Please pass the Right Browser");
                throw new BrowserException("NO BROWSER FOUND ...");
        }
//        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
//        driver.get(prop.getProperty("url"));
//        return driver;

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().get(prop.getProperty("url"));
        return getDriver();

    }
public static WebDriver getDriver()
{
    return tldriver.get();

}
    public Properties initProp() {
        FileInputStream fi = null;
        String envName = System.getProperty("env");
        System.out.println("running tests on Env:" + envName);
        prop = new Properties();
        try {
            if (envName == null) {
                System.out.println("No Environemnt running on qa");
                fi = new FileInputStream("./src/test/Resources/Config/config.qa.properties");

            } else {
                switch (envName.toLowerCase().trim()) {
                    case "qa":
                        fi = new FileInputStream("./src/test/Resources/Config/config.qa.properties");
                        break;
                    case "dev":
                        fi = new FileInputStream("./src/test/Resources/Config/config.dev.properties");
                        break;
                    case "stage":
                        fi = new FileInputStream("./src/test/Resources/Config/config.stage.properties");
                        break;
                    case "uat":
                        fi = new FileInputStream("./src/test/Resources/Config/config.uat.properties");
                        break;
                    case "prod":
                        fi = new FileInputStream("./src/test/Resources/Config/config.prod.properties");
                        break;
                    default:
                        System.out.println("Please pass teh right environment here");
                        throw new FrameworkException(AppError.ENV_NAME_NOT_FOUND + ":" + envName);

                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        try {
         //   FileInputStream fi = new FileInputStream("./src/test/Resources/Config/config.properties");
            prop.load(fi);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop;
    }

    /**
     * take screenshot
     */

    public static String getScreenshot(String methodName) {
        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp directory
        String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
                + ".png";

        File destination = new File(path);

        try {
            FileHandler.copy(srcFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}