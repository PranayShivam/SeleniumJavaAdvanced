package com.advancedSelenium.utilities;

import com.advancedSelenium.components.FrameworkConstants;
import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExcelLib {

    @Getter @Setter
    private String fileName = "TestData.xlsx";

    private XSSFSheet Sheet;

    /**
     * Getter Method for Sheet
     * @param sheetName input sheetName to validate
     * @return XSSFSheet Sheet
     */
    public XSSFSheet getSheet(String sheetName) {
        getSpecificSheet(sheetName);
        return Sheet;
    }

    @Getter
    private Set<String> cellValues = new LinkedHashSet<>();

    @Getter
    private final Set<String> sheetNames = new LinkedHashSet<>();

    @Getter
    private XSSFWorkbook workbook;

    @Getter
    private String specificSheetName;

    private void printAllSheetNames() {

        String testDataLocation = FrameworkConstants.EXCEL_FILE_LOCATION + fileName;
        try (FileInputStream fileInputStream = new FileInputStream(testDataLocation);
        XSSFWorkbook temp = new XSSFWorkbook(fileInputStream)) {
            workbook = temp;
            int noOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < noOfSheets; i++) {
                sheetNames.add(workbook.getSheetName(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void getSpecificSheet(String sheetName) {
        Assert.assertNotNull(workbook);
        Sheet = workbook.getSheet(sheetName);
        Assert.assertNotNull(Sheet, "Please check input string for sheetName");
    }


    public ExcelLib(String... fileName) {
        this.fileName = (fileName.length<=1) ? fileName[0] : this.fileName;
        printAllSheetNames();
    }

    public ExcelLib(String sheetName, String testCaseName) {
        this.specificSheetName = sheetName;
        getCellValues(testCaseName);
    }

    private void getCellValues(String testCaseName) {
        getSpecificSheet(specificSheetName);
        for (Row cells : Sheet) {
            Iterator<Cell> cell = cells.cellIterator();
            if (cell.hasNext() && cell.next().getStringCellValue().equalsIgnoreCase(testCaseName)) {
                cellValues.add(cell.next().getStringCellValue());
            }
        }
    }

    public static void printAllCellValues() {

    }
}
