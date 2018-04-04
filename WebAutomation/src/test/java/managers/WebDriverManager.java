package managers;

import core_libs.BrowserHelper;
import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private WebDriver driver;
    private String browser_name;
    BrowserHelper browserHelper;
    PageObjectManager pageObjectManager = new PageObjectManager(driver);

    public WebDriverManager() {
        browser_name = FileReaderManager.getInstance().getConfigFileReader().getBrowserName();
        browserHelper = pageObjectManager.getBrowserHelper();
    }

    private WebDriver createDriver(){
        switch (browser_name.toLowerCase()){

            case "firefox":
                driver = browserHelper.launch("firefox");
                break;

            case "chrome":
                driver = browserHelper.launch("chrome");
                break;
        }
        return driver;
    }

    public WebDriver getDriver(){
        if (driver == null){
            driver = createDriver();
        }
        return driver;
    }

    public void closeDriver(){
        browserHelper.quit(driver);
    }
}
