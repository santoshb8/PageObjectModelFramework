package com.qa.opencart.pages;

import com.qa.opencart.utilities.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;
    private ElementUtil elutil;

    //private locators
By logoutlink = By.linkText("Logout");
By myaccountLink = By.linkText("My Account");
By headers = By.cssSelector("div#content h2");
By srch = By.name("search");
By searchicon = By.cssSelector("div#search button");

    //public constructor
public AccountsPage(WebDriver driver)
{
    this.driver = driver;
 elutil = new ElementUtil(driver);
}

    public String getAccountPageTitle()
    {
        String title = elutil.waitForTitleIs("My Account",5);

        System.out.println(title);
        return title;
    }

    public String getAccPageURL()
    {
        String title = elutil.waitForURLContains("route=account/account",5);
        System.out.println(title);
        return title;

    }

    public boolean islogoutLinkexists()
    {
        return elutil.waitForElementVisible(logoutlink,15).isDisplayed();
    }

    public boolean myacclinkexists()
    {
        return elutil.waitForElementVisible(myaccountLink,5).isDisplayed();
    }

    public SearchResultsPage searchfunc(String s)
    {
        System.out.println("Testing Seacrh functionality");
        driver.findElement(srch).clear();
        elutil.doSendKeys(srch,s);
        elutil.doClick(searchicon);
        return new SearchResultsPage(driver);
    }

    public List<String> getHeaders(){
        List<WebElement> li = elutil.getElements(headers);
        System.out.println(li);
List<String>li2 = new ArrayList<String>();

for(WebElement we :li)
{
    String a = we.getText();
    li2.add(a);
}
return li2;
    }
}
