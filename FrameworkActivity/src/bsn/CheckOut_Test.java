package bsn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class CheckOut_Test {
	
	private WebDriver driver;
	CheckOut checkOut;

	@BeforeEach
	void setUp() throws Exception {
		checkOut = new CheckOut(driver);
		driver = checkOut.chromeDriverConnection();
		checkOut.visit("https://demoblaze.com/index.html");
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
		AddToCart addToCart = new AddToCart(driver);
		addToCart.addToCart();
		checkOut.placeOrder();
		assertTrue(checkOut.verifyIcon());
		assertTrue(checkOut.verifyuserInformation());
		Thread.sleep(5000);
		checkOut.finish();
	}

}
