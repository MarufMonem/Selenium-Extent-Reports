package extentReportPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportDemo {
    ExtentReports extent;

    @BeforeTest
    public void config(){
//        Extent reports

        String path = System.getProperty("user.dir")+"\\Extent Reports\\index.html";
//        Extent Spark reporter
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

//        Change report name
        reporter.config().setReportName("Web Automation Results");
//        Document title
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
//        Set tester name
        extent.setSystemInfo("Tester", "Maruf Monem");
    }

    @Test
    public void initialDemo(){
        ExtentTest test = extent.createTest("Intial Demo");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        test.fail("Results dont match");
        extent.flush();

    }

}
