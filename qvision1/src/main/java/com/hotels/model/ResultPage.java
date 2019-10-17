package com.hotels.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ResultPage {
	
	public WebDriver driver;
	
	@FindBy(how=How.CSS,using=".hotels-data:nth-child(0) .rate-number")
	WebElement nightlyRate;
	
	//List<WebElement> links= driver.findElements(By.tagName("nightlyRate"));
	
	public ResultPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String showRate() {
		return nightlyRate.getText();
	}

}
