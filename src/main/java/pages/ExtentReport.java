package pages;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {
    public static ExtentReports report;
    public static ExtentSparkReporter spark;
    public static  ExtentTest test;

    public void getExtent(){
        String path="C:\\Users\\amanikanth\\IdeaProjects\\maven_mainAssignment\\index.html";
        report = new ExtentReports();
        spark = new ExtentSparkReporter(path);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Report");
        report.attachReporter(spark);

    }
}
