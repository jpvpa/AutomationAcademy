package bsn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class SelectProduct_Test {

	private WebDriver driver;
	SelectProduct selectProduct;
	
	@BeforeEach
	void setUp() throws Exception {
		selectProduct = new SelectProduct(driver);
		driver = selectProduct.chromeDriverConnection();
		selectProduct.visit("https://demoblaze.com/index.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.loginUser();
		selectProduct.selectProduct();
		Thread.sleep(5000);
		assertTrue(selectProduct.verifyImage());
		assertTrue(selectProduct.verifyName());
		assertTrue(selectProduct.verifyPrice());
		
	}

}
