package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.List;

public class AddLineItems extends Base {

    HomePage homePage;
    Login login;
    CreatePOPage createPOPage;
    String title="";
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
         Thread.sleep(3000);
         createPOPage.fillPoTest();
         Thread.sleep(3000);
         WebElement editbtn= driver.findElement(By.xpath("//table[@id='basic_datatable']/tbody/tr/td[@class='sorting_1']/following-sibling::td[text()='ORDERING']/following-sibling::td[text()='0.00']/following-sibling::td/a[@title='Edit details']"));
         expwait(30,editbtn);
         editbtn.click();
     }
        }
        @Test(priority = 3)
    public void add_Product_product() throws InterruptedException {

        WebElement productDropdown = driver.findElement(By.xpath("//span[@id='select2-product-container']"));
        expwait(30,productDropdown);
        productDropdown.click();
       WebElement productDropdownField = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
       expwait(30,productDropdownField);
            productDropdownField.sendKeys("apple");
            Thread.sleep(4000);
        WebElement selectProduct = driver.findElement(By.xpath("//ul[@id='select2-product-results']/li[1]"));
        expwait(60, selectProduct);
        selectProduct.click();

        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("3");
        driver.findElement(By.xpath("//input[@name='price']")).sendKeys("10");
        driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Create Purchase Order Item')]")).click();
        WebElement elem1 = driver.findElement(By.xpath("//div[@class='card-title']/h2"));
            title=  elem1.getText().replace("ID: ","");
            System.out.println(title);
            setvalues("PO_Number",title);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[text()='OK']")).click();
            driver.findElement(By.xpath("//ul/li[@class='breadcrumb-item text-muted']/a[contains(text(),'Purchase Order')]")).click();
    }

    @Test(priority = 4)
    public void changeStatus() throws InterruptedException {
        Thread.sleep(3000);
        WebElement searchAll= driver.findElement(By.xpath("//input[@id='all_search']"));
        searchAll.sendKeys(title);
        //searchAll.sendKeys(prop.getProperty("PO_Number"));
        driver.findElement(By.xpath("//button[@id='search']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//td/a[@title='Edit details']")).click();
        Thread.sleep(1500);
        WebElement elem = driver.findElement(By.id("status"));
        Thread.sleep(1500);
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
