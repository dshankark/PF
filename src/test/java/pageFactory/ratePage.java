package pageFactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class ratePage {
	WebDriver driver;
	@FindBy (xpath ="//table[contains(@class,'resultUnit flightDetailsLink ')]")
	List<WebElement> rateCount;
	@FindBy(xpath="//div[@class ='colZero leg col12']//ul//li//div[contains(@class,'listItem')]//label[1]//table[1]//tbody[1]//tr[1]//th[6]")
	List<WebElement> firstList;
	@FindBy(xpath="//div[@class ='colZero leg col12 last']//ul//li//div[contains(@class,'listItem')]//label[1]//table[1]//tbody[1]//tr[1]//th[6]")
	List<WebElement> roundList;

	public ratePage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	@Test
	public List<WebElement> singleRate() throws Exception {

		return rateCount;

	}

	public List<WebElement> roundListSize() throws InterruptedException{

		return roundList;
	}

	public List<WebElement> fstroundListSize() throws InterruptedException{

		return firstList;
	}
}
