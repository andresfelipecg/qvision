package com.hotels.model;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriver driver;
	//Actions actions = new Actions(driver);
	
	//LOCALIZADORES
	
	//ComboBox de ciudades
	@FindBy(how=How.XPATH,using="/html/body/div/div[1]/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div[1]/div/input")
	WebElement locationCombo;
	
	//Select location=new Select(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div/div/div/input")));

	
	@FindBy(how=How.XPATH,using="/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div/div/div/div/div/div/input")
	WebElement checkIn;
	
	@FindBy(how=How.XPATH,using="/html/body/div/div/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div/div/div/div/div/input")
	WebElement checkOut;
	
	@FindBy(how=How.XPATH,using="//div[2]/div/div/div/div/div/div/div[3]/div/div")
	WebElement search;
	
	public HomePage (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this); //this hace referencia al pagefactory
		
	}
	
	public void fillForm(String ciudad,String fechaInicio,String fechaFin) throws InterruptedException {
		clickOnElement(locationCombo);
		locationCombo.sendKeys(Keys.DOWN);
		locationCombo.sendKeys(Keys.RETURN);
		//sentText(locationCombo, ciudad);//"Los Angeles"
		//location.selectByVisibleText(ciudad); //value city
		Thread.sleep(3000);
		sentText(checkIn, fechaInicio);
		sentText(checkOut, fechaFin);
		
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[2]/div/div/div/div/div/div/div[3]/div/div")));
		clickOnElement(search);
		//submitOnElement(search);
		//actions.moveToElement(search).click();
	
	}
	
	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	public void submitOnElement(WebElement element) {
		element.submit();
	}
	
	public void sentText(WebElement element, String text) {
		//element.clear();
		element.sendKeys(text);
	}
	
	

}
