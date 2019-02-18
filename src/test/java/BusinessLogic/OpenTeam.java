package BusinessLogic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.TeamPage;

import javax.swing.plaf.PanelUI;
import java.util.concurrent.TimeUnit;

public class OpenTeam {
    WebDriver driver;

    @BeforeMethod
    public void before(){
        System.getProperty("user.dir");
        String path="\\src\\test\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default");
        driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void OpenTeamWithoutLogin(){
        driver.get("https://testerhome.com");
        TeamPage teamPage=new HomePage(driver).gotoTeams().gotoTeamPage("霍格沃兹测试学院");
        teamPage.clickTopic("定向班第一期_Selenium 入门实战_20190217");
        String actual=driver.findElement(By.cssSelector("div.alert")).getText();
        Assert.assertEquals(actual,"访问被拒绝，你可能没有权限或未登录。");
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
