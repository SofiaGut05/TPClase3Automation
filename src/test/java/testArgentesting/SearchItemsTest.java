package testArgentesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchItemsTest {
	
	private WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://www.duckduckgo.com");
	}
	
	@Test(description="Busqueda página Argentesting")
	public void searchPagina() {
		
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Argentesting");
		driver.findElement(By.id("search_button_homepage")).click();
		driver.findElement(By.id("r1-0")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String textResult = driver.findElement(By.id("menu-item-1126")).getText();
		Assert.assertTrue(textResult.contains("INICIO"),"Se esperaba el texto: INICIO");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();		
	}
	
}

