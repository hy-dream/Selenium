package BusinessLogic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.util.concurrent.TimeUnit;

public class SearchKeywordDataProvider {
    WebDriver webDriver=null;

    @BeforeMethod
    public void before(){
        System.getProperty("user.dir");
        String path="\\src\\test\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        webDriver=new ChromeDriver();
    }

    @DataProvider
    public Object[][] searchSomething(){
        Object[][] o= {
                {"selenium"},
                {"TestNg"}
        };
        return o;
    }
    @Test(dataProvider = "searchSomething")
    public void testSearch(String word){
        webDriver.get("https://testerhome.com");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HomePage homePage=new HomePage(webDriver);

        SearchResultPage searchResultPage=homePage.gotoSearchResultPage(word);


    }
    @AfterMethod
    public void after(){
        webDriver.quit();
    }
}
