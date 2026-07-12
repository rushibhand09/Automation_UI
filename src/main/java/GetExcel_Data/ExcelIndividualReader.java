package GetExcel_Data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelIndividualReader {

    // Helper method to get cell value as String safely
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue()); // long to remove decimal
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\rushi\\eclipse-workspace\\TestingProject1\\usertotest1.xlsx"; // Adjust path if needed

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= 10; i++) { // Read rows 1 to 10 (row 0 is header)
                Row row = sheet.getRow(i);
                if (row == null) continue;

                // Read each cell individually
                String firstName = getCellValueAsString(row.getCell(0));
                String lastName = getCellValueAsString(row.getCell(1));
                String dob = getCellValueAsString(row.getCell(2));
                String cellPhone = getCellValueAsString(row.getCell(3));

                // Print each variable separately (replace with your logic as needed)
                System.out.println("Row " + i + ":");
                System.out.println("  First Name : " + firstName);
                System.out.println("  Last Name  : " + lastName);
                System.out.println("  DOB        : " + dob);
                System.out.println("  Cell Phone : " + cellPhone);
                System.out.println("---------------------------------");

                // 👉 Here you can pass these variables to Selenium actions as needed
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

