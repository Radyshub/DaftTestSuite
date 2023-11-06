package tests;

import core.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestBase {
	
	private WebDriver driver;

	@Parameters({"env","browser"})
	@BeforeSuite
	public void initSuite(String env,String browser) throws Exception {
		TestConfig.load(env);
		TestConfig.addProperty("browser",browser);
		TestConfig.addProperty("env",env);
	}

	@BeforeClass
	public void initDriver() {
		driver =  new DriverFactory().getDriver(TestConfig.getProperty("browser"));
	}

	@DataProvider
	public Object[][] getData(Method testCase) throws Exception {
		File testDataLocation = new File("src/test/resources/testdata");
		List<HashMap<String,String>> extractedData = null;
		String dataSource = TestConfig.getProperty("dataSource");
		String envName  =  TestConfig.getProperty("env").toUpperCase();
		JSONDataProvider testData = new JSONDataProvider(testDataLocation+"/data."+envName+".json");
		extractedData = testData.getAllData(testCase.getName());
		return this.createDataProvider(extractedData);
	}

	private Object[][] createDataProvider(Object dataSet){
		int rowNo = ((ArrayList)dataSet).size();
		Object[][] dataArray = new Object[rowNo][2];
		int dim = 0;
		for(int iRow=0;iRow<rowNo;iRow++) {
			dataArray[dim][0] = iRow+1;
			dataArray[dim][1] = ((ArrayList)dataSet).get(iRow);
			dim++;
		}
		return dataArray;
	}

	public WebDriver getDriver() {
		return driver;
	}

	@AfterClass
	public void cleanUp() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
