import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnDemo {

    @Test
    public void test1(){
        System.out.println("i am test1");
        Assert.assertEquals(1,2);
    }

    @Test(dependsOnMethods = "test1")
    public void test3(){
        System.out.println("i depends on test1");
    }

}
