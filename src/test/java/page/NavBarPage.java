package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPage {
    WebDriver driver;

    @FindBy(css=".form-control")
    WebElement search;

    @FindBy(css=".nav a[href*=teams]")
    WebElement teams;

    public NavBarPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void searchWord(String word){
        search.clear();
        search.sendKeys(word);
    }

    public SearchResultPage gotoSearchResultPage(String word){
        searchWord(word);
        Actions action=new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        return new SearchResultPage(driver);
    }

    public TeamsPage gotoTeams(){
        teams.click();
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hot_teams")));
        return new TeamsPage(driver);
    }
}
