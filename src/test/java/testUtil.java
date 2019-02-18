import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.FileUtil;
import util.FileUtil2;

import java.util.Iterator;

public class testUtil {
    @DataProvider
    public Iterator<Object[]> getDatas() throws Exception{
        String path=this.getClass().getResource("/data.csv").getPath();
        return FileUtil.readCSV(path);

    }

    @Test(dataProvider = "getDatas")
    public void test1(String a,String b) throws Exception {
        System.out.println(a);
        System.out.println(b);
    }

    @DataProvider
    public Iterator<Object[]> readData() throws Exception{
        String path=this.getClass().getResource("/data.csv").getPath();
        return FileUtil2.readCSVEasy(path);
    }

    @Test(dataProvider = "readData")
    public void test2(String a) throws Exception {
        System.out.println(a);
       // System.out.println(b);
    }

    @DataProvider
    public Object[][] readExcel() throws Exception{
        String path=this.getClass().getResource("/data1.xlsx").getPath();
        return FileUtil.readEXCEL(path);
    }

    @Test(dataProvider = "readExcel")
    public void test3(String a,String b,String c) throws Exception {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

}
