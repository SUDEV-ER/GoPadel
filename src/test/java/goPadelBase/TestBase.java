package goPadelBase;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver driver;
	public static Properties envConfig;
	WebDriverWait wait;
	

	public static final String ENV = System.getProperty("env", "Production");

	private static final String BROWSER = System.getProperty("browser", "Chrome");
	

	@BeforeSuite
    public void suiteSetup() throws Exception {
		
		if (BROWSER.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
         }
		else if (BROWSER.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);             
         }
		 else if (BROWSER.equals("IE")) {
			 WebDriverManager.iedriver().setup();
             driver = new InternetExplorerDriver();
         }
		 else {
             throw new RuntimeException("Browser type unsupported");
         }
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 20);

		InputStream configFile = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\config\\" + ENV +  ".properties");	 
		envConfig = new Properties();
		envConfig.load(configFile);
		
	    driver.get(envConfig.getProperty("baseUrl"));
	}
}
