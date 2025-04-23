package com.qa.opencart.factory;

//import com.sun.java.swing.plaf.windows.TMSchema;
import com.qa.opencart.logger.Log;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

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
