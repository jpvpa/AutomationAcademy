package bsn;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Base {
	public WebDriver driver;
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	public WebElement findElement (By locator) {
		return driver.findElement(locator);
	}
	public List<WebElement> findElements (By locator){
		return driver.findElements(locator);
	}
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
	public void visit (String url) {
		driver.get(url);
	}
	public  void statusDropDownList(int index, By locator) {
		WebElement findelement =  driver.findElement(locator);
	      Select drop = new Select(findelement);
	      drop.selectByIndex(index);  
	}
	public String modal () {
		return driver.switchTo().alert().getText();	
	}
	public void modalAccept () {
		driver.switchTo().alert().accept();	
	}
}
