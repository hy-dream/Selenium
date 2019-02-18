import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MicrosoftEdgeDemo {
    public static void main(String[] args){
        System.getProperty("user.dir");
        String path="\\src\\main\\drivers\\MicrosoftWebDriver.exe";
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+path);
        WebDriver driver=new EdgeDriver();

        driver.get("https://testerhome.com");
        driver.findElement(By.linkText("登录")).click();

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_login")));

        driver.findElement(By.id("user_login")).sendKeys("965557453@qq.com");
        driver.findElement(By.id("user_password")).sendKeys("222222222");
        driver.findElement(By.className("btn-block")).click();

        driver.quit();
        System.out.println("pass");
    }
}
