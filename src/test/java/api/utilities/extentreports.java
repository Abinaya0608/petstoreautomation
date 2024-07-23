package api.utilities;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreports implements ITestListener
{
		public static ExtentSparkReporter sparkReporter;
		public static ExtentReports extentreport;
		public static ExtentTest extenttest;
		String repname;
		 
		  @Override
		  public void onStart(ITestContext testcontext) 
		  {
			  String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			  repname="Test-Report-"+timeStamp+".html";
			  sparkReporter = new ExtentSparkReporter(".\\reports\\"+repname);
			  sparkReporter.config().setDocumentTitle("RestAssured Automation Project");
			  sparkReporter.config().setReportName("Pet store user API");
			  sparkReporter.config().setTheme(Theme.DARK);
			  
			  extentreport=new ExtentReports();
			  extentreport.attachReporter(sparkReporter);
			  extentreport.setSystemInfo("Application", "Pet store user API");
			  extentreport.setSystemInfo("Operatng Systems",System.getProperty("os.name"));
			  extentreport.setSystemInfo("User Name",System.getProperty("user.name"));
			  extentreport.setSystemInfo("Envirnment", "QA");
			  extentreport.setSystemInfo("user", "Abinaya");
			  
		}
		  @Override
		  public void onTestSuccess(ITestResult result) 
		  {
			  extenttest= extentreport.createTest(result.getName());
			  extenttest.assignCategory(result.getMethod().getGroups());
			  extenttest.createNode(result.getName());
			  extenttest.log(Status.PASS,"Test Passed");
			  
		  }

		  @Override
		  public void onTestFailure(ITestResult result)  
		  {
			  extenttest= extentreport.createTest(result.getName());
			  extenttest.assignCategory(result.getMethod().getGroups());
			  extenttest.createNode(result.getName());
			  extenttest.log(Status.FAIL,"Test Failed");
			  extenttest.log(Status.FAIL,result.getThrowable().getMessage());
			
		  }
		  
		  @Override
		  public void onTestSkipped(ITestResult result)  
		  {
			  extenttest= extentreport.createTest(result.getName());
			  extenttest.assignCategory(result.getMethod().getGroups());
			  extenttest.createNode(result.getName());
			  extenttest.log(Status.SKIP,"Test Skipped");
			  extenttest.log(Status.SKIP,result.getThrowable().getMessage());
			
		  }
		  
		  @Override
		  public void onFinish(ITestContext context) 
		  {
			  
			  extentreport.flush(); 
			  
		  }
	


}
