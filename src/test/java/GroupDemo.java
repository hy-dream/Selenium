import org.testng.annotations.Test;

public class GroupDemo {

    @Test(groups="smoke")
    public void test1(){
        System.out.println("i am smoke test1");
    }

    @Test(groups="smoke")
    public void test3(){
        System.out.println("i am smoke test3");
    }

    @Test(groups="return")
    public void test2(){
        System.out.println("i am return test1");
    }
}
