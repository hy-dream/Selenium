package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage extends NavBarPage{
    @FindBy(css=".topic a")
    List<WebElement> topics;

    public SearchResultPage(WebDriver driver){
        super(driver);
    }

    public void assertTopics(String value){
        for(WebElement topic:topics){
            String actual=topic.getText();
            Assert.assertTrue(actual.trim().toLowerCase().contains(value),"expected topic not contains "+value+",actual topic is "+actual);
            ;
        }
    }
}
