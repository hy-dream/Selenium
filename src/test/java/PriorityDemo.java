import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class PriorityDemo {

    @Test(priority = 1)
    public void test1(){
        System.out.println("i am test1");
        Reporter.log("我是步骤1",true);
    }

    @Test(priority = 0)
    public void test3(){
        System.out.println("i am test3");
    }

}
