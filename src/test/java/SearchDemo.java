import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchDemo {
    WebDriver webDriver=null;

    @BeforeMethod
    public void before(){
        System.getProperty("user.dir");
        String path="\\src\\test\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        webDriver=new ChromeDriver();
    }

    @Test
    public void testSearch(){
        webDriver.get("https://testerhome.com");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.cssSelector(".form-control")).sendKeys("selenium");

        //模拟键盘输入
        Actions action=new Actions(webDriver);
        action.sendKeys(Keys.ENTER).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void after(){
        webDriver.quit();
    }
}
