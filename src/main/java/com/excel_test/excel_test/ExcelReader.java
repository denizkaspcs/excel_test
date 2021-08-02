package com.excel_test.excel_test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

//Try to read excel file
public class ExcelReader {

    // var
    private String fileLocation = "C:\\Users\\deniz\\Desktop\\exc.xlsx";
    private String inp;

    // const
    public ExcelReader() {
        /*
         * 
         * iterator.next(); //for each row while(iterator.hasNext()){
         * 
         * }
         */
    }

    public Item[] readExcel() {
        Item[] itemArray = new Item[5];
        int counter = 0;
        int arrayCounter = 0;
        Long id = 0L;
        String employeeType = "";
        String isolationType = "";
        String lolType = "";
        int parameterSize = 10;
        String[] parameter = new String[parameterSize];
        int[] sth = new int[10];

        try {
            FileInputStream excelFile = new FileInputStream(new File(fileLocation));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);

            Iterator<Row> iterator = datatypeSheet.iterator();
            // skip first line which contains the name of the data, not the data
            iterator.next();
            // for each row in excel file
            /*
             * while (iterator.hasNext()) { Row currentRow = iterator.next(); Iterator<Cell>
             * cellIterator = currentRow.iterator(); // for each cell in column, we iterate
             * through while (cellIterator.hasNext()) {
             * 
             * 
             * 
             * } }
             */
            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    if (currentCell.getCellType() == CellType.NUMERIC) {
                        if (counter == 0) {
                            id = (new Double(currentCell.getNumericCellValue())).longValue();
                        }
                    } else if (currentCell.getCellType() == CellType.STRING) {
                        parameter[counter] = currentCell.getStringCellValue();
                    }
                    counter = (counter + 1) % 4;
                }
                if (counter == 0) {
                    String[] parArr = new String[3];
                    int counterF1 = 0;
                    for (int i = 0; i < parameterSize; i++) {
                        if (sth[i] == -1) {

                        } else {
                            parArr[counterF1++] = parameter[sth[i]];
                        }
                    }
                    itemArray[arrayCounter++] = new Item(parArr[0], parameter[1], parameter[2]);
                    // itemArray[arrayCounter++] = new Item(id, employeeType,
                    // isolationType,lolType);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("LAN ERROR VAR LEN A A DASD ASD AS DAS");
        } catch (IOException e) {
            System.out.println("LAN ERROR VAR LEN A A DASD ASD AS DA ASKJDHASLKJD HASLKJD HAKSLJDH ALKSJHDS");

        }
        return itemArray;

    }

    // getter Setter
    public String getInp() {
        return inp;
    }

    public void setInp(String inp) {
        this.inp = inp;
    }

}
