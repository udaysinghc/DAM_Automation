package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class DriverFactory
{
	public static WebDriver driver;

    private WebDriver createChromeDriver(Boolean headless) {
        ChromeOptions chromeoptions = new ChromeOptions();
        if (headless) 
        {
            chromeoptions.addArguments("--headless");
            chromeoptions.addArguments("window-size=1200,1100");
        }
        chromeoptions.addArguments("disable-gpu");

        WebDriver chromedriver = new ChromeDriver(chromeoptions);            
        return chromedriver;
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions ffoptions = new FirefoxOptions();
        //ffoptions.addPreference("browser.download.folderList", 2);
        //ffoptions.addPreference("browser.download.dir", "C:\\Windows\\temp");
        //ffoptions.addPreference("browser.download.useDownloadDir", true);
        //ffoptions.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.ms-excel");

        WebDriver ffdriver = new FirefoxDriver(ffoptions);
        return ffdriver;
    }

    private WebDriver createIEDriver() {
        InternetExplorerOptions ieoptions = new InternetExplorerOptions();
        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        // capabilities.setCapability(CapabilityType.HAS_NATIVE_EVENTS, true);
        // capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        // capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
        // capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);        

        WebDriver iedriver = new InternetExplorerDriver(ieoptions);
        return iedriver;
    }

	public WebDriver initializeDriver(String browser, String baseURL, Boolean headless) throws Exception {

		if (driver != null) return driver;

        if (browser.equalsIgnoreCase("FireFox")) 
        { 
            driver = createFirefoxDriver();
        } 
        else if (browser.equalsIgnoreCase("Chrome-Mac-74")){
        	System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/mac-drivers/chromedriver_mac64_v74");
            driver = createChromeDriver(headless);
        } 
        else if (browser.equalsIgnoreCase("Chrome-Windows")){
        	System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/chromedriver.exe");
            driver = createChromeDriver(headless);
        } 
        else if (browser.equalsIgnoreCase("Chrome-Linux-75")){
        	System.setProperty("webdriver.chrome.driver", "src/main/java/drivers/linux-drivers/chromedriver_linux64_v75");
            driver = createChromeDriver(headless);
        } 
        else if (browser.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "src/main/java/drivers/IEDriverServer.exe");
            driver = createIEDriver();
		}
        else {
            throw new Exception("Unsupported selenium driver of type: " + browser);
        }
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        // TODO: Remove, this is not a responsibilty of the DriverFctory
        // It should be handled by the Cucumber Steps.
        driver.get(baseURL);

        return driver; 
    }
}
