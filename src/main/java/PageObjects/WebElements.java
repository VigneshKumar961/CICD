package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElements {
	
	public WebDriver driver;
	
	public WebElements(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By mulwin = By.linkText("Multiple Windows");
	
	By cliwin = By.xpath("//a[text()='Click Here']");
	
	By txt = By.xpath("//div/h3");
	
	public WebElement multiplewindow() {
		
		return driver.findElement(mulwin);
	}
	
	public WebElement nextwindow() {
		
		return driver.findElement(cliwin);
	}
	
	public WebElement text() {
		
		return driver.findElement(txt);
	}

}