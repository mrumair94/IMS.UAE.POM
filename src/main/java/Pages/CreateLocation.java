package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLocation extends Base {

    //Object Repo
    @FindBy(xpath ="//input[@name='title']" )
    WebElement title_field;
    @FindBy(xpath = "//span[text()='Select an option']")
    WebElement Location_type;

    @FindBy(xpath = "//*[@id='kt_content_container']/div/div/form/div/div[2]/div/div[3]/span/span[1]/span")
    WebElement warehouse_Dropdown;
    @FindBy (xpath = "//input[@type='search']")
    WebElement search;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement create_supplier_Btn;
    @FindBy(xpath = "//button[@type='button'][text()='OK']")
    WebElement click_ok_Btn;

    HomePage homePage = new HomePage();

    public CreateLocation(){PageFactory.initElements(driver,this);}



    public void navToCreateLocaiton(){
        homePage.createLocation();
    }

    public void provide_locationTitle() {
        expwait(30,title_field);
        title_field.click();
        title_field.sendKeys(faker.address().cityName()+"_automation");
    }

    public void provide_locType(){
        expwait(30,Location_type);
        Location_type.click();
        expwait(40,Location_type);
        Location_type.findElement(By.xpath("//ul[@class='select2-results__options']/li[2]")).click();
    }

    public void select_Warehouse(){
        expwait(40,warehouse_Dropdown);

        warehouse_Dropdown.click();
        search.click();
        String warehouse =  prop.getProperty("warehouse_Title");
        search.sendKeys(warehouse);
        WebElement warehouse_Dropdown_list = driver.findElement(By.xpath("//ul[@id='select2-warehouse_id-results']/li[text()=' "+warehouse+" ']"));
        warehouse_Dropdown_list.click();
    }
    public void click_Create_warehouse_Btn(){
        create_supplier_Btn.click();
        click_ok_Btn.click();
    }
}
