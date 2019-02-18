import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeSuiteDemo {
    @BeforeSuite
    public void befoesuite(){
        System.out.println("suite init-------------");
    }

    @AfterSuite
    public void aftersuite(){
        System.out.println("suite close--------------");
    }
    @Test
    public void test1(){
        System.out.println("i belong to suite demo test1");
    }

    @Test
    public void test2(){
        System.out.println("i belong to suite demo test2");
    }
}
