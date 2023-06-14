package com.tutorialninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.BaseClass;

public class Logout_Page extends BaseClass {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=initilisebrowserandopenBrowser("chrome");
		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
		driver.findElement(By.linkText("Login")).click();
	
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
	@Test(priority = 1)
	public void verifyvalidloginCredential(){
		
		driver.findElement(By.id("input-email")).sendKeys("hariburewar56@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("1419@Hari");
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()=\"Edit your account information\"]")).isDisplayed(),"Edit your account information is not present");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		driver.findElement(By.linkText("Logout")).click();
	}
}
