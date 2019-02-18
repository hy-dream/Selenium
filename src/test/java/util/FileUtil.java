package util;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtil {
    public static Iterator<Object[]> readCSV(String filePath) throws Exception {
        List<Object[]> dataArray=new ArrayList<Object[]>();
        Reader in=new FileReader(filePath);
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for(CSVRecord record:records){
            List<Object> rowList=new ArrayList<Object>();
            Iterator i=record.iterator();
            while(i.hasNext()){
                rowList.add(i.next());
            }
            //System.out.println(rowList);
            Object[] rowArray=rowList.toArray();
            dataArray.add(rowArray);
        }
        return dataArray.iterator();

    }

    public static Object[][] readEXCEL(String path) throws Exception{
        Workbook workbook;
        FileInputStream fileInputStream=new FileInputStream(path);
        workbook=new XSSFWorkbook(fileInputStream);
        Sheet sheet=workbook.getSheetAt(0);
        int rowInExcel=sheet.getPhysicalNumberOfRows();
        int columInExcel=sheet.getRow(0).getPhysicalNumberOfCells();
        String[][] data=new String[rowInExcel-1][columInExcel];
        for(int row=1;row<rowInExcel;row++){
            for(int col=0;col<columInExcel;col++){
                sheet.getRow(row).getCell(col).setCellType(Cell.CELL_TYPE_STRING);
                data[row-1][col]=sheet.getRow(row).getCell(col).getStringCellValue();
            }
        }
        return data;
    }
}
