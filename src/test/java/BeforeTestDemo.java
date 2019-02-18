import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BeforeTestDemo {
    @BeforeTest
    public static void beforetest(){
        System.out.println("before test1----");
    }

    @AfterTest
    public void aftertest(){
        System.out.println("after test1-----");
    }

    @Test
    public void test1(){
        System.out.println("i am test1");
    }
    @Test
    public void test2(){
        System.out.println("i am test2");
    }

}
