package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Base {

    //Page Factory or Object Repository

    //PO Management
    @FindBy (xpath = "//span[@class='menu-title'][text()='PO Management']")
    WebElement clickPOManag;

    @FindBy(xpath = "//span[@class='menu-title'][text()='Create Purchase Order']")
     WebElement clickCrteatePO;

   // @FindBy(xpath = "#\\#kt_aside_menu > div.menu-item.menu-accordion.hover.show > div > div:nth-child(1) > a > span.menu-title")
    //WebElement clickPOLis;
    //Edit PO
    @FindBy(xpath = "//span[@class='menu-title'][text()='Purchase Order List']")
    WebElement POlist;

    //Warehouse
    @FindBy(how = How.XPATH, using = "//*[@id='#kt_aside_menu']/div[5]")
    WebElement Warehouse;

  //  @FindBy (xpath = "//*[@id='#kt_aside_menu']/div[5]")
 // public WebElement clickWarehouse;

    @FindBy(how = How.XPATH, using = "//*[@id='#kt_aside_menu']/div[5]/div/div[2]")
    WebElement CrteateWarehouse;

    //@FindBy(xpath = "//*[@id='#kt_aside_menu']/div[5]/div/div[2]")
   // WebElement clickCrteateWarehouse;

    @FindBy(xpath = "//a[@class='menu-link ']/span[contains(text(),'Warehouse List')]")
    WebElement WarehouseLis;

    //Locations
    @FindBy (css = "#\\#kt_aside_menu > div:nth-child(3)")
    WebElement clickLocations;

    @FindBy(xpath = "//a[@class='menu-link ']/span[contains(text(),'Create Location')]")
    WebElement clickrCteateLocation;

    @FindBy(xpath = "//a[@class='menu-link ']/span[contains(text(),'Location List')]")
    WebElement clickLocationLis;

    //Suppliers
    @FindBy (css = "#\\#kt_aside_menu > div:nth-child(3)")
    WebElement clickSuppliers;

    @FindBy(xpath = "//a[@class='menu-link ']/span[contains(text(),'Create Supplier')]")
    WebElement clickCrteateSupplier;

    @FindBy(xpath = "//a[@class='menu-link ']/span[contains(text(),'Supplier List')]")
    WebElement clickSupplierLis;


    //Initializing the Page Objects:
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

   // Actions to be perform
    public CreatePOPage clickOnCreatePO(){
            expwait(40,clickPOManag );
       clickPOManag.click();
        expwait(30, clickCrteatePO);

        clickCrteatePO.click();
      return new CreatePOPage();
    }
    public AddLineItems editPO() {
        expwait(30, clickPOManag);
        clickPOManag.click();
        expwait(30, POlist);

        POlist.click();
        return new AddLineItems();
    }

   public CreateWarehousePage createWarehouse() {

    expwait(30, "//*[@id='#kt_aside_menu']/div[5]");
    WebElement WarehouseBtn = driver.findElement(By.xpath( "//*[@id='#kt_aside_menu']/div[5]"));
       WarehouseBtn.click();
    WebElement CrteateWarehouseBtn= driver.findElement(By.xpath("//span[contains(text(),'Create Warehouse')]/parent::a"));
    expwait(20,"//span[contains(text(),'Create Warehouse')]/parent::a");
       CrteateWarehouseBtn.click();
     return new CreateWarehousePage();
    }

    public void navUserList(){
        expwait(30, "//*[@id='#kt_aside_menu']/div[10]/span");

        WebElement aclmanag = driver.findElement(By.xpath("//*[@id='#kt_aside_menu']/div[10]/span"));
        aclmanag.click();

        expwait(30, "//*[@id='#kt_aside_menu']/div[10]/div/div[1]/span/span[2]");

        WebElement user =driver.findElement(By.xpath("//*[@id='#kt_aside_menu']/div[10]/div/div[1]/span/span[2]"));
        user.click();

        expwait(30, "//*[@id='#kt_aside_menu']/div[10]/div/div[1]/div/div[1]/a/span[2]");

        WebElement userList = driver.findElement(By.xpath("//*[@id='#kt_aside_menu']/div[10]/div/div[1]/div/div[1]/a/span[2]"));
        userList.click();


    }
    public void createLocation(){
        expwait(30 ,"//*[@id='#kt_aside_menu']/div[6]/span/span[2]");
        driver.findElement(By.xpath("//*[@id='#kt_aside_menu']/div[6]/span/span[2]")).click();
       expwait(30, "//*[@id='#kt_aside_menu']/div[6]/div/div[3]/a/span[2]");
        driver.findElement(By.xpath("//*[@id='#kt_aside_menu']/div[6]/div/div[3]/a/span[2]")).click();

    }
}
