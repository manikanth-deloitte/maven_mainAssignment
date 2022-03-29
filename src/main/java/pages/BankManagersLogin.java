package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class BankManagersLogin extends ReadingExcel {
    ReadingExcel excel = new ReadingExcel();
    WebDriver driver;
    public BankManagersLogin(WebDriver driver) throws IOException {
        this.driver= driver;
        excel.readCells();
    }
    public void BankClick() throws InterruptedException {
        WebElement managerClick = driver.findElement(By.xpath("//button[@ng-click='manager()']/self::button"));
        managerClick.click();
        Thread.sleep(2000);
        WebElement customerClick = driver.findElement(By.xpath("//button[@ng-click='addCust()']"));
        customerClick.click();
        Thread.sleep(2000);
    }
    public void enterFirstname() throws InterruptedException {
        String firstname = excel.getfname();
        WebElement fNameEle = driver.findElement(By.xpath("//input[@placeholder='Last Name']/preceding::div/following::div/child::div/child::div[@class='ng-scope']/child::div/child::div/child::form/child::div[1]/child::input[@placeholder='First Name']"));
        fNameEle.sendKeys(firstname);
        Thread.sleep(2000);
    }
    public void enterLastname() throws InterruptedException {
        String lastname = excel.getlname();
        WebElement lNameEle = driver.findElement(By.xpath("//input[@placeholder='Last Name']/self::input"));
        lNameEle.sendKeys(lastname);
        Thread.sleep(2000);
    }
    public void  enterPin() throws InterruptedException {
        int pinNum = excel.getpin();
        String pinNumber=Integer.toString(pinNum);
        WebElement pinEle = driver.findElement(By.xpath("//input[@placeholder='Last Name']/preceding::div/following::div/child::div/child::div[@class='ng-scope']/child::div/child::div/child::form/child::div[3]/child::input[@placeholder='Post Code']"));
        pinEle.sendKeys(pinNumber);
        Thread.sleep(2000);
    }
    public void clickAdd() throws InterruptedException {
        WebElement addBtn = driver.findElement(By.xpath("//button[@class='btn btn-default']"));
        addBtn.click();
        Thread.sleep(2000);
    }
    public void confirmAdd() throws InterruptedException {
         Alert alertMsg = driver.switchTo().alert();
         System.out.println(alertMsg.getText());
         alertMsg.accept();
        Thread.sleep(2000);
    }
    public void openCustomer() throws InterruptedException {
        WebElement openEle = driver.findElement(By.xpath("//button[@ng-click='openAccount()']"));
        openEle.click();
        Thread.sleep(2000);
    }
    public void selectCustomer() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='userSelect']"));
        Select objSelect = new Select(dropdown);
        objSelect.selectByVisibleText("kushal siddartha Srivastava");
        Thread.sleep(2000);
    }
    public void selectCurreny() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='currency']"));
        Select objSelect = new Select(dropdown);
        objSelect.selectByVisibleText("Rupee");
        Thread.sleep(2000);
    }
    public void process() throws InterruptedException {
        WebElement processEle = driver.findElement(By.xpath("//button[text()='Process']"));
        processEle.click();
        Thread.sleep(2000);
        Alert alertMsg = driver.switchTo().alert();
        System.out.println(alertMsg.getText());
        alertMsg.accept();
        Thread.sleep(2000);
        WebElement showCust = driver.findElement(By.xpath("//button[@ng-click='showCust()']"));
        showCust.click();
        Thread.sleep(2000);
        WebElement home = driver.findElement(By.xpath("//button[@ng-click='home()']"));
        home.click();
        Thread.sleep(2000);
    }
}
