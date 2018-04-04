package steps;

import base.BaseUtil;
import core_libs.BrowserHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;

public class hooks {
    private BaseUtil base;
    WebDriverManager webDriverManager;

    public hooks(BaseUtil base) {
        this.base = base;
        webDriverManager = new WebDriverManager();
    }

    @Before
    public void launchBrowser(){
        base.driver = webDriverManager.getDriver();
    }

    @After
    public void quitBrowser(){
        webDriverManager.closeDriver();
    }
}
