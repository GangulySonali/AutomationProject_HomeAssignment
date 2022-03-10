/* BaseClass has been created to store the common methods and inherited by test class(i.e.,SearchFlightTest class)
 *  to launch the browser,open the url at the beginning and close the browser at the end of the test execution
 *  
 */



package com.aircanada.testBase;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aircanada.utilities.ReadConfig;

public class BaseClass {

	public static WebDriver driver=null;
	public static Logger logger=LogManager.getLogger(BaseClass.class);
	public static ReadConfig rc=new  ReadConfig();

	@BeforeClass
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger.info("Browser opened--------------------");


		//Launching URL
		driver.get(rc.getUrl());
		driver.manage().window().maximize();
		logger.info("URL opened--------------------");
		if(driver.getTitle().equals("404"))
		{

			driver.findElement(By.linkText("Homepage")).click();
			logger.info("page not found------------------");

		}
		else
		{
            if(driver.getTitle().contains("Air Canada"))
			logger.info("Title verified and desired page opened---------------------");
		}
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("Browsr closed-------------------------");
	}
}

