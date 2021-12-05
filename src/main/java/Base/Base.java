package Base;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.helpers.Util;

import java.io.*;
import java.time.Duration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class Base {
    public static Properties  prop;
    public static WebDriver driver;
    public static Faker faker = new Faker(Locale.US);
    ;

public Base(){


    try {
        if (prop == null) {
            prop = new Properties();
        }
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
        prop.load(ip);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

 public static void Initialization ()  {
     String browserName = prop.getProperty("browser");

     if (browserName.equals("chrome")) {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
     } else if (browserName.equals("FF")) {
         WebDriverManager.firefoxdriver().setup();
         driver = new FirefoxDriver();
     }


     driver.manage().deleteAllCookies();
     driver.manage().window().maximize();
     driver.get(prop.getProperty("url"));
    // driver.manage().timeouts().pageLoadTimeout(100, SECONDS);



 }
    public void setvalues(String key, String value)  {
        FileInputStream in = null;
        try {
            in = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties props1 = new Properties();
        try {
            props1.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(System.getProperty("user.dir") + "/src/main/java/config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        props1.setProperty(key, value);
        try {
            props1.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLoginCredentials(String type, String key){
        String path = "./src/main/resources/credential.json";
        Object objects =
                null;
        try {
            objects = new JSONParser().parse(
                    new FileReader(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = (JSONObject) objects;
        JSONObject list = (JSONObject) jsonObject.get(type);
        Object level = list.get(key);
        return level.toString();
    }

    public void updateLoginCredentials(String title, String Key, String Value) {
        String path = "./src/main/resources/Credentials.json";
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) jsonParser.parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject data = (JSONObject) jsonObject.get(title);
        data.put(Key, Value);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void explicitwait(int i, WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
        wait.until(ExpectedConditions.visibilityOf(elem));
    }
public void expwait(int i, WebElement elem) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
    wait.until(ExpectedConditions.elementToBeClickable(elem));
    wait.until(ExpectedConditions.visibilityOf(elem));
}
    public void expwait(int i, String xpath){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(i));
       // String xpath = null;
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(xpath))));

}
    public void simpleWait(int time ){
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
    }

    public static void fluentWait(int time){
        FluentWait fWait = new FluentWait(driver);
        fWait.withTimeout(Duration.ofSeconds(time));
    }

    public void random(List<WebElement> elem, String randmMsg){
    List<WebElement> element=elem;
    int length = element.size();
    int randomNumber = (int) (Math.random() * length);
        Actions actions = new Actions(driver);
        actions.moveToElement(element.get(randomNumber));
        actions.click(element.get(randomNumber));
        actions.build().perform();
        System.out.println(randmMsg+" : "+randomNumber);


    }


}
