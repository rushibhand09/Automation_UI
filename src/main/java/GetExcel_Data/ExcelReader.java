package GetExcel_Data;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {

    public static class User {
        String firstName;
        String lastName;
        String dob;
        String cellPhone;

        public User(String firstName, String lastName, String dob, String cellPhone) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.dob = dob;
            this.cellPhone = cellPhone;
        }

        @Override
        public String toString() {
            return "User [FirstName=" + firstName + ", LastName=" + lastName +
                    ", DOB=" + dob + ", CellPhone=" + cellPhone + "]";
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
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


    public static List<User> readUserData(String filePath) {
        List<User> users = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (int i = 1; i <= 10; i++) { // Assuming row 0 is header
                Row row = sheet.getRow(i);
                if (row == null) continue;

                String firstName = getCellValueAsString(row.getCell(0));
                String lastName = getCellValueAsString(row.getCell(1));
                String dob = getCellValueAsString(row.getCell(2));
                String cellPhone = getCellValueAsString(row.getCell(3));

                User user = new User(firstName, lastName, dob, cellPhone);
                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\rushi\\eclipse-workspace\\TestingProject1\\usertotest1.xlsx";
        List<User> users = readUserData(filePath);

        // Print results
        for (User user : users) {
            System.out.println(user);
        }
    }
}


