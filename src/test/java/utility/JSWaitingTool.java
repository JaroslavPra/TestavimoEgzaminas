package utility;

import com.google.common.base.Function;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractObjectPage;

import java.time.Duration;

public class JSWaitingTool extends AbstractObjectPage {

    public JSWaitingTool(WebDriver driver) {
        super(driver);
    }
    public void waitForJS() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(new Function<>() {
            public Boolean apply(WebDriver driver) {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            }
        });
    }
}
