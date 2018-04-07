package core_libs;

import base.BaseUtil;
import managers.FileReaderManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncHelper {
    WebDriverWait webDriverWait;

    public SyncHelper(BaseUtil base) {
        webDriverWait = new WebDriverWait(base.driver, FileReaderManager.getInstance().getConfigFileReader().getDefaultTimeOut());
    }

    public void waitForElementToBeClickable(WebElement element){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
