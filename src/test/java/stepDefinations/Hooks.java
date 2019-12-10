package stepDefinations;

import org.testng.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.DriverFactory;

public class Hooks extends DriverFactory{
	
    @Before
	public void setUp() throws Exception
	{
		// Reading parameters example from:
		// https://stackoverflow.com/questions/55808880/how-to-pass-testng-parameter-into-cucumber
		String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
		String baseURL = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("baseURL");
		String headlessSetting = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("headless");
        Boolean headless = headlessSetting.equalsIgnoreCase("true");

		initializeDriver(browser, baseURL, headless);
	}

	@After
	public void closeDriver()
	{
		driver.close();
		driver = null;
	}
	
}
