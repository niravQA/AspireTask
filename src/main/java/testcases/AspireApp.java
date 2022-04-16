package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utility.BaseClass;

public class AspireApp extends BaseClass {
	// TestCase 1 - Login
	@Test(priority = 1)
	public void Login() {
		driver.findElement(By.xpath("//input[@id='login']")).sendKeys("user@aspireapp.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("@sp1r3app");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	}

	// TestCase 2 - NavigateToProduct
	@Test(priority = 2)
	public void navigateToProduct() {
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/a[2]/div[1]")).click();
	}

	// TestCase 3 - CreateProduct
	@Test(priority = 3)
	public void createProduct() {
		driver.findElement(By.xpath("//span[contains(text(),'Products')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		driver.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[4]/h1[1]/div[1]/input[1]"))
				.sendKeys("Curry Puff");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		(new WebDriverWait(driver, Duration.ofSeconds(10)))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Edit')]")));
	}

	// TestCase 4 - UpdateProductQuantity
	@Test(priority = 4)
	public void updateProduct() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Update Quantity')]/ancestor::button")).click();
		(new WebDriverWait(driver, Duration.ofSeconds(10)))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Create')]")))
				.click();
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/input[1]")).clear();
		driver.findElement(By.xpath("//tbody/tr[1]/td[6]/input[1]")).sendKeys("150");
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		Thread.sleep(3000);
	}

	// TestCase 5 - NavigateToManufacturing
	@Test(priority = 5)
	public void navigateToManufacturing() {
		driver.findElement(By.xpath("//header/nav[1]/a[1]")).click();
		driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/a[3]/div[1]")).click();

	}

	// TestCase 6 - CreateManufacturing
	@Test(priority = 6)
	public void createManufacturingOrder() {
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/table[1]/tbody[1]/tr[5]/td[2]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("Curry Puff"); // Select created product //
		driver.findElement(By.xpath("(//a[contains(text(),'Curry Puff')])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Confirm')]")).click();
		(new WebDriverWait(driver, Duration.ofSeconds(10))).until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//span[contains(text(),'Mark as Done')]/ancestor::button)[2]")))
				.click();
		driver.findElement(By.xpath("//span[contains(text(),'Ok')]/ancestor::button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Apply')]/ancestor::button")).click();
		(new WebDriverWait(driver, Duration.ofSeconds(10)))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Save')]"))).click();
	}

	// TestCase 7 - ValidateMO
	@Test(priority = 7)
	public void verifyCreatedMO() {
		(new WebDriverWait(driver, Duration.ofSeconds(10)))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Done')]")));
	}

}
