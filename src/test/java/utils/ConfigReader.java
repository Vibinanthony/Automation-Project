package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    Properties properties;

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}