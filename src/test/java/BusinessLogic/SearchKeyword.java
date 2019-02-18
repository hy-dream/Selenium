package BusinessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class SearchKeyword {
    WebDriver webDriver=null;

    @BeforeMethod
    public void before(){
        System.getProperty("user.dir");
        String path="\\src\\test\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default");
        webDriver=new ChromeDriver(options);
    }

    @Test
    public void testSearch(){
        webDriver.get("https://testerhome.com");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(webDriver);

        SearchResultPage searchResultPage=homePage.gotoSearchResultPage("selenium");
        searchResultPage.assertTopics("selenium");
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
