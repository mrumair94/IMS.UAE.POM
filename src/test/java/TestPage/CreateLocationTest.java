package TestPage;
import Base.Base;
import Pages.CreateLocation;
import Pages.Login;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLocationTest extends Base {
    public CreateLocationTest(){
        super();
    }
    CreateLocation createLocation;
    Login login;
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        createLocation = new CreateLocation();
        login.loginFun();
    }
    @Test(priority = 1)
    public void navToCreateLocaitonTest(){
        createLocation.navToCreateLocaiton();
    }
    @Test(priority = 2)
    public void provide_locationTitleTest(){
        createLocation.provide_locationTitle();
    }
    @Test(priority = 3)
    public void provide_locTypeTest(){
        createLocation.provide_locType();
    }
    @Test(priority = 4)
    public void select_WarehouseTest(){
        createLocation.select_Warehouse();
    }
    @Test(priority = 5)
    public void click_Create_warehouse_BtnTest(){
        createLocation.click_Create_warehouse_Btn();
    }
}
