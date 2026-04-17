package utils; // Package name

import java.io.FileInputStream; // Import FileInputStream class
import java.util.Properties; // Import Properties class

public class ConfigReader { // Class used to read config.properties file

    Properties properties; // Declare Properties object

    public ConfigReader() { // Constructor
        try {

            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties"); // Open config.properties file
            properties = new Properties(); // Create Properties object
            properties.load(fis); // Load all values from config.properties file

        } catch (Exception e) { // Handle exception if file not found or any error occurs

            e.printStackTrace(); // Print error in console
        }
    }

    public String getBrowser() { // Method to get browser value
        return properties.getProperty("browser"); // Return browser value from config.properties
    }

    public String getUrl() { // Method to get URL value
        return properties.getProperty("url"); // Return URL value from config.properties
    }

    public String getUsername() { // Method to get username value
        return properties.getProperty("username"); // Return username value from config.properties
    }

    public String getPassword() { // Method to get password value
        return properties.getProperty("password"); // Return password value from config.properties
    }

    public String getOperatorUsername() {
        return properties.getProperty("OperatorUsername");
    }

    public String getOperatorPassword() {
        return properties.getProperty("OperatorPassword");
    }
}