package Pages;

import Base.Base;
import org.checkerframework.checker.initialization.qual.FBCBottom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public class CreateWarehousePage extends Base {

    //Object Repo
    @FindBy (xpath = "//input[@name='title']")
    WebElement title_field;
    @FindBy(xpath = "//input[@name='code']")
    WebElement warehouse_Code_Field;
    @FindBy(xpath = "//input[@name='phone']")
    WebElement phone_field;
    @FindBy(xpath = "//textarea[@name='address']")
    WebElement address_textArea;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit_Btn;
    @FindBy(xpath = "//button[text()='OK']")
    WebElement OK_Btn;

    HomePage homePage = new HomePage();

    //Actions
    public CreateWarehousePage(){
        PageFactory.initElements(driver,this);
    }

    public void navToCreateWarehouse() {
        homePage.createWarehouse();
    }

    public void titel(){
        expwait(30, title_field);
        title_field.click();
        String title = faker.name().firstName()+"_auto_Warehouse";
        title_field.sendKeys(title);
        setvalues("warehouse_Title", title);
    }
    public void WarehouseCode(){
        expwait(30, warehouse_Code_Field);
        warehouse_Code_Field.click();
        warehouse_Code_Field.sendKeys(faker.code().asin());
    }
    public void phone(){
        expwait(30, phone_field);
        phone_field.click();
        phone_field.sendKeys("55 406 1723");
    }
    public void textArea(){
        expwait(30, address_textArea);
        address_textArea.click();
        address_textArea.sendKeys(faker.address().fullAddress());
    }
    public void submit(){
        expwait(30, submit_Btn);
        submit_Btn.submit();
        expwait(30,OK_Btn);
        OK_Btn.click();
    }



}
