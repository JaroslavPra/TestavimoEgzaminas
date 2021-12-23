package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends AbstractObjectPage{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "list-view")
    WebElement listView;

    public void clickListView(){
        listView.click();
    }



    @FindBy(className = "product-thumb")
    List<WebElement> productsInPage;


    public List getProductList (){
        return productsInPage;
    }

    public String findProductInpage(String itemName){
        return driver.findElement(By.linkText(itemName)).getText();
    }

    public void clickProduct(String itemName){
        driver.findElement(By.linkText(itemName)).click();
    }






}
