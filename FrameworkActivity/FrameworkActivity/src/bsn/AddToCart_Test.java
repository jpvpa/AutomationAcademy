package bsn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class AddToCart_Test {
	private WebDriver driver;
	AddToCart addToCart;

	@BeforeEach
	void setUp() throws Exception {
		addToCart = new AddToCart(driver);
		driver = addToCart.chromeDriverConnection();
		addToCart.visit("https://demoblaze.com/index.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		SignInPage signInPage = new SignInPage(driver);
		signInPage.loginUser();
		SelectProduct selectProduct = new SelectProduct(driver);
		selectProduct.selectProduct();
		addToCart.addToCart();
		Thread.sleep(5000);
		assertTrue(addToCart.verifyName());
		assertTrue(addToCart.verifyPrice());
	}

}