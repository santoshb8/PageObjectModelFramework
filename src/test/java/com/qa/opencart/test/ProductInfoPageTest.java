package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

public class ProductInfoPageTest extends BaseTest {
    @BeforeClass
    public void prodSetup(){
        accpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @DataProvider
    public Object[][] getprodsearchdata()
    {
        return new Object[][]
                {
                        {"macbook","MacBook Pro"},
                        {"imac","iMac"},
                        {"samsung","Samsung SyncMaster 941BW"},
                        {"samsung","Samsung Galaxy Tab 10.1"}
                };

    }

    @DataProvider
    public Object[][] getTestprodsearchdata()
    {
        return ExcelUtil.getTestData("Product");

    }

 @Test(dataProvider = "getTestprodsearchdata")
    public void productHeaderTest(String searchkey,String Product) {
        searchResultsPage = accpage.searchfunc(searchkey);
        productInfoPage = searchResultsPage.selectProduct(Product);
        Assert.assertEquals(productInfoPage.getProductHeader(), Product);
    }

    @Test
    public void ProductImagesCount() {
        searchResultsPage = accpage.searchfunc("imac");
        productInfoPage = searchResultsPage.selectProduct("iMac");
        Assert.assertEquals(productInfoPage.getProductImagesCount(),3);
    }

    @Test
    public void productInfoTest() {
        searchResultsPage = accpage.searchfunc("macbook");
        productInfoPage = searchResultsPage.selectProduct("MacBook Pro");
        Map<String,String> prodaccdetmap = productInfoPage.getProductDetailsMap();
        softAssert.assertEquals(prodaccdetmap.get("Brand"), "Apple");
        softAssert.assertEquals(prodaccdetmap.get("Brand"), "Apple");

        softAssert.assertEquals(prodaccdetmap.get("Product Code"), "Product 18");

          softAssert.assertEquals(prodaccdetmap.get("Product Code"), "Product 18");
          softAssert.assertEquals(prodaccdetmap.get("Availability"), "Out of Stock");

        softAssert.assertEquals(prodaccdetmap.get("Product Code"), "Product 18");
softAssert.assertEquals(prodaccdetmap.get("Productprice"), "$2,000.00");
       softAssert.assertEquals(prodaccdetmap.get("extraxprice"), "$2,000.00");
       softAssert.assertAll();
    }
}
