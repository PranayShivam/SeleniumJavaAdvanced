package com.advancedSelenium.components;

import org.testng.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FrameWorkComponents {

    private static final String REPORT_FOLDER_LOCATION = System.getProperty("user.dir") + File.separator + "Reports" + File.separator;
    private static final String AppPROPERTIES_FILE_LOCATION = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "application.properties";
    private static final String ConfigPROPERTIES_FILE_LOCATION = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Configuration.properties";
    private static final String SCREEN_SHOT_LOCATION = System.getProperty("user.dir") + File.separator + "ScreenShots" + File.separator;

    public static String getReportFolderLocation() {
        return REPORT_FOLDER_LOCATION;
    }

    public static String getScreenShotLocation() {
        return SCREEN_SHOT_LOCATION;
    }

    public static String getValueFromAppProperty(String key) {
        try {
            FileReader reader = new FileReader(AppPROPERTIES_FILE_LOCATION);
            Properties properties = new Properties();
            properties.load(reader);
            String value =  properties.getProperty(key);
            Assert.assertFalse(value.isEmpty(), "Key not found");
            return value;
        } catch (IOException e) {
            throw new RuntimeException("Property not Found. Failed with error: " + e.getMessage());
        }
    }

    public static String getValueFromConfigProperty(String key) {
        try {
            FileReader reader = new FileReader(ConfigPROPERTIES_FILE_LOCATION);
            Properties prop = new Properties();
            prop.load(reader);
            String value =  prop.getProperty(key);
            Assert.assertFalse(value.isEmpty(), "Key not found");
            return value;
        } catch (Exception e) {
            throw new RuntimeException("Property not Found. Failed with error: " + e.getMessage());
        }
    }

}
