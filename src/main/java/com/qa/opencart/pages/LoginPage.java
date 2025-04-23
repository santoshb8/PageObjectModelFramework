package com.qa.opencart.pages;
import com.qa.opencart.utilities.ElementUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
private WebDriver driver;
private ElementUtil eleUtil;
//1.Private By Locators
//    private By email = By.id("//input-email");
    private By email = By.xpath("//input[@name='email']");
//    private By pwd = By.id("//input-password")
    private By pwd = By.xpath("//input[@name='password']");

    private By loginbtn = By.xpath("//input[@value='Login']");
    private By pwdlink = By.linkText("Forgotten Password");
    private By reglink = By.linkText("Register");

    //public constructor
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        eleUtil = new ElementUtil(driver);
    }

    //public page actions/methods
    @Step("fetching login title")
    public String  getLoginPageTitle()
    {
        String title = driver.getTitle();
        System.out.println(title);
        return title;
    }
    @Step("fetching login URL")
    public String  getLoginPageURL()
    {
        String title = driver.getCurrentUrl();
        System.out.println(title);
return title;
    }
    @Step("verify forgot link exist")
    public boolean isforgotLinkexists()
    {
      return  driver.findElement(pwdlink).isDisplayed();
    }
    @Step("Do Login")
    public AccountsPage doLogin(String un,String pswd)
    {
        driver.findElement(email).sendKeys(un);
        driver.findElement(pwd).sendKeys(pswd);
        driver.findElement(loginbtn).click();
        return new AccountsPage(driver);
    }
    @Step("Do Registartion")
    public RegistartionPage navigatetoRegisPage()
    {
        eleUtil.waitForElementVisible(reglink,10).click();
        System.out.println("Reg Link clicked");
        return new RegistartionPage(driver);
    }
}
