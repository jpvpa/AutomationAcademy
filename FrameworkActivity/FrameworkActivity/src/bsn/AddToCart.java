package bsn;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart extends Base {

	public AddToCart(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	By addToCartLinkLocator = By.linkText("Add to cart");
	By cartLinkLocator = By.id("cartur");
	By productListLocator = By.xpath("//h5[contains(text(),'$')]");
	By nameLocator = By.xpath("(//tr[@class='success']//td)[2]");
	By priceLocator = By.xpath("(//tr[@class='success']//td)[3]");
	
	
	public void addToCart() throws InterruptedException {
		Thread.sleep(5000);
		click(addToCartLinkLocator);
		Thread.sleep(5000);
		modalAccept();
		click(cartLinkLocator);
		Thread.sleep(3000);
	}
	public Boolean verifyName() throws InterruptedException {
		return isDisplayed(nameLocator);
	}
	public Boolean verifyPrice() throws InterruptedException {
		return isDisplayed(priceLocator);
	}
	
	
}
