package goPadelPages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoPadelLogin {
	
		WebDriver driver;
		
		private static final Logger log = LogManager.getLogger(GoPadelLogin.class);
		
		@FindBy(xpath = "//*[@id=\"loginform\"]/form/div/div/div[1]/div/input")
		WebElement username;
		
		@FindBy(xpath = "//*[@id=\"loginform\"]/form/div/div/div[2]/div/input")
		WebElement password;
		
		@FindBy(xpath = "//*[@id=\"loginform\"]/form/div/div/div[5]/div/button")
		WebElement loginButton;
		
		public GoPadelLogin(WebDriver driver) {
			this.driver = driver;
	        PageFactory.initElements(driver, this);
		}
		
		public void setUsername(String uname) {
			username.sendKeys(uname);
		}
		
		public void setPassword(String pwd) {
			password.sendKeys(pwd);
		}
		
		public void clickLoginButton() {
			loginButton.click();
		}
		
		public GoPadelHome login(String username, String password) {
			log.info("Logging with username - " + username + "  and password - " + password);
			setUsername(username);
			setPassword(password);
			clickLoginButton();
			return new GoPadelHome(driver);
		}
		
		public String getTitle() {
			return driver.getTitle();
		}

	}
