
package GetExcel_Data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

public class ExcelDynamicReader {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\rushi\\eclipse-workspace\\TestingProject1\\usertotest1.xlsx"; // Update path as needed

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);

            if (headerRow == null) {
                System.out.println("Excel header row is missing!");
                return;
            }

            int columnCount = headerRow.getLastCellNum();
            List<String> headers = new ArrayList<>();
            for (int i = 0; i < columnCount; i++) {
                Cell cell = headerRow.getCell(i);
                headers.add(cell != null ? cell.getStringCellValue() : "Column" + i);
            }

            System.out.println("=== Reading Patients ===");

            for (int i = 1; i <= 10; i++) {
                Row row = sheet.getRow(i);
                Map<String, String> patientData = new LinkedHashMap<>();

                for (int j = 0; j < columnCount; j++) {
                    String header = headers.get(j);
                    String value = "";

                    if (row != null) {
                        Cell cell = row.getCell(j);
                        value = getCellValueAsString(cell);
                    }

                    patientData.put(header, value);
                }

                // 🔹 Print non-empty fields for debug (optional)
                System.out.println("Patient " + i + ":");
                for (Map.Entry<String, String> entry : patientData.entrySet()) {
                    if (!entry.getValue().isEmpty()) {
                        System.out.println("  " + entry.getKey() + " : " + entry.getValue());
                    }
                }
                System.out.println("-------------------------------------------");

                // 🔹 Selenium logic: Only fill non-empty fields
                for (Map.Entry<String, String> entry : patientData.entrySet()) {
                    String fieldName = entry.getKey();
                    String fieldValue = entry.getValue();

                    if (!fieldValue.isEmpty()) {
                        // Replace XPath strategy with your actual locators
                        // Example using name attribute
                        // driver.findElement(By.name(fieldName)).sendKeys(fieldValue);
                        System.out.println("Filling in Selenium → " + fieldName + " = " + fieldValue);
                    } else {
                        System.out.println("Skipping field → " + fieldName + " (blank)");
                    }
                }

                System.out.println("✅ Patient " + i + " processed.");
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Helper to safely extract cell value as string
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }
}

	
