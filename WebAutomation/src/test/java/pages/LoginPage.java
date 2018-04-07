package pages;

import base.BaseUtil;
import core_libs.CommonHelper;
import core_libs.SyncHelper;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private BaseUtil base;
    PageObjectManager pageObjectManager;
    CommonHelper commonHelper;

    @FindBy(id = "email") private WebElement emailField;
    @FindBy(id = "pass") private WebElement passwordField;
    @FindBy(css = "#loginbutton>input") private WebElement login;

    public LoginPage(BaseUtil base) {
        this.base = base;
        PageFactory.initElements(base.driver, this);

        pageObjectManager = new PageObjectManager(base);
        commonHelper = pageObjectManager.getCommonHelper();
    }

    public void loginToFacebook(String email, String password){
        commonHelper.sendKeys(emailField, email);
        commonHelper.sendKeys(passwordField, password);
        commonHelper.click(login);
    }

    public void goToFB(String url){
        commonHelper.gotoUrl(url);
    }
}
