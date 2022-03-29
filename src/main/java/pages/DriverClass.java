package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ExtentReport;

public class DriverClass  extends ExtentReport{
    public static WebDriver driver;
    ExtentReport extent = new ExtentReport();

     public void driverCreation(){
         System.setProperty("webdriver.chrome.driver","C:\\Users\\amanikanth\\Downloads\\chromedriver.exe");
         String url="https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
         driver=new ChromeDriver();
         driver.get(url);
         driver.manage().window().maximize();
         extent.getExtent();
     }
}
