package Vigneshkumar.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public WebDriver driver;
	
	public Properties prop;
	
	public WebDriver invokeBrowser() throws IOException {
		
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Vignesh Kumar\\eclipse-workspace-1\\Test\\src\\main\\java\\Vigneshkumar\\Test\\data.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
		}
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	public void launchApplication() throws IOException {
		
		driver = invokeBrowser();
		
		driver.get(prop.getProperty("url"));
	}
	
	public void openBrowser() throws IOException {
		
		driver = invokeBrowser();
		
		driver.get(prop.getProperty("base_url"));
	}
	
	public void screenshot() throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		System.out.println(timestamp);
		
		Files.copy(src, new File("C:\\Users\\Vignesh Kumar\\Screens\\Screenshot_" + timestamp + ".png"));
	}

}
