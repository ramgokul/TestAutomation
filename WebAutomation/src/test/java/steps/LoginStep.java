package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import pages.LoginPage;

import java.util.List;

public class LoginStep {
    private BaseUtil base;
    LoginPage lp;


    public LoginStep(BaseUtil base) {
        this.base = base;
        lp = new LoginPage(base);
    }

    @Given("^I login to facebook with the following credentials$")
    public void iLoginToFacebookWithTheFollowingCredentials(DataTable table) throws Throwable {
        List<List<String>> data = table.raw();
        String email = data.get(1).get(0).toString();
        String password = data.get(1).get(1).toString();

        lp.loginToFacebook(email, password);
    }

    @Given("^The user navigates to fb login page$")
    public void theUserNavigatesToFbLoginPage() throws Throwable {
        lp.goToFB("https://www.facebook.com");
    }
}
