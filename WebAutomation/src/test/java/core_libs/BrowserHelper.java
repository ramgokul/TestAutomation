package core_libs;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserHelper {

    WebDriver driver = null;
    File downloadDirectory = null, failedScreenshotsDirectory = null;
    static long implicitWaitTimeout = 30;


    public WebDriver launch(String browserName){

        String filePath = new File(System.getProperty("user.dir")).getParent() + "/Downloads";
        String filePath2 = new File(System.getProperty("user.dir")).getParent() + "/FailedScreenShots";

        downloadDirectory = new File(filePath);
        failedScreenshotsDirectory = new File(filePath2);

        if(!downloadDirectory.exists()) {
            System.out.println("Creating download dir");
            downloadDirectory.mkdir();
        }

        if (!failedScreenshotsDirectory.exists()){
            failedScreenshotsDirectory.mkdir();
        }

        switch (browserName.toLowerCase().trim()){

            case "firefox":
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");

                FirefoxProfile fp = new FirefoxProfile();

                //File download settings
                fp.setPreference("browser.download.manager.showWhenStarting",false);
                fp.setPreference("browser.download.folderList", 2);
                fp.setPreference("browser.download.useDownloadDir", true);
                fp.setPreference("browser.download.defaultFolder",downloadDirectory.getAbsolutePath());
                fp.setPreference("browser.helperApps.neverAsk.saveToDisk","text/plain,application/pdf,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/msword,application/vnd.ms-powerpoint,application/vnd.openxmlformats-officedocument.presentationml.presentation,application/octet-stream,application/msexcel,application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,text/csv,text/txt,application/pkcs10,application/x-msdownload,application/csv,text/html,application/force-download,application/pkix-cert");
                fp.setPreference("browser.startup.homepage", "http://www.google.com");

                //SSL cert handling
                fp.setAssumeUntrustedCertificateIssuer(false);
                fp.setAcceptUntrustedCertificates(true);

                FirefoxOptions fo = new FirefoxOptions();
                fo.setProfile(fp);
                fo.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

                driver = new FirefoxDriver(fo);
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/drivers/chromedriver");

                Map<String, Object> chromePrefs = new HashMap<>();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", downloadDirectory);
                chromePrefs.put("download.prompt_for_download", "false");
                chromePrefs.put("profile.default_content_setting_values.automatic_downloads", 1);

                ChromeOptions co = new ChromeOptions();
                co.setAcceptInsecureCerts(true);
                co.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
                co.addArguments("test-type");
                co.addArguments("start-maximized");
                co.setExperimentalOption("prefs", chromePrefs);

                driver = new ChromeDriver(co);

                break;

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWaitTimeout, TimeUnit.SECONDS);

        return driver;

    }

    public void quit(WebDriver driver){
        if (driver != null){
            driver.quit();
        }
    }

    public void close(WebDriver driver){
        if (driver != null){
            driver.close();
        }
    }
}
