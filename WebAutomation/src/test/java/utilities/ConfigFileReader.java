package utilities;

import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader() {
        properties = new Properties();
        String configFilePath = System.getProperty("user.dir") + "/src/test/resources/config/configuration.properties";
        File configFile = new File(configFilePath);

        try {

            if (configFile.exists()) {
                FileInputStream fis = new FileInputStream(configFile);
                properties.load(fis);
            }else {
                System.out.println("Config file not found at path ; "+configFilePath);
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getAppUrl(){
        String app_url = properties.getProperty("app_url");
        Assert.assertTrue(!app_url.isEmpty());
        return  app_url;
    }

    public String getUsername(){
        String user_name = properties.getProperty("app_username");
        Assert.assertFalse(user_name.isEmpty());
        return user_name;
    }

    public String getPassword(){
        String user_pwd = properties.getProperty("app_password");
        Assert.assertFalse(user_pwd.isEmpty());
        return user_pwd;
    }

    public int getDefaultTimeOut(){
        int timeout = Integer.parseInt(properties.getProperty("default_timeout"));
        return timeout;
    }

    public String getBrowserName(){
        String browser_name = properties.getProperty("browser");
        Assert.assertFalse(browser_name.isEmpty());
        return browser_name;
    }
}
