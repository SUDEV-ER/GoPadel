package goPadelPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GoPadelCourt {

	WebDriver driver;
	public WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[3]/div/div[1]/div[1]/h3")
	WebElement courtTitle;
	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[3]/div/div[2]/a")
	WebElement addCourtButton;
	@FindBy(xpath = "//*[@id=\"main-wrapper\"]/div[3]/div/div[3]/h3")
	WebElement tableTitle;
	@FindBy(xpath = "//*[@id=\"example_filter\"]/label/text()")
	WebElement searchText;
	@FindBy(xpath = "//*[@id=\"example_filter\"]/label/input")
	WebElement searchBox;
	@FindBy(xpath = "//*[@id=\"example_previous\"]/a")
	WebElement previous;
	@FindBy(xpath = "//*[@id=\"example_next\"]/a")
	WebElement next;
	
	public GoPadelCourt(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void Title() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, courtTitle.isDisplayed());
		System.out.println("Padel Court Title = " + courtTitle.getText());
	}
	
	public void AddCourtButton() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, addCourtButton.isDisplayed());
		System.out.println("Add court button is displayed");
	}
	
	public void TableTitle() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, tableTitle.isDisplayed());
		System.out.println("Title displayed as " + tableTitle.getText());
	}

	public void SearchText() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, searchText.isDisplayed());
		System.out.println("Text displayed as " + searchText.getText());
	}
	
	public void SearchBox() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, searchBox.isDisplayed());
		System.out.println("Search Box is displayed");
	}
	
	public void PreviousButton() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, previous.isDisplayed());
		System.out.println("Previous button is displayed");
	}
	
	public void NextButton() {	
		wait = new WebDriverWait(driver, 20);
		Assert.assertEquals(true, next.isDisplayed());
		System.out.println("Next button is displayed");
	}
}
