package com.Add_To_Cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Add_To_Cart

{

	WebDriver driver;
	/*
	 * ExtentReports extent; ExtentTest test;
	 */
	protected static ExtentReports extent;
	protected static ExtentTest test;

	@BeforeClass
	public void before() {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Test Results");
		spark.config().setReportName("Extent Report for Add To Cart");

		extent = new ExtentReports();
		extent.attachReporter(spark);

	}

	@BeforeSuite

	@Parameters({ "browser", "url" })

	public void before(@Optional("chrome") String browsername, String url)

	{

		switch (browsername)

		{

		case "IE":

			System.setProperty("webdriver.ie.driver", "C:\\Users\\user\\eclipse-workspace\\InternetExplorer.exe");

			driver = new InternetExplorerDriver();

			driver.get(url);

			break;

		case "chrome":

			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\user\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.get(url);

		}

	}

	@Test

	public void add_to_cart() throws InterruptedException

	{

		test = extent.createTest("Maximize WIndow");
		test.info("Maximize Browser WIndow");
		driver.manage().window().maximize();

		Add_To_Cart_Obj ad = new Add_To_Cart_Obj(driver);

		test = extent.createTest("1.DropDOwn", "DropDown");
		test.info("DropDown Opened");
		ad.all_dropdown();

		test = extent.createTest("2.Search", "Search");
		test.info("Searched Hindi Books");
		ad.search("Hindi Books");

		test = extent.createTest("3.Search Button", "SearchButton");
		test.info("Click Search Button");
		ad.searchbutton();

		test = extent.createTest("4. Select Book", "SelectBook");
		test.info("Book Selected");
		ad.selectbook();

		test = extent.createTest("5. Add To Cart", "AddToCart");
		test.info("Item Added");
		ad.addtocart();

		test = extent.createTest("6. Check Cart", "CheckCart");
		test.info("VerifyItem");
		ad.checkcart();

	}

	@AfterSuite

	public void afer()

	{

		driver.close();
		extent.flush();

	}

}
