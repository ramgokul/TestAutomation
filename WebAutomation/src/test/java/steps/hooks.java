package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class hooks {
    private BaseUtil base;
    WebDriverManager webDriverManager;

    public hooks(BaseUtil base) {
        this.base = base;
        webDriverManager = new WebDriverManager(base);
    }

    @Before
    public void launchBrowser(){
        base.driver = webDriverManager.getDriver();
    }

    @After
    public void quitBrowser(Scenario scenario){

        if (scenario.isFailed()){
            File temp = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.FILE);
            try{
                FileUtils.copyFile(temp, new File(new File(System.getProperty("user.dir")).getParent() + "/FailedScreenShots/abc.jpg"));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        webDriverManager.closeDriver();
    }
}
