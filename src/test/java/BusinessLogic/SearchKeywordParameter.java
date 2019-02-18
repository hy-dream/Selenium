package BusinessLogic;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class SearchKeywordParameter {
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

    public Iterator<Object[]> readCSV(String filePath) throws Exception {
        List<Object[]> dataArray=new ArrayList<Object[]>();
        Reader in=new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for(CSVRecord record:records){
            List<Object> rowList=new ArrayList<Object>();
            Iterator i=record.iterator();
            while(i.hasNext()){
                rowList.add(i.next());
            }
            Object[] rowArray=rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();

    }
    @AfterMethod
    public void after(){
        webDriver.quit();
    }
}
