package vigneshkumar;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import PageObjects.WebElements;
import Resources.Base;

public class LoginPageTest extends Base{
	
	WebElements wb;
	
	@Test
	public void openPage() throws IOException {
		
		launchApplication();
		
		System.out.println("Page Title is : " + driver.getCurrentUrl());
		
		screenshot();
		
		driver.quit();
	}
	
	@Test
	public void checkPage() throws IOException {
		
		openBrowser();
		
		wb = new WebElements(driver);
		
		wb.multiplewindow().click();
		
		wb.nextwindow().click();
		
		Set<String> windows = driver.getWindowHandles();
		
		Iterator<String> itr = windows.iterator();
		
		String parentWindow = itr.next();
		
		String childWindow = itr.next();
		
		driver.switchTo().window(childWindow);
		
		System.out.println(wb.text().getText());
		
		driver.switchTo().window(parentWindow);
		
		System.out.println(wb.text().getText());
		
		screenshot();
		
		driver.quit();
	}

}