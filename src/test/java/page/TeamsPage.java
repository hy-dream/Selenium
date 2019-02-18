package page;

import com.sun.xml.internal.ws.policy.AssertionSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TeamsPage extends NavBarPage{
    WebDriver driver;


    public TeamsPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public TeamPage gotoTeamPage(String name){
        driver.findElement(By.linkText(name)).click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.media-heading")));
        String actualTeam=driver.findElement(By.cssSelector("h1.media-heading")).getText();
        Assert.assertTrue(actualTeam.contains(name));
        return new TeamPage(driver);
    }
}
