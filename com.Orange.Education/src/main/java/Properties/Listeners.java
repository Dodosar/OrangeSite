package Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	public static String screenshotName;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Lests start test:" +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub		
		TestUtils.captureScreenshot(result);
		System.out.println("test was successed:" +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {	
		TestUtils.captureScreenshot(result);
		System.out.println("The name of the testcase failed is :"+result.getName());		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		TestUtils.captureScreenshot(result);
		System.out.println("The name of the testcase skipped is :"+result.getName());	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
