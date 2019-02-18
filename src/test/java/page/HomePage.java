package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends NavBarPage{

    @FindBy(css = ".content img")
    WebElement banner;

    public HomePage(WebDriver  driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public EventPage clickBanner(){
        banner.click();
        return new EventPage(driver);
    }
}
