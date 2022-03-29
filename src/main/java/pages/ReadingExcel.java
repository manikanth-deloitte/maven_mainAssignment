package pages;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingExcel {
    public  String fname;
    public  String lname;
    public   int pin;
    public  void readCells() throws IOException {
        String excelFilePath = ".\\customer.xlsx";
        FileInputStream inputStream = new FileInputStream(excelFilePath);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for (int i = 1; i <= rows; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < cols; j++) {
                XSSFCell cell = row.getCell(j);
                if (j == 0) {
                    fname = cell.getStringCellValue();
                }
                if (j == 1) {
                    lname = cell.getStringCellValue();
                }
                if (j == 2) {
                    pin = (int) cell.getNumericCellValue();
                }

            }
        }
    }
    public String getfname()
    {
        return fname;
    }
    public String getlname(){
        return lname;
    }
    public int getpin(){
        return pin;
    }
}
