package com.crm.autodesk.GenericUtils;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listeners implements ITestListener {
	
	 ExtentReports reports;
	 ExtentTest test;
	 
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+ "is passed");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getThrowable());
		test.log(Status.FAIL, result.getMethod().getMethodName()+"is Failed");
		
		BaseClass baseClass =  new BaseClass();
		
		try {
			 
			String path =baseClass.getScreenshot((result.getMethod().getMethodName()));
			test.addScreenCaptureFromPath(path);
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"is SKIPPED");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentReportsSDET21/ExtentsReports1.html");
		
		reporter.config().setDocumentTitle("SDET21");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("BuildNo", "5.1");
		reports.setSystemInfo("Env", "Pre-Prod");
		reports.setSystemInfo("Plateform", "Windows");
		reports.setSystemInfo("Browser Version", "Chrome-93");
		
	}

	public void onFinish(ITestContext context) {
		reports.flush();
		
	}
	
	
	
	
	

}
