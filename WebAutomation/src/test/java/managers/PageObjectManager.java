package managers;

import base.BaseUtil;
import core_libs.*;
import pages.LoginPage;

public class PageObjectManager {
    private BaseUtil base;
    AlertsHelper alertsHelper;
    BrowserHelper browserHelper;
    CommonHelper commonHelper;
    FramesHelper framesHelper;
    JavaScriptHelper javaScriptHelper;
    SelectHelper selectHelper;
    SyncHelper syncHelper;
    TablesHelper tablesHelper;
    LoginPage loginPage;

    public PageObjectManager(BaseUtil base) {
        this.base = base;
    }

    public AlertsHelper getAlertsHelper() {
        return (alertsHelper == null) ? alertsHelper = new AlertsHelper(base) : alertsHelper;
    }

    public BrowserHelper getBrowserHelper() {
        return (browserHelper == null) ? browserHelper = new BrowserHelper() : browserHelper;
    }

    public CommonHelper getCommonHelper() {
        return (commonHelper == null) ? commonHelper = new CommonHelper(base) : commonHelper;
    }

    public FramesHelper getFramesHelper() {
        return (framesHelper == null) ? framesHelper = new FramesHelper() : framesHelper;
    }

    public JavaScriptHelper getJavaScriptHelper() {
        return (javaScriptHelper == null) ? javaScriptHelper = new JavaScriptHelper() : javaScriptHelper;
    }

    public SelectHelper getSelectHelper() {
        return (selectHelper == null) ? selectHelper = new SelectHelper(base) : selectHelper;
    }

    public SyncHelper getSyncHelper() {
        return (syncHelper == null) ? syncHelper = new SyncHelper(base) : syncHelper;
    }

    public TablesHelper getTablesHelper() {
        return (tablesHelper == null) ? tablesHelper = new TablesHelper() : tablesHelper;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(base) : loginPage;
    }
}
