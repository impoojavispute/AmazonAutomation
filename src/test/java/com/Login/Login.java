package com.Login;

import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Login {

    WebDriver driver;
    
    protected static ExtentReports extent;
	protected static ExtentTest test;
	
	@BeforeClass
	public void before() {
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReportsForLogin.html");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Test Results");
		spark.config().setReportName("Extent Report for Login");

		extent = new ExtentReports();
		extent.attachReporter(spark);

	}

    @BeforeSuite
    @Parameters({"browser", "url"})
    public void before(@Optional("chrome") String browsername, String url) {
        switch (browsername) {
            case "IE":
                System.setProperty("webdriver.ie.driver", "C:\\Users\\pooja.vispute\\eclipse-workspace\\iedriver.exe");
                driver = new InternetExplorerDriver();
                driver.get(url);
                break;

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\eclipse-workspace\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(url);
                break;
        }
    }

    @Test
    public void login() throws InterruptedException {
    	
    	test = extent.createTest("Maximize WIndow");
		test.info("Maximize Browser WIndow");
        driver.manage().window().maximize();
        
        LoginPage lp = new LoginPage(driver);
        
        test = extent.createTest("1.Accounts", "accounts");
		test.info("Click on Accounts");
        lp.accounts();
        
        test = extent.createTest("2.Username", "username");
		test.info("Enter Username");
        lp.username("7218827295");
        
        test = extent.createTest("3.Continue SIgn IN", "continue_sign");
		test.info("Click on continue_sign Button");
        lp.continue_sign();
        
        test = extent.createTest("4.Password", "password");
		test.info("Enter Password");
        lp.password("Pooja@14");
        
        test = extent.createTest("5.Sign In button", "sign_in_button");
		test.info("Click on Sign In Button");
        lp.sign_in_button();
    }

    @AfterSuite
    public void after() {
        driver.close();
        extent.flush();
    }
}
