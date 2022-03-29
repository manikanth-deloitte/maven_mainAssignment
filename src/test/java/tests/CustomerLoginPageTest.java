package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CustomerLoginPage;


public class CustomerLoginPageTest extends BankManagerLoginTest{
    CustomerLoginPage customer;

    public CustomerLoginPageTest()  {
        customer = new CustomerLoginPage();
    }
    @Test(priority = 7)
    public void validateClickCustomerLogin() {
        test = super.report.createTest("clickCustomerLogin");
        try{
            customer.clickCustomerLogin();
            test.pass("clicked successfully");
        }catch(Exception e){
            System.out.println("click on customer login is failed");
            test.fail("click-unsuccessful");
        }
    }
    @Test(priority = 8 )
    public void validateSelectCustomer(){
        test = super.report.createTest("selectcustomer");
        try{
            customer.selectCustomerLoginName();
            test.pass("selected customer to login successfully");
        }catch(Exception e){
            System.out.println("selecting is unsuccessful");
            test.fail("failed to select");
        }
    }
    @Test(priority = 9)
    public void validateSelectDeposit() {
        test = report.createTest("deposit");
        try{
            customer.selectDeposit();
            test.pass("deposit successful");
        }catch(Exception e){
            System.out.println("deposit  unsuccessful ");
            test.fail("deposit failed");
        }
    }
    @Test(priority = 10)
    public void validateSelectWithdraw()  {
        test = report.createTest("withdraw");
        try{
            customer.selectWithdraw();
            test.pass("withdraw successful");
        }catch(Exception e){
            System.out.println("withdraw successful");
            test.fail("withdraw failed");
        }
    }
    @Test(priority = 11)
    public void validateExceedAmount()  {
        test = report.createTest("exceedAmount");
        try{
            customer.exceedMountDraw();
            test.info("trying to withdraw the money more than balance amount");
            test.pass("passed");
        }catch(Exception e){
            System.out.println("ExceedAmount-failed");
            test.fail("failed");

        }
    }
    @Test(priority = 12)
    public void validateVerifyTransac() {
        test= report.createTest("verifyTransaction");
        try{
            customer.verifyTransactions();
            test.pass("verified successfully");
        }catch(Exception e){
            System.out.println("verification of transaction is failed");
            test.fail("transaction verification is failed");
        }
    }
    @Test(priority = 13)
    public void validatehome() {
        test= report.createTest("homepage");
        try{
            customer.homePage();
            test.pass("navigating to homepage is successful");
        }catch(Exception e){
            System.out.println("going to homepage is failed");
            test.fail(" navigating to homepage is failed");
        }
    }
    @AfterTest
    public void exit(){
        report.flush();
        driver.quit();
    }

}
