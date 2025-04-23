package com.qa.opencart.test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.LoginPage;
import io.qameta.allure.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.Properties;
@Epic("Login Feature")
@Story("UserStory 101")
@Feature("Feature 201")
public class LoginPageTest extends BaseTest {

    @Description("Checking login Page URL ..")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 1)
    public void loginpageTest()
    {
        String actTitle = loginpage.getLoginPageURL();
        //Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_URL_FRACTION);


    }
    @Description("Checking login Pwd link exists ..")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 3)
    public void pwdlinkexists()
    {
        Boolean flag = loginpage.isforgotLinkexists();
        System.out.println(flag);
        Assert.assertEquals(flag,Boolean.TRUE);
    }
    @Description("Checking login ..")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 4)
    public void login()
    {
        String un = prop.getProperty("username");
        String pwd = prop.getProperty("password");
        accpage =loginpage.doLogin(un,pwd);
        Assert.assertEquals(accpage.getAccountPageTitle(),AppConstants.ACCOUNTS_PAGE_TITLE);

    }
    @Description("Checking login Page TitleTest ..")
    @Severity(SeverityLevel.MINOR)
    @Test(priority = 2)
    public void loginTitletest()
    {
        //loginpage.getLoginPageTitle();
        String actTitle = loginpage.getLoginPageTitle();
        Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
    }
}
