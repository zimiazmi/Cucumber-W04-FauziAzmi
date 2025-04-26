package com.juaracoding.cucumber.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import org.apache.poi.ss.usermodel.DateUtil;

public class ExcelReaderPro {
    private static  Workbook workbook;
    public static void loadExcel(String path){
        try {
            FileInputStream file = new FileInputStream(new File(path));
            workbook = WorkbookFactory.create(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Map<String, String> getRowData(String sheetName, int rowNum) {
        Map<String, String> data = new HashMap<>();
        Sheet sheet = workbook.getSheet(sheetName);
        Row header = sheet.getRow(0);
        Row row = sheet.getRow(rowNum);
        for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) {
            data.put(header.getCell(i).getStringCellValue(), row.getCell(i).getStringCellValue());
        }
        return data;
    }
    public static List<Map<String, String>> getAllData(String sheetName) {
        int lastRowNum = sheet.getLastRowNum();

        List<Map<String, String>> allData = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(sheetName);
        Row header = sheet.getRow(0);

        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;  //untuk ngeskip empty row

            Map<String, String> data = new HashMap<>();
            for (int j = 0; j < header.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                String cellValue = "";
                if (cell != null) {
                    switch (cell.getCellType()) {
                        case STRING:
                            cellValue = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                cellValue = cell.getDateCellValue().toString(); //kalau  date
                            } else {
                                cellValue = String.valueOf((long) cell.getNumericCellValue()); // kalau  angka
                            }
                            break;
                        case BOOLEAN:
                            cellValue = String.valueOf(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            cellValue = cell.getCellFormula();
                            break;
                        case BLANK:
                            cellValue = "";
                            break;
                        default:
                            cellValue = "";
                    }
                }
                data.put(header.getCell(j).getStringCellValue(), cellValue);
            }
            allData.add(data);
        }
        return allData;
    }
}