package com.qa.opencart.test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.RegistartionPage;
import com.qa.opencart.utilities.ExcelUtil;
import com.qa.opencart.utilities.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegPageTest extends BaseTest {

    @BeforeClass
    public void regSetup()
    {
        registartionPage = loginpage.navigatetoRegisPage();
    }

@DataProvider
public Object[][] getUserRegTestData()

{
    return new Object[][]
            {
                    {"gaurav3", "gupta3", "8781074744", "gg@123", "yes"},
                    {"gaurav4", "gupta4", "8781174744", "gg@123", "yes"},
                    {"gaurav5", "gupt5", "8781274744", "gg@123", "yes"},
                    {"gaurav6", "gupta6", "8714874744", "gg@123", "yes"}
            };

}
@DataProvider
public Object[][] getTestData()
{
    return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
}

    @DataProvider
    public Object[][] getTestDataCSV()
    {
        return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
    }
@Test(dataProvider = "getTestDataCSV")
    public void doRegister(String fn,String ln,String phone,String pwd,String Subscribe)
    {

        String s = StringUtils.getRandomemail();
        System.out.println(s);
        Assert.assertTrue(registartionPage.userRegister(fn,ln, s,phone,pwd,Subscribe));
    }
}
