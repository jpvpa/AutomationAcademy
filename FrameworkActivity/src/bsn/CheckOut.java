package bsn;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut extends Base {
	
	By placeOrderBTNLocator = By.xpath("//button[@class='btn btn-success']");
	By nameLocator = By.id("name");
	By countryLocator = By.id("country");
	By cityLocator = By.id("city");
	By cardLocator = By.id("card");
	By monthLocator = By.id("month");
	By yearLocator = By.id("year");
	By purchaseBTN = By.xpath("//button[contains(text(),'Purchase')]");
	By iconoLocator = By.xpath("//body[1]/div[10]/div[4]/div[1]");
	By userInformationLocator = By.xpath("//p[contains(text(),'Id')]");
	By finishBTNLocator = By.xpath("//button[contains(text(),'OK')]");
	By logOutBTN = By.id("logout2");
	public CheckOut(WebDriver driver) {
		super(driver);
	}
	public void placeOrder() throws InterruptedException {
		Thread.sleep(5000);
		click(placeOrderBTNLocator);
		Thread.sleep(5000);
		type("Juan Pablo VP",nameLocator);
		type("Mexico",countryLocator);
		type("Monterrey",cityLocator);
		type("123456789",cardLocator);
		type("10",monthLocator);
		type("2025",yearLocator);
		Thread.sleep(3000);
		click(purchaseBTN);
	}
	public Boolean verifyIcon() throws InterruptedException {
		return isDisplayed(iconoLocator);
	}
	public Boolean verifyuserInformation() throws InterruptedException {
		return isDisplayed(userInformationLocator);
	}
	public void finish() throws InterruptedException {
		Thread.sleep(5000);
		click(finishBTNLocator);
		Thread.sleep(5000);
		click(logOutBTN);
	}
	
	

}
