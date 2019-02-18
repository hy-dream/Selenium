package BusinessLogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

import java.util.concurrent.TimeUnit;

public class ClickBanner {
    WebDriver webDriver=null;

    @BeforeMethod
    public void before(){
        System.getProperty("user.dir");
        String path="\\src\\test\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default");
        //options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        webDriver=new ChromeDriver(options);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void clickBanner(){
        webDriver.get("https://testerhome.com");

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(webDriver);

        String handle1=webDriver.getWindowHandle();
        Reporter.log("当前窗口的handle 是"+handle1,true);

        homePage.clickBanner();
        WebDriverWait webDriverWait=new WebDriverWait(webDriver,10);
        webDriverWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Reporter.log("等待第二个窗口出现",true);

        for(String handle:webDriver.getWindowHandles()){
            if(!handle.equals(handle1)){
                Reporter.log("找到第二个窗口",true);
                webDriver.switchTo().window(handle);
                Reporter.log("当前窗口的handle 是"+handle,true);
                break;
            }
        }
        webDriverWait.until(ExpectedConditions.titleContains("大会"));

    }

    @AfterMethod
    public void after(){
        webDriver.quit();
    }
}
