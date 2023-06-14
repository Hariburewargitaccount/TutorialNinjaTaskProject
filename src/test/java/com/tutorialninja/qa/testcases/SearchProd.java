package com.tutorialninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.BaseClass;

public class SearchProd extends BaseClass {
	
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=initilisebrowserandopenBrowser("chrome");
		
	}
	
	@Test(priority = 1)
	public void searchProduct() {
		driver.findElement(By.xpath("//input[@name=\"search\"]")).sendKeys("HP");
		driver.findElement(By.xpath("//i[contains(@class,\"fa-search\")]")).click();
		driver.findElement(By.linkText("HP LP3065")).click();
		driver.findElement(By.xpath("Specification")).click();
		driver.findElement(By.xpath("//button[@id=\"button-cart\"]")).click();

	}
	@Test(priority = 2)
	public void searchInvalidproduct() {
		driver.findElement(By.xpath("//input[@name=\"search\"]")).sendKeys("Honda");
		driver.findElement(By.xpath("//i[contains(@class,\"fa-search\")]")).click();
		String actprodnotFoundtext = driver.findElement(By.xpath("//div[@id=\"content\"]/h2/following-sibling::p")).getText();
		String expprodnotFoundtext="There is no product that matches the search criteria.";
		Assert.assertEquals(actprodnotFoundtext, expprodnotFoundtext,"There is  product that matches the search criteria.");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
