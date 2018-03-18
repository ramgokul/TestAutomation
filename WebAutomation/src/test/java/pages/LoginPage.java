package pages;

import base.BaseUtil;
import core_libs.CommonHelper;
import core_libs.SyncHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private BaseUtil base;
    CommonHelper ch;

    @FindBy(id = "email") private WebElement emailField;
    @FindBy(id = "pass") private WebElement passwordField;
    @FindBy(css = "#loginbutton>input") private WebElement login;

    public LoginPage(BaseUtil base) {
        this.base = base;
        PageFactory.initElements(base.driver, this);

        ch = new CommonHelper(base.driver);
    }

    public void loginToFacebook(String email, String password){
        ch.sendKeys(emailField, email);
        ch.sendKeys(passwordField, password);
        ch.click(login);
    }

    public void goToFB(String url){
        ch.gotoUrl(url);
    }
}
