package pageFactory;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extRep implements ITestListener{
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest test;

	@Override
	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Test Finished ");
		report.removeTest(test);
		report.flush();

	}

	@Override
	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started");
		report = new ExtentReports();
		ExtentHtmlReporter htm= new ExtentHtmlReporter("./test-output/extent.html");
		htm.config().setReportName("ShanPageFactoryReport");
		htm.config().setDocumentTitle("ShanDoc");
		report.attachReporter(htm);
		report.setSystemInfo("Release 1.0", "sprint 2");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test=report.createTest(result.getMethod().getDescription());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" Test Failed");
		test.log(Status.FAIL,result.getMethod().getMethodName()+" test Failed"+result.getThrowable());
		TakesScreenshot ss =(TakesScreenshot)browser.driver;
		File srcFile = ss.getScreenshotAs(OutputType.FILE);
		File desFile = new File ("C://ss//"+result.getMethod().getMethodName()+".png");
		//	String file = test.addScreenCapture("C://ss//"+result.getMethod().getMethodName()+".png");
		//	System.out.println("Result value is "+((String) result.getTestContext().getAttribute("TCname")));

		try {
			FileUtils.copyFile(srcFile, desFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			test.log(Status.FAIL, result.getMethod().getDescription(), MediaEntityBuilder.createScreenCaptureFromPath("C://ss//"+result.getMethod().getMethodName()+".png").build());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println("Test started for "+result.getMethod().getDescription());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test= report.createTest(result.getMethod().getDescription());
		test.log(Status.PASS, result.getMethod().getMethodName()+"  Test Passed");


	}
}
