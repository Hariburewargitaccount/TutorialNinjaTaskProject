package com.tutorialninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialninja.qa.utils.Utilities;

public class BaseClass {
	WebDriver driver;
	//public Properties prop;

		
	
public WebDriver initilisebrowserandopenBrowser(String browserName) {
	//String browserName="chrome";
	if(browserName.equals("chrome")){
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
	
		driver =new ChromeDriver(opt);
		}
	else if (browserName.equals("firefox")) {
	driver = new FirefoxDriver();
	}
else if(browserName.equals("edge")) {
		driver =new EdgeDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.IMPLICIT_LOAD));
	
	driver.get("https://tutorialsninja.com/demo/");
	return driver;
}

}
