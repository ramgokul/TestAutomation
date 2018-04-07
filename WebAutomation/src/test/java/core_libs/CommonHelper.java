package core_libs;

import base.BaseUtil;
import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class CommonHelper {
    private BaseUtil base;
    SyncHelper syncHelper;
    WebDriver driver;

    public CommonHelper(BaseUtil base) {
        this.driver = base.driver;
        syncHelper = new PageObjectManager(base).getSyncHelper();
    }



    public void gotoUrl(String url){
        driver.get(url);
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public void click(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        element.click();
    }

    public void clear(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        element.clear();
    }

    public void sendKeys(WebElement element, String input){
        clear(element);
        element.sendKeys(input);
    }

    public boolean isDisplayed(WebElement element){
        try{
            syncHelper.waitForElementToBeClickable(element);
            return element.isDisplayed();
        }catch (Exception e){
            return  false;
        }
    }

    public boolean isSelected(WebElement element){
        try{
            syncHelper.waitForElementToBeClickable(element);
             return element.isSelected();
        }catch (Exception e){
            return  false;
        }
    }

    public boolean isEnabled(WebElement element){
        try{
             syncHelper.waitForElementToBeClickable(element);
             return element.isEnabled();
        }catch (Exception e){
            return  false;
        }
    }

    public String getAttribute(WebElement element, String attributeName){
        try{
             syncHelper.waitForElementToBeClickable(element);
             return element.getAttribute(attributeName);
        }catch (Exception e){
            return  null;
        }
    }

    public String getText(WebElement element){
        try{
             syncHelper.waitForElementToBeClickable(element);
             return element.getText().trim();
        }catch (Exception e){
            return  null;
        }
    }

    public void submit(WebElement element){
        try{
            syncHelper.waitForElementToBeClickable(element);
            element.submit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void switchToWindowWithtitle(String title){
        Set<String> windowHandles = getWindowHandles();

        for(String window :  windowHandles){
            driver.switchTo().window(window);

            if(getPageTitle().contains(title)){
                break;
            }
        }
    }

}
