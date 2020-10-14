package bsn;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class Login_Test {
	
	private WebDriver driver;
	SignInPage signInPage;

	@BeforeEach
	void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.chromeDriverConnection();
		signInPage.visit("https://demoblaze.com/index.html");
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		signInPage.loginUser();
		Thread.sleep(5000);
		assertTrue(signInPage.loggedMessage());
	}

}
