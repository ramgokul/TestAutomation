package core_libs;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JavaScriptHelper {
    WebDriver driver;

    public void test(){
        ((JavascriptExecutor)driver).executeScript("return document.readystate");
    }
}
