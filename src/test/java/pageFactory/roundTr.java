package pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(extRep.class)
public class roundTr {

	@Test
	public class RoundTrip {
		WebDriver driver;
		int i=0;
		int j=0;
		WebElement price;

		@Test(priority=0, groups={"two_way"}, description="TC_03_Browser")
		public void browser() {
			browser br= new browser();
			driver = br.browsing();

		}


		@Test(priority=1, groups= {"two_way"}, description="TC_04_Twoway")
		public void roundTr() {
			System.out.println("Entering rountrip Login homepage method");
			homePage hp=new homePage(driver);

			hp.twowayHome("Chennai", "Trichy");

		}
		@Test(priority=2, groups= {"two_way"}, description="TC_05_RoundTrip")
		public void roundFlightView() throws InterruptedException{
			System.out.println("Entering roundtrip flightview method");
			ratePage ftp=new ratePage(driver);
			Thread.sleep(50000);
			List<WebElement> ls=ftp.roundListSize();
			List<WebElement> fls=ftp.fstroundListSize();
			int lstsz= ls.size();
			int flstsz=fls.size();
			//		System.out.println(lstsz+" "+flstsz);

			for (i=2;i<=lstsz;i++ ) {

				//		System.out.println("Entering value of i is "+i);

				//		price = driver.findElement(By.xpath("//div[contains(@class,'row legsContainer')]//div[1]//nav[1]//ul[1]//li["+i+"]//div[1]//label[1]//table[1]//tbody[1]//tr[1]//th[6]"));
				price = driver.findElement(By.xpath("//div[@class ='colZero leg col12']//ul//li["+i+"]//div[contains(@class,'listItem')]//label[1]//table[1]//tbody[1]//tr[1]//th[6]"));
				String fare = price.getText();
				//	System.out.println(fare);
				String fare1=fare.substring(3);
				String fare2=fare1.replace(",","");
				System.out.println(fare2);

			}
			for (j=1;j<=flstsz;j++ ) {

				//			System.out.println("Entering value of i is "+i);

				//		price = driver.findElement(By.xpath("//div[contains(@class,'row legsContainer')]//div[1]//nav[1]//ul[1]//li["+i+"]//div[1]//label[1]//table[1]//tbody[1]//tr[1]//th[6]"));
				price = driver.findElement(By.xpath("//div[@class ='colZero leg col12 last']//ul//li["+j+"]//div[contains(@class,'listItem')]//label[1]//table[1]//tbody[1]//tr[1]//th[6]"));
				String fare = price.getText();
				//		System.out.println(fare);
				String fare1=fare.substring(3);
				String fare2=fare1.replace(",","");
				System.out.println(fare2);

			}

		}

	}
}
