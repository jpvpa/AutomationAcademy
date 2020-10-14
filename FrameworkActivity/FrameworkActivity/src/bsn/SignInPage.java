package bsn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base{
	
	String userName = "qualityadmin";
	
	By loginLinkLocator = By.id("login2");
	By loginPageLocator = By.id("logInModalLabel");
	By usernameLocator = By.id("loginusername");
	By passwordLocator = By.id("loginpassword");
	By userNavbar = By.linkText("Welcome "+userName+"");
	By loginBTNLocator = By.cssSelector("#logInModal .btn-primary");
	
	
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void loginUser() throws InterruptedException {
		click(loginLinkLocator);
		Thread.sleep(5000);
		if(isDisplayed(loginPageLocator)) {
			type(userName, usernameLocator);
			type("qualityadmin", passwordLocator);
			click(loginBTNLocator);
		}else {
			System.out.println("Login modal page was not found");
		}
	}
	
	public Boolean loggedMessage() throws InterruptedException {
		return isDisplayed(userNavbar);
	}
}
