package com.adgistics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BaseClass {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		
		//Open www.adgistics.com Application 
		String baseUrl = "http://www.adgistics.com/";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
		
		
		@Test
		//Test to check whether d have the case study that the user wants  to download is ‘checked’
		public static void testnew() throws InterruptedException {
		
		Casestudy_selection p = new Casestudy_selection();
		p.casestudy();
		
		}	 
		
		@AfterTest
		 public void tearDown() throws Exception {
//		 Quit the application once the tests are run	
		 driver.quit();
		 }


	}




