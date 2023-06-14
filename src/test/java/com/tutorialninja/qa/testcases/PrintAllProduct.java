package com.tutorialninja.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.base.BaseClass;

public class PrintAllProduct extends BaseClass {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=initilisebrowserandopenBrowser("chrome");
		
	}
	@AfterMethod
	//public void tearDown() {
	//	driver.quit();
	//}
	@Test
	public void getAllDetailsOfExistingproduct() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)", "");
		List<WebElement> listofProduct = driver.findElements(By.xpath("//div[@class=\"row\"]"));
		//List<WebElement> listofProduct = driver.findElements(By.linkText("//a"));
		int totalprod = listofProduct.size();
		System.out.println("total product"+totalprod);
		for(WebElement aawebelement:listofProduct) {
			System.out.println(aawebelement.getText());
		}
	}
}
