import io.cucumber.messages.internal.com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
//    public static void readXlsx(String filePath) {
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//            // Get the first sheet
//            Sheet sheet = workbook.getSheetAt(0);
//
//            // Iterate through the rows
//            for (Row row : sheet) {
//                // Iterate through the cells
//                for (Cell cell : row) {
//                    // Get the cell value
//                    CellType cellType = cell.getCellType();
//                    switch (cellType) {
//                        case STRING:
//                            System.out.print(cell.getStringCellValue() + "\t");
//                            break;
//                        case NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + "\t");
//                            break;
//                        // Handle other cell types as needed
//                    }
//                }
//                System.out.println();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

   public static Object[][] getResponseDataFromXLSX(){
       //Read the XLSX file
       String filePath = "src/main/resources/Crawler.xlsx";
       try (FileInputStream fis = new FileInputStream(filePath)) {
           Workbook workbook = WorkbookFactory.create(fis);
           Sheet sheet = workbook.getSheetAt(0);
           int rowCount = sheet.getPhysicalNumberOfRows();
           int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();

           Object[][] data = new Object[rowCount - 1][columnCount];
           for (int i = 1; i < rowCount; i++) {
               Row row = sheet.getRow(i);
               for (int j = 0; j < columnCount; j++) {
                   data[i - 1][j] = row.getCell(j).getStringCellValue();
               }
           }
           return data;
       } catch (IOException e) {
           e.printStackTrace();
           return new Object[0][0];
       }
   }


}