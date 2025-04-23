package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;


public class SearchResultsPageTest extends BaseTest {


    @BeforeClass
    public void searchResultsSetup() {
        accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

    }

    @DataProvider
    public Object[][] getProductCountData() {
        return new Object[][] {
                {"macbook", 3},
                {"imac", 1},
                {"samsung", 2}
        };
    }


    @Test(dataProvider = "getProductCountData")
    public void searchResultsCountTest(String searchKey, int productCount) {
        searchResultsPage = accpage.searchfunc(searchKey);
        Assert.assertEquals(searchResultsPage.getSearchProductCount(), productCount);
    }

    @Test
    public void searchResultsTest() {
        Assert.assertEquals(searchResultsPage.getSearchProductCount(), 2);
    }

}