package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtil2 {
    public static Iterator<Object[]> readCSVEasy(String filePath) throws Exception {
        List<Object[]> list=new ArrayList<Object[]>();
        FileReader is=new FileReader(new File(filePath));
        BufferedReader br=new BufferedReader(is);
        while (br.ready()){
            list.add(br.readLine().split(";"));
        }
        return list.iterator();
    }
}
