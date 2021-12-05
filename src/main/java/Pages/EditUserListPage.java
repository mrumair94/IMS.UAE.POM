package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.Test;

import java.util.List;

public class EditUserListPage extends Base {

    //Object Repo
    @FindBy(xpath = "//input[@name='all_search']")
    WebElement search_allField;
    @FindBy(xpath = "//button[@id='search']")
    WebElement Search_Btn;
    @FindBy(css = "#kt_table_users > tbody > tr > td:nth-child(6) > a.btn-sm.btn.btn-clean.btn-icon.btn-light-primary.me-2.p-0")
    WebElement clickEditBtn;
    @FindBy(xpath = "//*[@id='kt_modal_add_role_form']/div/div[2]/div[1]/div[3]/div/span/span[1]/span")
    WebElement warehouseDropdown;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement Submit_Btn;
    @FindBy(xpath = "//span[@class='select2-results']/ul/li")
    public List<WebElement> dropdownList;
    @FindBy(xpath = "//button[text()='OK']")
    WebElement OK_Btn;

    HomePage homePage = new HomePage();
    Login login = new Login();

    //Actions
    public EditUserListPage() {
        PageFactory.initElements(driver, this);
    }
    public void NavUSerList() {
        homePage.navUserList();
    }
    public void searchAll() {
        //Type email in All Search Text Field
        search_allField.click();
        search_allField.sendKeys(prop.getProperty("user"));
        //Click on Search Button
        expwait(30, Search_Btn);
        Search_Btn.click();
    }
    public void clickEdit() throws InterruptedException {
        Thread.sleep(3000);
       // Actions act = new Actions(driver);
       // act.moveToElement(clickEditBtn).click().build().perform();
        clickEditBtn.click();
    }
    public void selectLastwareHouse() throws InterruptedException {
        Actions act = new Actions(driver);
        warehouseDropdown.click();
        Thread.sleep(3000);
        String title = prop.getProperty("warehouse_Title");
        expwait(50, "//*[@id='kt_modal_add_role_form']/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span/textarea");
        WebElement dd_field = driver.findElement(By.xpath("//*[@id='kt_modal_add_role_form']/div/div[2]/div[1]/div[3]/div/span/span[1]/span/span/textarea"));
        dd_field.sendKeys(title);
        Thread.sleep(3000);
        System.out.println(title);
        //WebElement element = driver.findElement(By.xpath("//ul[@class='select2-results__options']/li"));
        List<WebElement> inner_List =   driver.findElements(By.xpath("//li[@class='select2-results__option select2-results__option--selectable select2-results__option--selected select2-results__option--highlighted']"));
        WebElement elem1 = driver.findElement(By.xpath("//ul[@class='select2-results__options']/li"));
        expwait(50, elem1);
        if (inner_List.size()==0) {
            elem1.click();
        } else {
            warehouseDropdown.click();
        }
    }
        public void clickSubmitBtn () {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            expwait(50, Submit_Btn);
            Submit_Btn.click();
            expwait(30, OK_Btn);
            OK_Btn.click();
        }
    }
