package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;
import java.util.List;

public class AddLineItems extends Base {

    HomePage homePage;
    Login login;
    CreatePOPage createPOPage;
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        homePage = new HomePage();
        createPOPage = new CreatePOPage();
        login.loginFun();
    }
    @Test(priority = 1)
    public void navToEditPo(){
        homePage.editPO();
    }
    @Test(priority = 2)
    public void clickEditBtn() throws InterruptedException {
        Thread.sleep(3000);
     List<WebElement> editBtn= driver.findElements(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[@class='sorting_1']/following-sibling::td[text()='ORDERING']/following-sibling::td[text()='0.00']/following-sibling::td/a[@title='Edit details']"));
     List<WebElement> edit = driver.findElements(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[@class='sorting_1']/following-sibling::td[text()='ORDERING']/following-sibling::td/a[@title='Edit details']"));
     if (editBtn.size()>0){
         for(WebElement editBtn2: editBtn){
             editBtn2.click();
         }
     }else if(edit.size()>0){
         for(WebElement Edit: edit) {
             Edit.click();
             break;
         }
     }else {
         driver.findElement(By.xpath("//div[@class='card-toolbar']/a[contains(text(),'Create Purchase Order')]")).click();
         createPOPage.fillPoTest();
         Thread.sleep(3000);
         WebElement editbtn= driver.findElement(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[@class='sorting_1']/following-sibling::td[text()='ORDERING']/following-sibling::td[text()='0.00']/following-sibling::td/a[@title='Edit details']"));
         expwait(30,editbtn);
         editbtn.click();

     }
        }
        @Test(priority = 3)
    public void add_Product_product() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='select2-product-container']")).click();
            Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("apple");
            Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@id='select2-product-results']/li[1]")).click();
            Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@name='price']")).sendKeys("10");
        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Create Purchase Order Item')]")).click();
    }
    }
