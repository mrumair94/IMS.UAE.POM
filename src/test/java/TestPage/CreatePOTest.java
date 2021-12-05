package TestPage;

import Base.Base;
import Pages.CreatePOPage;
import Pages.HomePage;
import Pages.Login;
import Pages.EditUserListPage;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class CreatePOTest extends Base {

    Login login;
    TestingLogic testingLogic ;
    HomePage homePage = new HomePage();
    CreatePOPage createPOPage;
    //EditUserListPage editUserListPage = new EditUserListPage();
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        login.loginFun();
        createPOPage = new CreatePOPage();
        testingLogic = new TestingLogic();
    }
   @Test(priority = 1)
    public void navToCreatePOTest(){
       createPOPage.navToCreatePO();
    }
    @Test(priority = 2)
    public void fillPoTest(){
       createPOPage.fillPoTest();
    }
}
