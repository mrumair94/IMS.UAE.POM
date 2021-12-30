package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ReceivePOPage extends Base {
    HomePage homePage;
    Login login;
    CreatePOPage createPOPage;
    AddLineItems addLineItems;
    JavascriptExecutor js;
    String Po_number = "";


    @BeforeTest
    public void setup() {
        Initialization();
        js = (JavascriptExecutor) driver;
        login = new Login();
        homePage = new HomePage();
       createPOPage = new CreatePOPage();
        addLineItems = new AddLineItems();
        login.loginFun();

    }

    @Test(priority = 1)
    public void navToPOListPage() {
        homePage.editPO();
    }
    @Test(priority = 2)
    public void clickRecieveBtn() throws InterruptedException {
        By processing = By.xpath("//*[@id='basic_datatable_processing']");
        explicitWaitNot(processing);
        List<WebElement> receiveBtn_Column = driver.findElements(By.xpath("//tr/td/a[@title='Receive']"));
        List<WebElement> priceColumn = driver.findElements(By.xpath("//tr/td[text()='INVOICED']/following-sibling::td[1]"));
        List<WebElement> editBtn =driver.findElements(By.xpath("//td/a[@title='Edit details']"));
        String p = "";
        int i = 0;
        if (receiveBtn_Column.size() > 0 ){
            for (WebElement Btn : receiveBtn_Column) {
                p = priceColumn.get(i).getText();
                if (!(p.equals("0.00"))) {
                    System.out.println(p);
                    Btn.click();
                    i++;
                    Thread.sleep(1500);
                }else if(editBtn.size()>0){
                    Thread.sleep(1500);
                    editBtn.get(i).click();
                    addLineItems.add_Product_product();
                    addLineItems.changeStatus();
                    Btn.click();
                    Thread.sleep(1500);
                }else {
                    Thread.sleep(1500);
                    driver.findElement(By.xpath("//div[@class='card-toolbar']/a")).click();
                }

            }
        }else {
            Thread.sleep(1500);
            driver.findElement(By.xpath("//div[@class='card-toolbar']/a")).click();
        }
        }

    @Test(priority = 3)
    public void createPOifNoAvailable() throws InterruptedException {
        Thread.sleep(1500);
        List<WebElement> receiveBtn_Column = driver.findElements(By.xpath("//tr/td/a[@title='Receive']"));
        List<WebElement> priceColumn = driver.findElements(By.xpath("//*[@id='basic_datatable']/tbody/tr/td[5]"));
        String create_PO =driver.findElement(By.xpath("//h3[@class='card-label'][contains(text(),'Create PurchaseOrder')]")).getText();
        if (create_PO.contains("Create PurchaseOrder")) {
            createPOPage.fillPoTest();
            int i=0;
            Thread.sleep(1500);
            addLineItems.add_Product_product();
            Thread.sleep(1500);
            addLineItems.changeStatus();
            Thread.sleep(1500);
            for (WebElement receive_click : receiveBtn_Column) {
                String text = priceColumn.get(i).getText();
                if (!text.contains("0.00")) {
                    receive_click.click();
                    Thread.sleep(1500);
                    break;
                }
                Thread.sleep(1500);
                driver.findElement(By.xpath("//h1[contains(text(),' Receive By Item Page')]")).isDisplayed();
            }
        }

    }
    @Test(priority = 4)
    public void clickRefreshBtn() throws InterruptedException {
        Thread.sleep(1500);
        List<WebElement> refreshBtn = driver.findElements(By.xpath("//button/span[contains(text(),'Refresh / Prepare order for receive')]"));
        if (refreshBtn.size() > 0) {
            driver.findElement(By.xpath("//button/span[contains(text(),'Refresh / Prepare order for receive')]")).click();
        }
    }
    @Test(priority = 5)
            public void recieveAllItemsBtn() throws InterruptedException {
        Thread.sleep(3000);
        int i = 0;
        List<WebElement> recieveBtn = driver.findElements(By.xpath("//td/button[@class='btn btn-primary btn-sm receive-item'][contains(text(),'Receive')]"));

        if (recieveBtn.size() > 0) {
            for (WebElement recieveBtn1 : recieveBtn) {
                recieveBtn1.click();
                Thread.sleep(3000);
                i++;
            }
        }
    }
    @Test(priority = 6)
    public void closeBtn() throws InterruptedException {
       // createPOPage.fillPoTest();
        Thread.sleep(3000);
        List<WebElement> recieveBtn = driver.findElements(By.xpath("//td/button[@class='btn btn-primary btn-sm receive-item'][contains(text(),'Receive')]"));
        if(recieveBtn.size()==0){
           WebElement close = driver.findElement(By.xpath("//div[@class='modal-footer']/a[contains(text(),'Mark order as closed')]"));
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            close.click();
            WebElement elem1 = driver.findElement(By.xpath("//div[@class='card-title']/h2"));
            Po_number=  elem1.getText().replace("ID: ","");
            System.out.println("PO Number: " + Po_number);
            setvalues("PO_Number",Po_number);
            driver.findElement(By.xpath("//button[text()='OK']")).click();
        }
    }
    @Test(priority = 6)
    public void moveToQc() throws InterruptedException {
       // createPOPage.fillPoTest();
        WebElement movment_menu =driver.findElement(By.xpath("//span/span[text()='Movement']"));
        movment_menu.click();
        Thread.sleep(1500);
        WebElement moveToQ_menu = driver.findElement(By.xpath("//div[@class='menu-item']/a[2]/span[text()='Move To QC']"));
        moveToQ_menu.click();
        Thread.sleep(1500);
        WebElement po_Number_field = driver.findElement(By.xpath("//input[@name='po']"));
        po_Number_field.click();
        po_Number_field.sendKeys(Po_number);
        Thread.sleep(1500);
       WebElement searchBtn = driver.findElement(By.xpath("//button[@type='submit'][contains(text(),'Search')]"));
       searchBtn.click();
        Thread.sleep(1500);
       String verify_PO =driver.findElement(By.xpath("//tr/td[4]")).getText();
       if(verify_PO.matches(Po_number));
        {
            int i = 0;
            Thread.sleep(1500);
            WebElement checkBox = driver.findElement(By.xpath("//th/div/input[@class='form-check-input'][@type='checkbox']"));
            checkBox.click();
            Thread.sleep(1500);
            WebElement moveSelectedItemsBtn = driver.findElement(By.xpath("//button[contains(text(),'Move all selected Items to QC')]"));
            moveSelectedItemsBtn.click();
            WebElement oKBtn = driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
            oKBtn.click();
        }
    }
}
