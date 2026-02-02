package com.advancedRestAssured;

import com.advancedSelenium.utilities.ExcelLib;
import org.testng.annotations.Test;


public class DataDrivenTestCase {
    String fileName = "Project-Management-Sample-Data.xlsx";
    @Test
    public void DataDrivenTest() {

        ExcelLib.setWorkBookFile("Project-Management-Sample-Data.xlsx");
        ExcelLib lib = new ExcelLib("Additional Sheet",this.getClass().getSimpleName());
        System.out.println(lib.getSheetNames());
        System.out.println(lib.getCellValues());
    }

}
