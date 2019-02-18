import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class seleniumWaitDemo {
    public static void main(String[] args){
        System.getProperty("user.dir");
        String path="\\src\\main\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        WebDriver driver=new ChromeDriver();
        driver.get("https://testerhome.com");
        driver.findElement(By.linkText("登录")).click();

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));

        driver.findElement(By.id("user_login")).sendKeys("965557453@qq.com");
        driver.findElement(By.id("user_password")).sendKeys("222222222");
        driver.findElement(By.className("btn-block")).click();

        Assert.assertEquals(1,3,"expected 2 but actual is 1");

        driver.quit();
        System.out.println("pass");
    }
}
