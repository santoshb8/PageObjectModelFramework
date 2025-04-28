package com.qa.opencart.factory;

//import com.sun.java.swing.plaf.windows.TMSchema;
import com.qa.opencart.logger.Log;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class OptionsManager {
    private Properties prop;
    private ChromeOptions co;
    private EdgeOptions eo;
    private FirefoxOptions fo;
public OptionsManager(Properties prop)
{
this.prop = prop;
}
    public ChromeOptions getChromeOption()
    {
        co = new ChromeOptions();
        if(Boolean.parseBoolean(prop.getProperty("remote").trim()))
        {
            Log.info("Running in Remote  mode");
            co.setCapability("browserName","chrome");
            co.setBrowserVersion(prop.getProperty("browserversion").trim());
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("screenResolution", "1280x1024x24");
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("name", prop.getProperty("testname"));
            co.setCapability("selenoid:options", selenoidOptions);
        }
        if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
        {
            Log.info("Running in Headless mode");
            co.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
        {
            Log.info("Running in Incognito mode");
            co.addArguments("--incognito");
        }
        return co;
    }
    public EdgeOptions getEdgeOption()
    {
        eo = new EdgeOptions();
        if(Boolean.parseBoolean(prop.getProperty("remote").trim()))
        {
            Log.info("Running in Remote  mode");
            eo.setCapability("browserName","edge");
            eo.setBrowserVersion(prop.getProperty("browserversion"));
            //edge browser does not support selenoid
//            Map<String, Object> selenoidOptions = new HashMap<>();
//            selenoidOptions.put("screenResolution", "1280x1024x24");
//            selenoidOptions.put("enableVNC", true);
//           // selenoidOptions.put("name", prop.getProperty("testname"));
//            eo.setCapability("selenoid:options", selenoidOptions);
        }
        if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
        {
            Log.info("Running in Headless mode");
            eo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
        {
            Log.info("Running in Incognito mode");
            eo.addArguments("--incognito");
        }
        return eo;
    }
    public FirefoxOptions getFirefoxOptions()
    {
        fo = new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("remote").trim()))
        {
            Log.info("Running in Remote  mode");
            fo.setCapability("browserName","firefox");
            fo.setBrowserVersion(prop.getProperty("browserversion"));
            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("screenResolution", "1280x1024x24");
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("name", prop.getProperty("testname"));
            fo.setCapability("selenoid:options", selenoidOptions);
        }

        if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
        {
            Log.info("Running in headless mode");
            fo.addArguments("--headless");
        }
        if(Boolean.parseBoolean(prop.getProperty("incognito").trim()))
        {
            Log.info("Running in Incognito mode");
            fo.addArguments("--incognito");
        }
        return fo;
    }
}
