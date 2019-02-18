import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.util.concurrent.TimeUnit;

public class CssDemo {
    public static void main(String[] args){
        System.getProperty("user.dir");
        String path="\\src\\main\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+path);
        WebDriver driver=new ChromeDriver();
        driver.get("https://testerhome.com");
        //找登录按钮.navbar-right a[href*=sign_in] 查找class等于navbar-right的子孙节点a,并且a的属性href包含sign_in
        driver.findElement(By.cssSelector(".navbar-right a[href*=sign_in]")).click();

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebDriverWait webDriverWait=new WebDriverWait(driver,10);
        //找输入email编辑框 查找class等于input-lg并且type属性以email开头的元素
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".input-lg[type^=email]")));
        driver.findElement(By.cssSelector(".input-lg[type^=email]")).sendKeys("965557453@qq.com");

        driver.findElement(By.cssSelector(".input-lg[type^=pass]")).sendKeys("222222222");
        //查找input节点，其class等于btn-block
        driver.findElement(By.cssSelector("input.btn-block")).click();

        driver.quit();
        System.out.println("pass");
    }
}
