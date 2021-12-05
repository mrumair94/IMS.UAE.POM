package TestPage;

import Base.Base;
import Pages.CreateSupplierPage;
import Pages.EditUserListPage;
import Pages.HomePage;
import Pages.Login;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditUserListPageTest extends Base {
    public EditUserListPageTest(){super();}
    HomePage homePage;
    EditUserListPage editUserListPage;
    Login login;
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        homePage = new HomePage();
        editUserListPage = new EditUserListPage();
        login.loginFun();
    }
    @Test (priority = 1)
    public void NavUSerListTest(){
        editUserListPage.NavUSerList();
    }
    @Test (priority = 2)
    public void searchAllTest(){
        editUserListPage.searchAll();
    }
    @Test (priority = 3)
    public void clickEditTest() throws InterruptedException {
        editUserListPage.clickEdit();
    }
    @Test (priority = 4)
    public void selectLastwareHouseTest() throws InterruptedException {
        editUserListPage.selectLastwareHouse();
    }
    @Test (priority = 5)
    public void clickSubmitBtnTest(){
        editUserListPage.clickSubmitBtn();
    }
}
