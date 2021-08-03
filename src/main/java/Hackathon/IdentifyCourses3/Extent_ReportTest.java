package Hackathon.IdentifyCourses3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_ReportTest 
{
	public ExtentReports create(ExtentReports report)
	{
		String path=System.getProperty("user.dir")+"\\ExtentReport\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TestResult");
		reporter.config().setReportName("HackathonTestResult");
		report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("Tester","Technocrats");
		return report;
	}
}
