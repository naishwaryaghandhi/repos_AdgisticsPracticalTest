package com.adgistics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Casestudy_selection extends BaseClass {

	public void  casestudy() throws InterruptedException{
		
		Actions action = new Actions(driver);
		WebElement casestudies = driver.findElement(By.xpath(".//*[@id='menu-item-359']/a"));
		action.moveToElement(casestudies).moveToElement(driver.findElement(By.xpath(".//*[@id='menu-item-361']/a"))).click().build().perform();
		
		// Get download links of all the case studies
		List <WebElement> allDownloadLinks = driver.findElements(By.linkText("Download"));
		java.util.Iterator<WebElement> downloadLink = allDownloadLinks.iterator();
		
		while(downloadLink.hasNext()) {
		     WebElement link = downloadLink.next();
		     link.click();
		     String downloadId = link.getAttribute("downloadid");
		     Thread.sleep(5000);
		     
		     //To get the value of checked checkbox in the displayed page
		     WebElement checkBox = driver.findElement(By.cssSelector("input:checked[type='checkbox']"));
		     String caseStudyName = checkBox.getAttribute("id");
		     String[] array = caseStudyName.split("\\-");
		     String caseStudyDownloadId = array[1].replaceAll("\\s", "");
		     String label = "checkbox-"+caseStudyDownloadId;
		     WebElement caseStudyNameFromPopUp = driver.findElement(By.cssSelector("label[for="+label+"]"));
		     String caseStudyNameFromPopUpValue = caseStudyNameFromPopUp.getText();
		     driver.findElement(By.id("download_form_close")).click();
		     compareCaseStudyDownloadId(caseStudyNameFromPopUpValue, downloadId, caseStudyDownloadId);
		 }       
		    }
	
	
	//Method to compare the values of case download id and the checkbox id in the next page
	public boolean compareCaseStudyDownloadId(String CaseStudyName, String expectedCaseStudyId, String actualCaseStudyId)
	 {
			SoftAssert Soft_Assert = new SoftAssert();
			try{
			   //If this assertion will fail, It will throw exception and catch block will be executed.
			   Assert.assertEquals(expectedCaseStudyId, actualCaseStudyId);
			   System.out.println("\nSelected Case Study: " + CaseStudyName + "\n Actual Case Study ID: " +actualCaseStudyId+" equals Checked Case Study ID: "+expectedCaseStudyId);
			   }catch(Throwable t){
			    //This will throw soft assertion to keep continue the execution even assertion failure 
			    Soft_Assert.fail("The case study link clicked is: " + CaseStudyName + " and the Actual Case Study ID: " +actualCaseStudyId+" and the Expected Case Study ID: "+expectedCaseStudyId+"' Do Not Match.");
			    //If Integer values will not match, return false.
			    return false;		    
			   }
			  //If  Integer values match, return true.
			  return true;
			 }
		}
	

