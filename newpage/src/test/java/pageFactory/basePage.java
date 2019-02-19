package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(extRep.class)
public class basePage {

	WebDriver driver;
	int i =1;

	public basePage() {
		browser br = new browser();
		driver = br.browsing();
	}

	@Test (priority=0, groups= {"oneWay"}, description= "TC_01_onetrip")
	public void oneTrip() {
		homePage hp=new homePage(driver);
		hp.Selectonetrip("Chennai","Trichy");
	}

	@Test (priority=1, groups= {"oneW"}, description= "TC_02_Singletrip")
	public void singleTrip() throws Exception {
		ratePage rp= new ratePage(driver);
		Thread.sleep(60000);
		List<WebElement> rtct=rp.singleRate();
		System.out.println("Rate from ratepage is "+rp.singleRate());
		int lstsz = rtct.size();
		System.out.println("size is "+lstsz);
		for(int i=1;i<=lstsz;i++)
		{

			String Topfare=driver.findElement(By.xpath("//ul[contains(@class,'listView flights')]//li["+i+"]//table[1]//tbody[2]//tr[1]//th[6]")).getText();
			//	System.out.println("fare is "+Topfare);
			String Tfare1=Topfare.substring(3);
			String Tfare2=Tfare1.replace(",","");
			System.out.println(Tfare2);

		}
	}

}


