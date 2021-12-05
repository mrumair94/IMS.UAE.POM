package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateSupplierPage extends Base {
    //Objec Reposotory

    @FindBy(xpath = "//span[@class='menu-title'][text()='Suppliers']")
    WebElement supplier_menu;
    @FindBy(xpath = "//span[@class='menu-title'][text()='Create Supplier']")
    WebElement create_supplier_menu;
    @FindBy(xpath = "//input[@name='title']")
    WebElement title_field;
    @FindBy(xpath = "//input[@name='tax_number']")
    WebElement tax_numberField;
    @FindBy (xpath = "//input[@name='code']")
    WebElement Supplier_code;
    @FindBy(xpath = "//textarea[@class='form-control form-control-sm']")
    WebElement address_text;
    @FindBy(xpath = "//input[@class='form-check-input']")
    WebElement is_active;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement create_supplier_Btn;
    @FindBy(xpath = "//button[@type='button'][text()='OK']")
    WebElement click_ok_Btn;


public CreateSupplierPage()  {
   // super();
    PageFactory.initElements(driver,this);


}

public void navToCreateSupplier(){
    expwait(30,supplier_menu);
    supplier_menu.click();
    expwait(20,create_supplier_menu);
    create_supplier_menu.click();
}
public void provide_title() {
    expwait(30, title_field);
    title_field.click();
    String title =faker.company().name();
    setvalues("supplier_title", title);
    title_field.sendKeys(title);
}
    public void provide_tax_number(){
        expwait(30, tax_numberField);
        tax_numberField.click();
        tax_numberField.sendKeys(faker.code().ean8());
    }
    public void provide_Supplier_code(){
        expwait(30, Supplier_code);
        Supplier_code.click();
        Supplier_code.sendKeys(faker.code().asin());
    }
    public void provide_address_text(){
        expwait(30, address_text);
        address_text.click();
        address_text.sendKeys(faker.address().fullAddress());
    }
    public void check_is_active(){
        expwait(30, is_active);
        is_active.click();
    }

public void click_create_supplier_Btn(){
    expwait(30, create_supplier_Btn);
    create_supplier_Btn.click();
}
    public void click_ok_Btn(){
        expwait(30, click_ok_Btn);
        click_ok_Btn.click();
    }


}
