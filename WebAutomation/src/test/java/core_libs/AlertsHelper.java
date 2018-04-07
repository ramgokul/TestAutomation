package core_libs;

import base.BaseUtil;
import org.openqa.selenium.Alert;

public class AlertsHelper {

    private BaseUtil base;
    Alert alert;

    public AlertsHelper(BaseUtil base) {
        this.base = base;
        alert = base.driver.switchTo().alert();
    }

    public void acceptAlert(){
        alert.accept();
    }

    public void dismissAlert(){
        alert.dismiss();
    }

    public String getAlertText(){
        return alert.getText().trim();
    }

    public void sendKeys(String textInput){
        alert.sendKeys(textInput);
    }
}
