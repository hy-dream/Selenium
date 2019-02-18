import org.testng.annotations.*;

public class BeforeClassDemo {
    @BeforeTest
    public  static void beforetest(){
        System.out.println("Before test2_________");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("After test2_________");
    }
    @BeforeClass
    public static void before(){
        System.out.println("class init---------");
    }

    @AfterClass
    public void after(){
        System.out.println("class close--------");
    }

    @Test
    public void test1(){
        System.out.println("test1----");
    }

    @Test
    public void test2(){
        System.out.println("test2------");
    }
}
