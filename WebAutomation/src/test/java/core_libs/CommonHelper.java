package core_libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class CommonHelper {
    SyncHelper sh = new SyncHelper();
    WebDriver driver;

    public CommonHelper(WebDriver driver) {
        this.driver = driver;
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
        sh.waitForElementToBeClickable(driver,element);
        element.click();
    }

    public void clear(WebElement element){
        sh.waitForElementToBeClickable(driver,element);
        element.clear();
    }

    public void sendKeys(WebElement element, String input){
        clear(element);
        element.sendKeys(input);
    }

    public boolean isDisplayed(WebElement element){
        try{
            sh.waitForElementToBeClickable(driver, element);
            return element.isDisplayed();
        }catch (Exception e){
            return  false;
        }
    }

    public boolean isSelected(WebElement element){
        try{
             sh.waitForElementToBeClickable(driver, element);
             return element.isSelected();
        }catch (Exception e){
            return  false;
        }
    }

    public boolean isEnabled(WebElement element){
        try{
             sh.waitForElementToBeClickable(driver, element);
             return element.isEnabled();
        }catch (Exception e){
            return  false;
        }
    }

    public String getAttribute(WebElement element, String attributeName){
        try{
             sh.waitForElementToBeClickable(driver, element);
             return element.getAttribute(attributeName);
        }catch (Exception e){
            return  null;
        }
    }

    public String getText(WebElement element){
        try{
             sh.waitForElementToBeClickable(driver, element);
             return element.getText().trim();
        }catch (Exception e){
            return  null;
        }
    }

    public void submit(WebElement element){
        try{
            sh.waitForElementToBeClickable(driver, element);
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
