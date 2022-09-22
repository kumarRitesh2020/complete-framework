package org_salesandinventory_genericutility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementaion implements ITestListener
{
	private ExtentReports reports;
	public static ExtentTest stest;
	private ExtentTest test;
   
	@Override//BT
	public void onStart(ITestContext context) 
	{
     		ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/extentreport.html");
     		spark.config().setDocumentTitle("Document Tilte-SDET 40");
     		spark.config().setReportName("Report Name-SDET 40");
     		spark.config().setTheme(Theme.DARK);
     		
		    reports=new ExtentReports();
		    reports.attachReporter(spark);
		    reports.setSystemInfo("Author", "Rakesh");
		    reports.setSystemInfo("OS", "Win 11");
		    reports.setSystemInfo("Browser", "chrome");
		    
	}
    
    @Override
    public void onTestStart(ITestResult result)
    {
    	test=reports.createTest(result.getMethod().getMethodName());
    	stest=test;
    }
		
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		test.pass(result.getMethod().getMethodName()+"pass");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
	 //  new Webdriverutility().screenShot(Baseclass.sDriver,Baseclass.sJavautility,result.getMethod().getMethodName());
		String address = new Webdriverutility().screenShot(Baseclass.sDriver);
		test.addScreenCaptureFromBase64String(address);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	 reports.flush();
	}

	
	

}
