/* This is the test method  under @Test annotation,and need to run to execute the testcases*/



package com.aircanada.testCases;
import org.testng.annotations.Test;
import com.aircanada.pageObjects.SearchFlightPage;
import com.aircanada.pageObjects.SelectFlightPage;
import com.aircanada.pageObjects.SelectSitePage;
import com.aircanada.testBase.BaseClass;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchFlightTest extends BaseClass{

	static WebDriverWait wait;

	@Test()
	public void book_flight_roundTrip() throws InterruptedException 

	{
		SelectSitePage sfPage=new SelectSitePage(driver);
		sfPage.select_siteEditor(driver,10);
		sfPage.set_country();
		sfPage.select_language();
		sfPage.select_confirm();
		logger.info("Country and Language set as desired---------------------");

		SearchFlightPage sf=new SearchFlightPage(driver);
		sf.select_FlightTab();
		logger.info("Flight tab selected---------------------------");

		sf.select_RoundTrip();
		logger.info("Round Trip selected------------------------");

		sf.select_Origin(driver,20,"vancouver");
		logger.info("Origin selected------------------");

		sf.select_Destination(driver,20,"yyz");
		logger.info("Destination selected-----------------");

		sf.select_DepertureDate("July 15, 2022","15");
		sf.select_returnDate("22/07");
		logger.info("Departure and Return dates are selected-------------------");

		SelectFlightPage sfObject=sf.find_Flight();

		sfObject.verifying_SelectFlightPage();
		sfObject.verifying_departureDate(driver, 20,"July 15, 2022");
		logger.info("Departure date is verified---------------------");

		sfObject.verifying_tabs();
		logger.info("Tabs are verified-------------------------");

	}
}



