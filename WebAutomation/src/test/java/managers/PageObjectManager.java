package managers;

import core_libs.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class PageObjectManager {
    WebDriver driver;
    AlertsHelper alertsHelper;
    BrowserHelper browserHelper;
    CommonHelper commonHelper;
    FramesHelper framesHelper;
    JavaScriptHelper javaScriptHelper;
    SelectHelper selectHelper;
    SyncHelper syncHelper;
    TablesHelper tablesHelper;
    LoginPage loginPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public AlertsHelper getAlertsHelper() {
        return (alertsHelper == null) ? alertsHelper = new AlertsHelper() : alertsHelper;
    }

    public BrowserHelper getBrowserHelper() {
        return (browserHelper == null) ? browserHelper = new BrowserHelper() : browserHelper;
    }

    public CommonHelper getCommonHelper() {
        return (commonHelper == null) ? commonHelper = new CommonHelper(driver) : commonHelper;
    }

    public FramesHelper getFramesHelper() {
        return (framesHelper == null) ? framesHelper = new FramesHelper() : framesHelper;
    }

    public JavaScriptHelper getJavaScriptHelper() {
        return (javaScriptHelper == null) ? javaScriptHelper = new JavaScriptHelper() : javaScriptHelper;
    }

    public SelectHelper getSelectHelper() {
        return (selectHelper == null) ? selectHelper = new SelectHelper() : selectHelper;
    }

    public SyncHelper getSyncHelper() {
        return (syncHelper == null) ? syncHelper = new SyncHelper() : syncHelper;
    }

    public TablesHelper getTablesHelper() {
        return (tablesHelper == null) ? tablesHelper = new TablesHelper() : tablesHelper;
    }

//    public LoginPage getLoginPage() {
//        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
//    }
}
