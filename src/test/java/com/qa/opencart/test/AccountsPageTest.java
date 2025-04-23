package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Properties;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
    public void accSetup() {
        accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void accpageTest()
    {
        String title = accpage.getAccountPageTitle();
        Assert.assertEquals(AppConstants.ACCOUNTS_PAGE_TITLE,title);
    }
    @Test
    public void accpageUTLTest()
    {
        String title = accpage.getAccPageURL();
        Assert.assertTrue(title.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION));
    }
    @Test
    public void logoutlinkexists()
    {

        Assert.assertTrue(accpage.islogoutLinkexists());
    } @Test
    public void mtacclinkexists()
    {
        Assert.assertTrue(accpage.myacclinkexists());
    }
    @Test
    public void accpageHeadersTest()
    {
       List<String> li =accpage.getHeaders();
        System.out.println(li);

    }
    @Test
    public void searchtest()
    {
        accpage.searchfunc("mac book");
    }
}
