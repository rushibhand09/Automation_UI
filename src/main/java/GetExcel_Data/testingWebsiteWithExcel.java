package GetExcel_Data;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.*;

public class testingWebsiteWithExcel {

    public static void main(String[] args) {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Read Excel data
        List<Map<String, String>> testData = readExcelData("C:\\\\Users\\\\rushi\\\\eclipse-workspace\\\\TestingProject1\\\\usertotest1.xlsx");

        for (Map<String, String> data : testData) {
            // Skip empty rows
            if (data.values().stream().allMatch(String::isEmpty)) {
                System.out.println("Skipping empty row...");
                continue;
            }

            try {
                driver.get("https://demoqa.com/automation-practice-form");

                fillForm(driver, data);

                driver.findElement(By.id("submit")).click();

                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-title")));

                System.out.println("Form submitted successfully for: " +
                        data.getOrDefault("First Name", "[No First Name]") + " " +
                        data.getOrDefault("Last Name", "[No Last Name]"));
            } catch (Exception e) {
                System.err.println("Error submitting form for: " + data.getOrDefault("First Name", "[No First Name]"));
                e.printStackTrace();
            }
        }

        driver.quit();
    }

    private static List<Map<String, String>> readExcelData(String filePath) {
        List<Map<String, String>> dataList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row headerRow = sheet.getRow(0);
            int colCount = headerRow.getPhysicalNumberOfCells();

            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> dataMap = new HashMap<>();

                for (int j = 0; j < colCount; j++) {
                    String header = headerRow.getCell(j).getStringCellValue();
                    String cellValue = getCellValueAsString(row.getCell(j));
                    dataMap.put(header, cellValue);
                }

                dataList.add(dataMap);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
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

    private static void fillForm(WebDriver driver, Map<String, String> data) {
        if (!data.getOrDefault("First Name", "").isEmpty()) {
            driver.findElement(By.id("firstName")).sendKeys(data.get("First Name"));
        }

        if (!data.getOrDefault("Last Name", "").isEmpty()) {
            driver.findElement(By.id("lastName")).sendKeys(data.get("Last Name"));
        }

        if (!data.getOrDefault("Email", "").isEmpty()) {
            driver.findElement(By.id("userEmail")).sendKeys(data.get("Email"));
        }

        String gender = data.getOrDefault("Gender", "").toLowerCase();
        if (!gender.isEmpty()) {
            if (gender.equals("male")) {
                driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
            } else if (gender.equals("female")) {
                driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
            } else if (gender.equals("other")) {
                driver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();
            }
        }

        if (!data.getOrDefault("Phone", "").isEmpty()) {
            driver.findElement(By.id("userNumber")).sendKeys(data.get("Phone"));
        }

        if (!data.getOrDefault("Date of Birth", "").isEmpty()) {
            WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
            dobInput.sendKeys(Keys.CONTROL + "a");
            dobInput.sendKeys(data.get("Date of Birth"));
            dobInput.sendKeys(Keys.ENTER);
        }

        if (!data.getOrDefault("Subjects", "").isEmpty()) {
            WebElement subject = driver.findElement(By.id("subjectsInput"));
            subject.sendKeys(data.get("Subjects"));
            subject.sendKeys(Keys.ENTER);
        }

        if (!data.getOrDefault("Hobbies", "").isEmpty()) {
            WebElement hobby = driver.findElement(By.xpath("//label[contains(text(), '" + data.get("Hobbies") + "')]"));
            if (!hobby.isSelected()) {
                hobby.click();
            }
        }

        if (!data.getOrDefault("Picture", "").isEmpty()) {
            driver.findElement(By.id("uploadPicture")).sendKeys(data.get("Picture"));
        }

        if (!data.getOrDefault("Address", "").isEmpty()) {
            driver.findElement(By.id("currentAddress")).sendKeys(data.get("Address"));
        }

        selectDropdown(driver, "state", data.getOrDefault("State", ""));
        selectDropdown(driver, "city", data.getOrDefault("City", ""));
    }

    private static void selectDropdown(WebDriver driver, String dropdownId, String value) {
        if (!value.isEmpty()) {
            WebElement dropdown = driver.findElement(By.id(dropdownId));
            dropdown.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[contains(@id,'" + dropdownId + "')]/following-sibling::div//div[text()='" + value + "']")));
            option.click();
        }
    }
}
