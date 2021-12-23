package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndividualProductPage extends AbstractObjectPage{
    public IndividualProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div[1]/button[1]")
    WebElement wishListbutton;

    public void addToWishList(){
        wishListbutton.click();
    driver.findElement(By.)
    }

    @FindBy()


    public void

}
