package TestPage;

import Base.Base;
import Pages.CreateSupplierPage;
import Pages.CreateWarehousePage;
import Pages.HomePage;
import Pages.Login;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateWarehousePageTest extends Base {
    public CreateWarehousePageTest(){
        super();
    }
    CreateWarehousePage createWarehousePage;
    Login login;

    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        createWarehousePage = new CreateWarehousePage();
        login.loginFun();
    }
    @Test(priority = 1)
    public void navToCreateWarehouseTest(){
        createWarehousePage.navToCreateWarehouse();
    }

    @Test(priority = 2)
    public void titelTest(){
        createWarehousePage.titel();
    }

    @Test(priority = 3)
    public void WarehouseCodeTest(){
        createWarehousePage.WarehouseCode();
    }

    @Test(priority = 4)
    public void phoneTest(){
        createWarehousePage.phone();
    }

    @Test(priority = 5)
    public void textAreaTest(){
        createWarehousePage.textArea();
    }

    @Test(priority = 6)
    public void submitTest(){
        createWarehousePage.submit();
    }



}
