package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CommonPage;
import page.IndividualProductPage;
import page.ProductPage;

import static tests.BaseTest.driver;

public class TestItemInProductList extends BaseTest{

    CommonPage commonPage;
    ProductPage productPage;
    IndividualProductPage individualProductPage;

    @Test (dataProvider = "products")
    public void testItemInproductList(String productName){
        commonPage = new CommonPage(driver);
        productPage = new ProductPage(driver);
        individualProductPage = new IndividualProductPage(driver);
        commonPage.clickShowAllMp3Players();
        productPage.clickListView();
        Assert.assertSame(productPage.findProductInpage(productName), productName, "Product: "+productName+" was not found");
        productPage.clickProduct(productName);
        individualProductPage.addToWishList();



    }

    @DataProvider
    public Object[][] products()  {
        return new Object[][]{
                {"iPod Classic"},
                {"iPod Nano"},
                {"iPod Touch"},
                {"My player"}
        };
    }
}
