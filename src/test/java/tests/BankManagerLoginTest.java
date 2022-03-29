package tests;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BankManagersLogin;
import pages.DriverClass;
import java.io.IOException;

public class BankManagerLoginTest extends DriverClass {
    BankManagersLogin managerLog;
    public static ExtentTest test;

    @BeforeTest
    public void setUp() throws IOException {

        driverCreation();
        managerLog = new BankManagersLogin(super.driver);
    }
    @Test(priority = 1)
    public void validateBankMangerClick() {
        test = report.createTest("bankManagerClick");
        try {
            managerLog.BankClick();
            test.info("clicked on bankmanager button Successfully");
        } catch (Exception e) {
           System.out.println("opening manager bank is failed");
        }
    }
    @Test(priority = 2)
    public void validateAddCustomer() {
        test = report.createTest("addCustomer");
        try{
            managerLog.enterFirstname();
            managerLog.enterLastname();
            managerLog.enterPin();
            test.pass("creating account started successfully");
            test.info("details are added");
        }catch(Exception e){
            System.out.println("adding to input data field is failed");
            test.fail("adding customer is failed");

        }
    }
    @Test(priority = 3)
    public void validateADD() {
        test = report.createTest("clickAdd");
        try {
            managerLog.clickAdd();
            test.pass("successfully added");

        }catch (Exception e){
            System.out.println("adding customer details is failed");
            test.fail("adding details is failed");
        }

    }
    @Test(priority = 4)
    public void validateConfirmAdd(){
        test=report.createTest("alertConfirm");
        try{
            managerLog.confirmAdd();
            test.pass("alert confirmation is passed");
        } catch (Exception e) {
            System.out.println("confirmation is failed");
        }
    }
    @Test(priority = 5)
    public void validateOpenCustomer(){
        test = report.createTest("openCustomer");
        try{
            managerLog.openCustomer();
            test.pass("open customer is successful");
        }catch(Exception e){
            System.out.println("open account button  is failed");
            test.fail("open account is failed");
        }
    }
    @Test(priority = 6)
    public void validateSelect(){
        test = report.createTest("selectcustomer");
        try{
            managerLog.selectCustomer();
            managerLog.selectCurreny();
            managerLog.process();
            test.pass("customer is selected successfully");

        }catch(Exception e) {
            System.out.println("selection is failed");
            test.fail("selecting customer is failed");
        }
    }
}
