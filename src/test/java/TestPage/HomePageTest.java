package TestPage;

import Base.Base;
import Pages.CreatePOPage;
import Pages.HomePage;
import Pages.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.annotation.Tainted;

public class HomePageTest extends Base {
    public HomePageTest(){
        super();
    }
    HomePage homePage;
    Login login;

  //  public HomePageTest(){super();}
    @BeforeTest
    public void setup() throws InterruptedException {
        Initialization();
       login=new Login();
        homePage = new HomePage();
      //  homePageTest =  login.loginFun();

    }
    @Test(priority =1 )
    public void loginPage()  {
        fluentWait(10);
       // login.loginFun(prop.getProperty("user"),prop.getProperty("pass") );
        login.loginFun();
    }
    @Test (priority = 2)
    public void CreatePOTest(){
        homePage.clickOnCreatePO();
    }
   //@Test(priority = 3)
    public void CreateWareHouseTest(){
        homePage.createWarehouse();
    }
   // @Test(priority = 4)
    public void navUserListTest(){
        homePage.navUserList();
    }

   // @Test(priority = 5)
    public void createLocationTest(){
        homePage.createLocation();
    }
}
