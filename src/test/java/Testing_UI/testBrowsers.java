package Testing_UI;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class testBrowsers {
	
	
	@Test
	public void init()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//WebElement username = driver.findElement(By.xpath("username"));
		
		//Select sel = new Select(username);
		
	}

}
