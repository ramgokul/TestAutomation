package core_libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncHelper {

    public void waitForElementToBeClickable(WebDriver driver, WebElement element){
        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
    }
}
