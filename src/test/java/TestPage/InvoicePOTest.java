package TestPage;

import Base.Base;
import Pages.AddLineItems;
import Pages.CreateSupplierPage;
import Pages.HomePage;
import Pages.Login;
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
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        homePage = new HomePage();
        createSupplierPage = new CreateSupplierPage();
        addLineItems = new AddLineItems();
        login.loginFun();

    }
    @Test(priority = 1)
    public void navToPoList(){
        homePage.editPO();
    }
    @Test(priority = 2)
    public void change_status() throws InterruptedException {
        Thread.sleep(3000);
        int a = 0;
        List<WebElement> price = driver.findElements(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[text()='ORDERING']/following-sibling::td[1]"));
        List<WebElement> Btn = driver.findElements(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[text()='ORDERING']/following-sibling::td[2]/a[2]"));
       // String amount = price.getText();
        WebElement btn = driver.findElement(By.xpath("//*[@id='basic_datatable']/tbody/tr[1]/td[5]/a[2]/i"));
        System.out.println("Not found 0");
        WebElement editbtn= driver.findElement(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[@class='sorting_1']/following-sibling::td[text()='ORDERING']/following-sibling::td[text()='0.00']/following-sibling::td/a[@title='Edit details']"));
        expwait(40,btn);
        if(Btn.size()==0){
           for(WebElement price2:price){
               System.out.println("Not found 2.1");
              String str1 = price2.getText();
               String[] parts = str1.split("\\.");
               String part1 = parts[0];
               int num = Integer.parseInt(part1);
               System.out.println(part1);
               if (num>1){
                   System.out.println("Not found 2.2");
                   Thread.sleep(1500);
                   Btn.get(a).click();
               }
               a++;
           }if(Btn.size()==0) {
                System.out.println("Not found 2");
                Thread.sleep(3000);
                expwait(30,editbtn);
                editbtn.click();
                addLineItems.add_Product_product();
            }
        }
    }
  //  @Test(priority = 3)
    public void status() throws InterruptedException {
        WebElement elem = driver.findElement(By.id("status"));
        //expwait(30,elem);
        elem.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div[1]/form/div/div[2]/div[1]/div[3]/select/option[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Save Changes')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@type='button'][text()='OK']")).click();


    }
}