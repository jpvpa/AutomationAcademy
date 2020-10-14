package bsn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends Base {
	//Locators
	By signUpLinkLocator = By.id("signin2");
	By signUpPageLocator = By.id("signInModalLabel");
	By usernameLocator = By.id("sign-username");
	By passwordLocator = By.id("sign-password");
	By signUpBTNLocator = By.cssSelector("#signInModal .btn-primary");
	
	

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void registerUser() throws InterruptedException {
		click(signUpLinkLocator);
		Thread.sleep(5000);
		if(isDisplayed(signUpPageLocator)) {
			type("qualityadmin9", usernameLocator);
			type("qualityadmin", passwordLocator);
			click(signUpBTNLocator);
		}else {
			System.out.println("Create account page was not found");
		}
		Thread.sleep(5000);
		modalAccept ();
		
	}

}
