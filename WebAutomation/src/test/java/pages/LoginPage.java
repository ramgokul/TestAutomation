package pages;

import base.BaseUtil;
import core_libs.CommonHelper;
import core_libs.SelectHelper;
import managers.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private BaseUtil base;
    PageObjectManager pageObjectManager;
    CommonHelper commonHelper;
    SelectHelper selectHelper;

    @FindBy(id = "email") private WebElement emailField;
    @FindBy(id = "pass") private WebElement passwordField;
    @FindBy(css = "#loginbutton>input") private WebElement login;

    @FindBy(name = "firstname")
    private WebElement firstName;
    @FindBy(name = "lastname")
    private WebElement lastName;
    @FindBy(name = "reg_email__")
    private WebElement mobileNumber;
    @FindBy(name = "reg_passwd__")
    private WebElement password;

    @FindBy(id = "day")
    private WebElement day;
    @FindBy(id = "month")
    private WebElement month;
    @FindBy(id = "year")
    private WebElement year;
    @FindBy(xpath = "//label[text()='Male']/../input")
    private WebElement male;


    public LoginPage(BaseUtil base) {
        this.base = base;
        PageFactory.initElements(base.driver, this);

        pageObjectManager = new PageObjectManager(base);
        commonHelper = pageObjectManager.getCommonHelper();
        selectHelper = pageObjectManager.getSelectHelper();
    }

    public void loginToFacebook(String email, String password){
        commonHelper.sendKeys(emailField, email);
        commonHelper.sendKeys(passwordField, password);
        commonHelper.click(login);
    }

    public void goToFB(String url){
        commonHelper.gotoUrl(url);
    }

    public void createAnAccount(String firstName, String lastName, String mobileNumber, String password, String day,
                                String month, String year, String sex) {

        commonHelper.sendKeys(this.firstName, firstName);
        commonHelper.sendKeys(this.lastName, lastName);
        commonHelper.sendKeys(this.mobileNumber, mobileNumber);
        commonHelper.sendKeys(this.password, password);

        selectHelper.selectByVisibleText(this.day, day);
        selectHelper.selectByVisibleText(this.month, month);
        selectHelper.selectByVisibleText(this.year, year);

        commonHelper.click(male);

    }
}
