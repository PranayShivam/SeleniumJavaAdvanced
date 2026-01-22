package com.advancedSelenium.SeleniumJava;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProviders {

    @Test(dataProvider = "files")
    public void dataProviderForFiles(int fileCount, String fileName) {

        System.out.println(fileCount + ": " + fileName) ;

    }

    @DataProvider(name = "files")
    private Object[][] dataProviderWithFiles() {
        Object[][] files = new Object[][]{
                {1, "application.properties"},
                {2, "configuration.properties"},
        };
        return files;
    }

    private Object[][] dataProviderUsingCSV() {
        List<Object> dataSet = new ArrayList<>();

        String pathForCSV = "";
        try {
            InputStream stream = new FileInputStream(pathForCSV);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = new String[]{Arrays.toString(line.split(", ")).trim()};
                dataSet.add(arr);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return dataSet.toArray(new Object[dataSet.size()][]);
    }
}
