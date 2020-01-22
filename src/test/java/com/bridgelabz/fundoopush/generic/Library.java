package com.bridgelabz.fundoopush.generic;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.Properties;

public class Library implements IAutoConstant {
    public static Workbook workbook;

    public static String getProperty(String CONFIG_PATH, String key) {
        String property = "";
        Properties prop = new Properties();

        try {
            prop.load(new FileInputStream(CONFIG_PATH));
            property = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return property;
    }

    public static int getRowCount(String EXCEL_PATH, String sheet) {
        int rowCount = 0;
        try {
            workbook = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
            rowCount = workbook.getSheet(sheet).getLastRowNum();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public static String getCellValue(String EXCEL_PATH, String sheet, int row, int column) {
        String value = "";
        try {
            workbook = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
            value = workbook.getSheet(sheet).getRow(row).getCell(column).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
