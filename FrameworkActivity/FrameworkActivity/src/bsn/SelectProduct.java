package bsn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectProduct extends Base {

	int selectedPrice;
	//  0    1    2    3    4    5    6
	//[320, 360, 650, 700, 790, 800, 820]
	int precio = 1;
	String productPrice;
	int intProductPrice = 0;
	By phoneLinkLocator = By.xpath("//a[@class='list-group-item' and contains(text(), 'Phones')]");
	By catalogPageLocator = By.id("cat");
	By productListLocator = By.xpath("//h5[contains(text(),'$')]");
	By imageLocator = By.xpath("//body/div[5]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/img[1]");
	By nameLocator = By.tagName("h2");
	By priceLocator = By.tagName("h3");
	
	public SelectProduct(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void selectProduct() throws InterruptedException {
		Thread.sleep(5000);
		click(phoneLinkLocator);
		Thread.sleep(5000);
		ArrayList<Integer> priceArray = new ArrayList<Integer>();
		findElements(productListLocator);
		System.out.println(findElements(productListLocator).size());
		for(int i = 0;i<findElements(productListLocator).size();i++) {
			productPrice = findElements(productListLocator).get(i).getText();
			productPrice = productPrice.replaceAll("\\$", "");
			intProductPrice = Integer.parseInt(productPrice);
			System.out.println(productPrice);
			priceArray.add(intProductPrice);
		}
		//Validar que el abra el precio menor
		Collections.sort(priceArray);
		System.out.println(priceArray);
		this.selectedPrice = priceArray.get(precio);
		System.out.println("Selected Price: "+this.selectedPrice);
		By selectedProductLocator = By.xpath("//h5[contains(text(),'$"+this.selectedPrice+"')]/preceding::h4[1]/a[1]");
		System.out.println(selectedProductLocator);
		click(selectedProductLocator);
	}
	
	public Boolean verifyImage() throws InterruptedException {
		return isDisplayed(imageLocator);
	}
	public Boolean verifyName() throws InterruptedException {
		return isDisplayed(nameLocator);
	}
	public Boolean verifyPrice() throws InterruptedException {
		return isDisplayed(priceLocator);
	}

}
