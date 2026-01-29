package com.advancedRestAssured;

import com.advancedSelenium.utilities.ExcelLib;
import org.testng.annotations.Test;


public class DataDrivenTestCase {
    String fileName = "Project-Management-Sample-Data.xlsx";
    @Test
    public void DataDrivenTest() {

        ExcelLib lib = new ExcelLib(fileName);
        System.out.println(lib.getSheetNames());

        System.out.println(lib.getSheet("additional Sheet").getDefaultRowHeight());
    }

}
