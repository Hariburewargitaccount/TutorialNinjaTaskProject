package com.tutorialninja.qa.testcases;

import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertTrue;

import java.sql.Date;
import java.util.*;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.http.ConnectionFailedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.BaseClass;
import com.tutorialninja.qa.utils.Utilities;

public class LoginTutorialNinja extends BaseClass{
	
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=initilisebrowserandopenBrowser("chrome");
		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
		driver.findElement(By.linkText("Login")).click();
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	@Test(priority = 1)
	public void verifyvalidloginCredential(){
		
		driver.findElement(By.id("input-email")).sendKeys("hariburewar56@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1419@Hari");
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()=\"Edit your account information\"]")).isDisplayed(),"Edit your account information is not present");
		
	}
	@Test(priority = 2)
	public void verifyInvalidCredential() {
	
		driver.findElement(By.id("input-email")).sendKeys(Utilities.genrateEmailTimeStamp());
	driver.findElement(By.id("input-password")).sendKeys("1419@Harish");
	driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
	String warningMSGact=driver.findElement(By.xpath("//div[contains(text(),\"Warning: No\")]")).getText();
	String warningMSGexp="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(warningMSGact.contains(warningMSGexp),"Warning: No match for E-Mail Address and/or Password is not displayed");
		
	}

	@Test(priority = 3)
	public void verifyInvalidEmailandValidPass() {
				driver.findElement(By.id("input-email")).sendKeys("hariburewar5645@gmail.com");
	driver.findElement(By.id("input-password")).sendKeys("1419@Hari");
	driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String warningMSGact=driver.findElement(By.xpath("//div[contains(text(),\"Warning: No\")]")).getText();
	String warningMSGexp="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(warningMSGact.contains(warningMSGexp),"Warning: No match for E-Mail Address and/or Password is not displayed");
		
	}
	@Test(priority = 4)
	public void verifyValidEmailandInvalidPass() {
		
		driver.findElement(By.id("input-email")).sendKeys("hariburewar56@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1419454@Hari");
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String warningMSGact=driver.findElement(By.xpath("//div[contains(text(),\"Warning: No\")]")).getText();
		String warningMSGexp="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(warningMSGact.contains(warningMSGexp),"Warning: No match for E-Mail Address and/or Password is not displayed");
		
	}
	@Test(priority=5)
	public void VerifywithoutCredentials() {
		
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		String warningMSGact=driver.findElement(By.xpath("//div[contains(text(),\"Warning: No\")]")).getText();
		String warningMSGexp="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(warningMSGact.contains(warningMSGexp),"Warning: No match for E-Mail Address and/or Password is not displayed");
		
	}

}