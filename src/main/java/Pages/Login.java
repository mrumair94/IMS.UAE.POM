package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {

 //HomePage homePage;
   @FindBy(css = "#kt_sign_in_form > div:nth-child(3) > input")
 WebElement userName;
   @FindBy(css = "#kt_sign_in_form > div:nth-child(4) > input")
   WebElement password;
   @FindBy(css = "#kt_sign_in_submit")
   WebElement SubmitBtn;

   public Login(){
       PageFactory.initElements(driver,this);
   }
 public HomePage loginFun(){

    // WebElement userName = driver.findElement(By.cssSelector("#kt_sign_in_form > div:nth-child(3) > input"));
    // WebElement password = driver.findElement(By.cssSelector("#kt_sign_in_form > div:nth-child(4) > input"));
    // WebElement SubmitBtn = driver.findElement(By.cssSelector("#kt_sign_in_submit"));


     fluentWait(10);
     userName.click();
     userName.sendKeys(prop.getProperty("user"));
     fluentWait(10);
     password.click();
     password.sendKeys(prop.getProperty("pass"));
     fluentWait(10);
     SubmitBtn.click();
     return new HomePage();

 }
}
