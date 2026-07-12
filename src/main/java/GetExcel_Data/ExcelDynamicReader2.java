
package GetExcel_Data;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.*;

	public class ExcelDynamicReader2 {

	    public static void main(String[] args) {
	        String filePath = "C:\\\\Users\\\\rushi\\\\eclipse-workspace\\\\TestingProject1\\\\usertotest1.xlsx";

	        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(filePath))) {
	            Sheet sheet = workbook.getSheetAt(0);
	            List<String> headers = getHeaders(sheet.getRow(0));
	            int columnCount = headers.size();

	            for (int i = 1; i <= 10; i++) {
	                Row row = sheet.getRow(i);
	                if (row == null) continue;

	                Map<String, String> patientData = new LinkedHashMap<>();
	                for (int j = 0; j < columnCount; j++) {
	                    String value = getCellValueAsString(row.getCell(j));
	                    patientData.put(headers.get(j), value);
	                }

	                System.out.println("Patient " + i + ":");
	                patientData.forEach((key, value) -> {
	                    if (!value.isEmpty())
	                        System.out.println("  " + key + " : " + value);
	                });

	                // Selenium input logic (just example print)
	                patientData.forEach((key, value) -> {
	                    if (!value.isEmpty())
	                        System.out.println("Filling Selenium → " + key + " = " + value);
	                });

	                System.out.println("✅ Patient " + i + " processed.\n");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    private static List<String> getHeaders(Row headerRow) {
	        List<String> headers = new ArrayList<>();
	        if (headerRow == null) return headers;
	        for (Cell cell : headerRow)
	            headers.add(getCellValueAsString(cell));
	        return headers;
	    }

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
	    

	
