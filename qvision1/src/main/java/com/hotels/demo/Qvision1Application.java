package com.hotels.demo;




import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotels.model.HomePage;
import com.hotels.model.ResultPage;

@SpringBootApplication
public class Qvision1Application {

	WebDriver driver;
	private String baseUrl="https://js.devexpress.com/Demos/DXHotels/#home";
	private String chromeDriver="src/main/resources/Drivers/chromedriver.exe";
	
	@Before
	  public void setUp() throws Exception {
		
		 System.setProperty("webdriver.chrome.driver", chromeDriver);
		  driver = new ChromeDriver();
		 
		  }
	
	
	@Test 
	  public void searchByForm()  {
		  
			try {
               
				 System.setProperty("webdriver.chrome.driver", chromeDriver);
				  driver = new ChromeDriver();
				 
				driver.get(baseUrl);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
				
				HomePage homepage=new HomePage(driver);
				WebDriverWait wait = new WebDriverWait(driver, 100);
				Thread.sleep(1000);
				
				homepage.fillForm("Los Angeles", "10/21/2019", "10/23/2019");

		
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		  

	    }
	
	@Test 
	 public void listResult() throws InterruptedException {
		  
		try {
			driver = new ChromeDriver();
			 driver.get("https://js.devexpress.com/Demos/DXHotels/#hotels?city=1&rooms=1&adults=1&checkIn=10%2F23%2F2019&checkOut=10%2F24%2F2019");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
			  Thread.sleep(30000);
			ResultPage result=new ResultPage(driver);
			
			System.out.println(result.showRate());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	  

    }
	
	 @After
	  public void shutDown() throws Exception {
	  driver.quit();
	 
	  
	}
}
