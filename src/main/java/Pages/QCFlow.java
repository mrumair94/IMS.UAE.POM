package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class QCFlow extends Base {
    HomePage homePage;
    Login login;
    CreatePOPage createPOPage;
    AddLineItems addLineItems;
    JavascriptExecutor js;



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
    public void ClickPOtoRecieve() throws InterruptedException {
        By processing = By.xpath("//*[@id='basic_datatable_processing']");
        explicitWaitNot(processing);
        List<WebElement> receiveBtn_Column = driver.findElements(By.xpath("//tr/td/a[@title='Receive']"));
        List<WebElement> priceColumn = driver.findElements(By.xpath("//tr/td[text()='INVOICED']/following-sibling::td[1]"));
        String p = "";
        System.out.println(receiveBtn_Column.size());
        int i = 0;
        if (receiveBtn_Column.size() > 0 ){
            for (WebElement Btn : receiveBtn_Column) {
                p = priceColumn.get(i).getText();
                if (!(p.equals("0.00"))) {
                    System.out.println(p);
                    Btn.click();
                }
                i++;
            }
    }
    }
}