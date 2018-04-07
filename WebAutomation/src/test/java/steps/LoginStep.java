package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import managers.PageObjectManager;
import pages.LoginPage;

import java.util.List;
import java.util.Map;

public class LoginStep {
    private BaseUtil base;
    LoginPage lp;
    PageObjectManager pageObjectManager;


    public LoginStep(BaseUtil base) {
        this.base = base;
        pageObjectManager = new PageObjectManager(base);
        lp =  pageObjectManager.getLoginPage();

    }

    @Given("^I login to facebook with the following credentials$")
    public void iLoginToFacebookWithTheFollowingCredentials(DataTable table) throws Throwable {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);
        String email = data.get(0).get("username").trim();
        String password = data.get(0).get("password").trim();

        lp.loginToFacebook(email, password);
    }

    @Given("^The user navigates to fb login page$")
    public void theUserNavigatesToFbLoginPage() throws Throwable {
        lp.goToFB("https://www.facebook.com");
    }
}
