package com.automation.core;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class ExcelReader {
    public static Map<String,String> ExecutionMngrMap;
    public  void readExcel() throws  Exception {
        FileInputStream file = new FileInputStream(new File("EXECUTION_MANAGER.xlsm"));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = sheet.iterator();
        ExecutionMngrMap = new HashMap<>(); ;
        String key=null,value=null,tsuit = null;
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                if(cell.getStringCellValue().isEmpty())
                    continue;
                if(cell.getStringCellValue().equals("TESTSUITS"))
                    break;

                if(cell.getColumnIndex() == 0){
                    tsuit=cell.getStringCellValue();
                }
                if(cell.getColumnIndex() == 1){
                    key=tsuit+":"+cell.getStringCellValue();
                }
                if(cell.getColumnIndex() == 2){
                    value = cell.getStringCellValue();
                }

            }
            System.out.println();
            if(key != null && value != null)
            {
                ExecutionMngrMap.put(key.toLowerCase(), value);
                key = null;
                value = null;
            }
        }

        workbook.close();
        file.close();
        for(Map.Entry m:ExecutionMngrMap.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

//        return ExecutionMngrMap;
    }
//
//    public static void main(String args[]) throws Exception {
//        ExcelReader DT = new ExcelReader();
//        DT.readExcel();
//    }


}
