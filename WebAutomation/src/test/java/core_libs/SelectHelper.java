package core_libs;

import base.BaseUtil;
import managers.PageObjectManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SelectHelper {
    private BaseUtil base;
    Select select;
    SyncHelper syncHelper;

    public SelectHelper(BaseUtil base) {
        this.base = base;
        syncHelper = new PageObjectManager(base).getSyncHelper();
    }

    public void deselectAll(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        new Select(element).deselectAll();
        Assert.assertTrue(getAllSelectedOptions(element).size() == 0, "All items not de-selected");
    }

    public void deselectByIndex(WebElement element, int index){
        syncHelper.waitForElementToBeClickable(element);
        new Select(element).deselectByIndex(index);
    }

    public void selectByIndex(WebElement element, int index){
        syncHelper.waitForElementToBeClickable(element);
        new Select(element).selectByIndex(index);
    }

    public void deselectByValue(WebElement element, String value){
        syncHelper.waitForElementToBeClickable(element);
        new Select(element).deselectByValue(value);
    }

    public void selectByValue(WebElement element, String value){
        syncHelper.waitForElementToBeClickable(element);
        new Select(element).selectByValue(value);
    }

    public void deselectByVisibleText(WebElement element, String value){
        syncHelper.waitForElementToBeClickable(element);
        while (getAllSelectedOptionsString(element).contains(value)){
            new Select(element).deselectByVisibleText(value);
        }
    }

    public void selectByVisibleText(WebElement element, String value){
        syncHelper.waitForElementToBeClickable(element);
        while (!getAllSelectedOptionsString(element).contains(value)){
            new Select(element).selectByVisibleText(value.trim());
        }
    }

    public List<WebElement> getAllSelectedOptions(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        return new Select(element).getAllSelectedOptions();
    }

    public List<String> getAllSelectedOptionsString(WebElement element){
        syncHelper.waitForElementToBeClickable(element);

        List<String> selectedValues = new ArrayList<>();

        for(WebElement value : getAllSelectedOptions(element)){
            selectedValues.add(value.getText().trim());
        }

        return selectedValues;
    }

    public WebElement getFirstSelectedOption(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        return new Select(element).getFirstSelectedOption();
    }

    public List<WebElement> getOptions(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        return new Select(element).getOptions();
    }

    public boolean isMultiple(WebElement element){
        syncHelper.waitForElementToBeClickable(element);
        return new Select(element).isMultiple();
    }
}
