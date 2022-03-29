package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class CustomerLoginPage extends DriverClass  {


    public void clickCustomerLogin() throws InterruptedException {
        WebElement loginEle = driver.findElement(By.xpath("//button[@ng-click='customer()']"));
        loginEle.click();
        Thread.sleep(2000);
    }
    public void selectCustomerLoginName() throws InterruptedException {
        WebElement selectEle = driver.findElement(By.xpath("//select[@id='userSelect']"));
        Select objSelect = new Select(selectEle);
        objSelect.selectByVisibleText("kushal siddartha Srivastava");
        Thread.sleep(2000);
        WebElement loginClick = driver.findElement(By.xpath("//button[text()='Login']"));
        loginClick.click();
        Thread.sleep(2000);
    }
    public void selectDeposit() throws InterruptedException {
        WebElement selctDep = driver.findElement(By.xpath("//button[@ng-click='deposit()']"));
        selctDep.click();
        Thread.sleep(2000);
        String actualBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
        WebElement addDep = driver.findElement(By.xpath("//input[@placeholder='amount']"));
        addDep.sendKeys("1000");
        Thread.sleep(2000);
        WebElement add = driver.findElement(By.xpath("//button[text()='Deposit']"));
        add.click();
        Thread.sleep(2000);
        boolean showMessageDeposit = driver.findElement(By.xpath("//span[text()='Deposit Successful']")).isDisplayed();
        if (showMessageDeposit) {
            System.out.println("Deposit Successful");
        }
        String afterBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
        int actualB = Integer.parseInt(actualBal);
        int afterB = Integer.parseInt(afterBal);
        if(afterB ==(actualB+1000)){
            System.out.println(" deposit balance updated successfully");
        }
    }
        public void selectWithdraw() throws InterruptedException {
            WebElement selctDraw = driver.findElement(By.xpath("//button[@ng-click='withdrawl()']"));
            selctDraw.click();
            Thread.sleep(2000);
            String actualBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
            WebElement withDraw = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
            withDraw.sendKeys("500");
            Thread.sleep(2000);
            WebElement clickDraw = driver.findElement(By.xpath("//button[text()='Withdraw']"));
            clickDraw.click();
            Thread.sleep(2000);
            boolean showMessageWithdraw = driver.findElement(By.xpath("//span[text()='Transaction successful']")).isDisplayed();
            String text = driver.findElement(By.xpath("//span[text()='Transaction successful']")).getText();
            if (showMessageWithdraw) {
                System.out.println(text);
            }
            String afterBal = driver.findElement(By.xpath("//div[@ng-hide='noAccount']/strong[2]")).getText();
            int actualB = Integer.parseInt(actualBal);
            int afterB = Integer.parseInt(afterBal);
            if(afterB ==(actualB-500)){
                System.out.println(" withdraw balance updated successfully");
            }
        }
        public void exceedMountDraw() throws InterruptedException {
           WebElement exceedDraw = driver.findElement(By.xpath("//input[@placeholder='amount']"));
           exceedDraw.sendKeys("800");
           Thread.sleep(2000);
           WebElement exceedWithdraw = driver.findElement(By.xpath("//button[text()='Withdraw']"));
           exceedWithdraw.click();
           Thread.sleep(2000);
           boolean withdraw = driver.findElement(By.xpath("//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")).isDisplayed();
           String text = driver.findElement(By.xpath("//span[text()='Transaction Failed. You can not withdraw amount more than the balance.']")).getText();
           if(withdraw){
                System.out.println(text);
           }
        }
        public void verifyTransactions() throws InterruptedException {
        WebElement transac = driver.findElement(By.xpath("//button[@ng-click='transactions()']"));
        transac.click();
        Thread.sleep(2000);
        String depoType = driver.findElement(By.xpath("//tr[@id='anchor0']/td[3]")).getText();
        String depoAmount = driver.findElement(By.xpath("//tr[@id='anchor0']/td[2]")).getText();

        if(depoType.contains("Credit")){
            if(depoAmount.contains("1000")){
                System.out.println("Transaction is updated as per action performed for crediting");
            }
        }
            String drawType = driver.findElement(By.xpath("//tr[@id='anchor1']/td[3]")).getText();
            String drawAmount = driver.findElement(By.xpath("//tr[@id='anchor1']/td[2]")).getText();
            if(drawType.contains("Debit")){
                if(drawAmount.contains("500")){
                    System.out.println("Transaction is updated as per action performed for withdrawal");
                }
            }
        }
        public void homePage() throws InterruptedException {
        WebElement home = driver.findElement(By.xpath("//button[@ng-click='home()']"));
        home.click();
        Thread.sleep(2000);
        }

    }

