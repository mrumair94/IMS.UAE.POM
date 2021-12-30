package TestPage;

import Base.Base;
import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class InvoicePOTest extends Base {
    HomePage homePage;
    CreateSupplierPage createSupplierPage;
    Login login;
    AddLineItems addLineItems ;
    CreatePOPage createPOPage;
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        homePage = new HomePage();
        createSupplierPage = new CreateSupplierPage();
        addLineItems = new AddLineItems();
        login.loginFun();
        createPOPage = new CreatePOPage();
    }
    @Test(priority = 1)
    public void navToPoList(){
        homePage.editPO();
    }
    @Test(priority = 2)
    public void change_status() throws InterruptedException {
        int i=0;
        Thread.sleep(3000);
        List<WebElement> POelem=driver.findElements(By.xpath("//tbody/tr/td[4]"));
        List<WebElement> priceElem = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        List<WebElement> editBtn = driver.findElements(By.xpath("//tbody/tr/td[6]/a[2]"));
        for (WebElement status : POelem){
            Thread.sleep(1500);
            //expwait(50, status);
            String getStatusText = status.getText();
            Thread.sleep(1500);
            if(getStatusText.equals("ORDERING") && !priceElem.get(i).getText().equals("0.00")){
                Thread.sleep(1500);
                editBtn.get(i).click();
                Thread.sleep(1500);
            }else if (getStatusText.equals("ORDERING") && priceElem.get(i).getText().equals("0.00")){
                Thread.sleep(1500);
                editBtn.get(i).click();
                Thread.sleep(1500);
            }else {
                Thread.sleep(1500);
                driver.findElement(By.xpath("//a[contains(text(),'Create Purchase Order')]")).click();
                Thread.sleep(1500);
                createPOPage.fillPoTest();
                Thread.sleep(1500);
                WebElement editbtn= driver.findElement(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[@class='sorting_1']/following-sibling::td[text()='ORDERING']/following-sibling::td[text()='0.00']/following-sibling::td/a[@title='Edit details']"));
                editbtn.click();
            }
            i++;
        }
    }
    @Test(priority = 3)
    public void status() throws InterruptedException {
        WebElement elem = driver.findElement(By.id("stat7us"));
        elem.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div[1]/form/div/div[2]/div[1]/div[3]/select/option[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Save Changes')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@type='button'][text()='OK']")).click();
    }
}