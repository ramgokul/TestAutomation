package steps;

import base.BaseUtil;
import core_libs.BrowserHelper;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class hooks {
    private BaseUtil base;
    BrowserHelper bh = new BrowserHelper();

    public hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void launchBrowser(){
        base.driver = bh.launch("chrome");
    }

    @After
    public void quitBrowser(){
        bh.quit(base.driver);
    }
}
