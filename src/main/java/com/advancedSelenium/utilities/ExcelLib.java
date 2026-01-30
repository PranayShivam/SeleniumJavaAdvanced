package com.advancedSelenium.utilities;

import com.advancedSelenium.components.ExcelLibVariables;
import com.advancedSelenium.components.FrameworkConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelLib extends ExcelLibVariables {

    public static void setWorkBookFile(String fileName) {
        ExcelLibVariables.fileName = fileName;
    }

    /**
     * Getter Method for Sheet
     * @param sheetName input sheetName to validate
     * @return XSSFSheet Sheet
     */
    public XSSFSheet getSheet(String sheetName) {
        getSpecificSheet(sheetName);
        return Sheet;
    }

    private void initializeWorkBook() {

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


    public ExcelLib() {}

    public ExcelLib(String sheetName, String testCaseName) {
        initializeWorkBook();
        this.specificSheetName = sheetName;
        getCellValues(testCaseName);
    }

    private void getCellValues(String testCaseName) {
        getSpecificSheet(specificSheetName);
        System.out.println(Sheet.getSheetName());
        Iterator<Row> rows = Sheet.iterator();
        while (rows.hasNext()) {
            Iterator<Cell> cell = rows.next().cellIterator();
            while (cell.hasNext()) {
                Cell cellValue = cell.next();
                switch (cellValue.getCellType()){
                    case STRING -> cellValues.add(cellValue.getStringCellValue());
                    case NUMERIC -> cellValues.add(String.valueOf(cellValue.getNumericCellValue()));
                    case BOOLEAN -> cellValues.add(String.valueOf(cellValue.getBooleanCellValue()));
                    case BLANK -> cellValues.add("");
                    case FORMULA -> cellValues.add(String.valueOf(cellValue.getCellFormula()));
                }
            }
        }
    }


}
