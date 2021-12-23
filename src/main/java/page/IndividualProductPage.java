package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndividualProductPage extends AbstractObjectPage{
    public IndividualProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='content']/div/div[2]/div[1]/button[1]")
    WebElement wishListButton;

    public void addToWishList(){
        wishListButton.click();
    }

    @FindBy(id = "button-cart")
    WebElement addToCartButtton;
    public void addToCart(){
        addToCartButtton.click();
    }

    @FindBy(className = "alert alert-success alert-dismissible")
    WebElement addToCartMessage;

    public boolean succesCartAddMessages(){
        return addToCartMessage.isDisplayed();
    }

}
