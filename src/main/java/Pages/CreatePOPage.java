package Pages;

import Base.Base;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class CreatePOPage extends Base {

    @FindBy (css = "#kt_content_container > div > div > form > div > div.card-body > div > div:nth-child(1) > span > span.selection > span")
    WebElement supDropdown;

    @FindBy(xpath = "//ul[@class='select2-results__options']/li")
    List<WebElement> supItem;

    @FindBy(css = "#kt_content_container > div > div > form > div > div.card-body > div > div:nth-child(2) > span > span.selection > span")
    WebElement selDropdown;

    @FindBy(xpath = "//ul[@id='select2-seller-results']/li")
    List<WebElement> selItem;

    HomePage homePage = new HomePage();

    public CreatePOPage(){
    PageFactory.initElements(driver,this);
  }
    public void navToCreatePO(){
    homePage.clickOnCreatePO();
     }
    public void fillPoTest(){

        //explicitwait(20,supDropdown);
        supDropdown.click();
        String Supplier = prop.getProperty("supplier_title");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(Supplier);
        driver.findElement(By.xpath("//ul[@id='select2-supplier-results']/li")).click();

       // explicitwait(20, selDropdown);
        selDropdown.click();
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys("Cartlow 212");
        driver.findElement(By.xpath("//ul[@class='select2-results__options']/li")).click();
        driver.findElement(By.xpath("//span[@class='select2-selection__placeholder'][text()='Select Warehouse']")).click();
        String warehouse = prop.getProperty("warehouse_Title");
        driver.findElement(By.xpath("//input[@class='select2-search__field']")).sendKeys(warehouse);
        driver.findElement(By.xpath("//ul[@class='select2-results__options']/li")).click();

            WebElement createPOBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            explicitwait(20, createPOBtn);
            createPOBtn.click();

            WebElement OKBtn = driver.findElement(By.xpath("//button[@type='button'][text()='OK']"));
            expwait(30, OKBtn);
            OKBtn.click();

    }
}
