package goPadelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoPadelHome {
	
	WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul[1]/li/a")
	WebElement menu;
	
	@FindBy(xpath = "//*[@id=\"sidebarnav\"]/li[3]/a/span")
	WebElement padelCourts;
	
	@FindBy(xpath = "//*[@id=\"sidebarnav\"]/li[3]/ul/li[3]/a/span")
	WebElement padelCourt;

	public GoPadelHome(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}

	public void clickOnPadelCourt() {	
		wait = new WebDriverWait(driver, 20);
		menu.click();
		padelCourts.click();
		padelCourt.click();
	}
}
