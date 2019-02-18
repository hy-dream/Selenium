import org.testng.annotations.Test;

public class EnableDemo {

    @Test(enabled = false)
    public void test1(){
        System.out.println("i am test1");
    }

    @Test
    public void test3(){
        System.out.println("i am test3");
    }

}
