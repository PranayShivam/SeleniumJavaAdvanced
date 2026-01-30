package com.advancedSelenium.components;

import lombok.Getter;
import lombok.Setter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class ExcelLibVariables {

    @Getter
    public static String fileName = "TestData.xlsx";

    protected XSSFSheet Sheet;

    @Getter
    protected List<String> cellValues = new LinkedList<>();

    @Getter
    protected List<String> sheetNames = new LinkedList<>();

    @Getter
    protected XSSFWorkbook workbook;

    @Getter
    protected String specificSheetName;

}
