package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamPage extends NavBarPage {

    WebDriver driver;
    public TeamPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public void clickTopic(String title){
        driver.findElement(By.xpath("//a[@title=\""+title+"\"]")).click();
    }
}
