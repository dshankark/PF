package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	WebDriver driver;
	@FindBy (xpath="//input[@value='OneWay']")
	WebElement tripOne;
	@FindBy (xpath="//input[@value='RoundTrip']")
	WebElement tripTwo;
	@FindBy (xpath="//input[@id='FromTag']")
	WebElement fromPlace;
	@FindBy (xpath="//input[@id='ToTag']")
	WebElement toPlace;
	@FindBy (xpath="//input[@id='DepartDate']")
	WebElement depDate;
	@FindBy (xpath="//div[@class='monthBlock first']/div/div/span[contains(text(),'March')]")
	WebElement depMonth;
	@FindBy (xpath="//div[contains(@class,'monthBlock first')]//a[contains(@class,'ui-state-default')][contains(text(),'27')]")
	WebElement depschDate;
	@FindBy(xpath="//input[@id='ReturnDate']")
	WebElement retschMonth;
	@FindBy (xpath="//a[contains(text(),'28')]")
	WebElement retschDate;
	@FindBy (xpath="//input[@id='SearchBtn']")
	WebElement searchbt;

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void Selectonetrip(String fromLoc, String toLoc) {
		tripOne.click();
		fromPlace.click();
		fromPlace.sendKeys(fromLoc);
		toPlace.click();
		toPlace.sendKeys(toLoc);
		depDate.click();
		depMonth.click();
		depschDate.click();
		searchbt.click();

	}

	public void Selecttwotrip(String fromLoc, String toLoc) {
		tripTwo.click();
		fromPlace.click();
		fromPlace.sendKeys(fromLoc);
		toPlace.click();
		toPlace.sendKeys(toLoc);
		depDate.click();
		depMonth.click();
		depschDate.click();
		retschMonth.click();
		retschDate.click();
		searchbt.click();
	}

	public void onewayHome(String fromLoc, String toLoc) {
		this.Selectonetrip(fromLoc,toLoc);
	}

	public void twowayHome(String fromLoc, String toLoc) {
		this.Selecttwotrip(fromLoc,toLoc);
	}
}
