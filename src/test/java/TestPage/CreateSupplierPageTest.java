package TestPage;

import Base.Base;
import Pages.CreateSupplierPage;
import Pages.HomePage;
import Pages.Login;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateSupplierPageTest extends Base {
//    public CreateSupplierPageTest(){
//        super();
//    }
    HomePage homePage;
    CreateSupplierPage createSupplierPage;
    Login login;
    @BeforeTest
    public void setup(){
        Initialization();
        login = new Login();
        homePage = new HomePage();
        createSupplierPage = new CreateSupplierPage();
        login.loginFun();

    }
    @Test(priority = 1)
    public void navToCreateSupplierTest(){
        createSupplierPage.navToCreateSupplier();
    }
    @Test(priority = 2)
    public void provide_titleTest(){
        createSupplierPage.provide_title();
    }
    @Test(priority = 3)
    public void provide_tax_numberTest(){
        createSupplierPage.provide_tax_number();
    }
    @Test(priority = 4)
    public void provide_Supplier_codeTest(){
        createSupplierPage.provide_Supplier_code();
    }
    @Test(priority = 5)
    public void provide_address_textTest(){
        createSupplierPage.provide_address_text();
    }
    @Test(priority = 6)
    public void check_is_activeTest(){
        createSupplierPage.check_is_active();
    }
    @Test(priority = 7)
    public void click_create_supplier_BtnTest(){
        createSupplierPage.click_create_supplier_Btn();
    }
    @Test(priority = 8)
    public void click_ok_BtnTest(){
        createSupplierPage.click_ok_Btn();
    }




}
