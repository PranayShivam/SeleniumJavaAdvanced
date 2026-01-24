package com.advancedSelenium.components;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class FrameWorkComponents {

    private static final String REPORT_FOLDER_LOCATION = System.getProperty("user.dir") + File.separator + "Reports" + File.separator;
    private static final String PROPERTIES_FILE_LOCATION = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "application.properties";
    private static final String SCREEN_SHOT_LOCATION = System.getProperty("user.dir") + File.separator + "ScreenShots" + File.separator;

    public static String getReportFolderLocation() {
        return REPORT_FOLDER_LOCATION;
    }

    public static String getScreenShotLocation() {
        return SCREEN_SHOT_LOCATION;
    }

    public static String getValueFromProperty(String key) {
        try {
            FileReader reader = new FileReader(PROPERTIES_FILE_LOCATION);
            Properties properties = new Properties();
            properties.load(reader);
            return properties.getProperty(key);
        } catch (IOException e) {
            System.out.println("Could not find properties attached to Key: " + key);
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

}
