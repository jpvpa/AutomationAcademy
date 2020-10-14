package bsn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class Register_Test {

	private WebDriver driver;
	RegisterPage registerPage;
	
	@BeforeEach
	void setUp() throws Exception {
		registerPage = new RegisterPage(driver);
		driver = registerPage.chromeDriverConnection();
		registerPage.visit("https://demoblaze.com/index.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		registerPage.registerUser();
	}

}
