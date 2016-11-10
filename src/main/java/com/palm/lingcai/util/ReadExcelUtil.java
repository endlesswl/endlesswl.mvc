package com.palm.lingcai.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by nzhmac on 16/11/10.
 */
public class ReadExcelUtil {
    /**
     * read the Excel file
     * @param path the path of the Excel file
     * @param param excel param Map. example {0:name, 1:tel, 2:age}
     * @return
     * @throws java.io.IOException
     */
    public List<Map<String, Object>> readExcel(String path, Map<Integer, String> param) throws IOException {
        if (path == null || Common.EMPTY.equals(path)) {
            return null;
        } else {
            String postfix = Util.getPostfix(path);
            if (!Common.EMPTY.equals(postfix)) {
                if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
                    return readXls(path, param);
                } else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
                    return readXlsx(path, param);
                }
            } else {
                System.out.println(path + Common.NOT_EXCEL_FILE);
            }
        }
        return null;
    }

    /**
     * Read the Excel 2010
     * @param path the path of the excel file
     * @param param excel param Map. example {0:name, 1:tel, 2:age}
     * @return
     * @throws java.io.IOException
     */
    public List<Map<String, Object>> readXlsx(String path, Map<Integer, String> param) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        Map<String, Object> student = null;
        List<Map<String, Object>> list = Lists.newArrayList();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    student = new HashMap<String, Object>();
                    Set<Integer> set = param.keySet();
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext()){
                        Integer col = it.next();
                        student.put(param.get(col), xssfRow.getCell(col));
                    }
                    list.add(student);
                }
            }
        }
        return list;
    }

    /**
     * Read the Excel 2003-2007
     * @param path the path of the Excel
     * @param param excel param Map. example {0:name, 1:tel, 2:age}
     * @return
     * @throws java.io.IOException
     */
    public List<Map<String, Object>> readXls(String path, Map<Integer, String> param) throws IOException {
        System.out.println(Common.PROCESSING + path);
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Map<String, Object> student = null;
        List<Map<String, Object>> list = Lists.newArrayList();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    student = new HashMap<String, Object>();
                    Set<Integer> set = param.keySet();
                    Iterator<Integer> it = set.iterator();
                    while (it.hasNext()){
                        Integer col = it.next();
                        student.put(param.get(col), hssfRow.getCell(col));
                    }
                    list.add(student);
                }
            }
        }
        return list;
    }

    @SuppressWarnings("static-access")
    private String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    public static void main(String[] args) {
        List<Map<String, Object>> list = null;
        Map<Integer, String> param = Maps.newHashMap();
        param.put(0, "province");
        param.put(1, "city");
        param.put(2, "dealer_name");
        param.put(4, "client_city");
        param.put(5, "address");
        param.put(6, "tel");
        try {
            list = new ReadExcelUtil().readExcel("/Users/nzhmac/奥铃经销商.xls", param);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list != null) {
            for (Map student : list) {
                Set<String> set = student.keySet();
                Iterator<String> it = set.iterator();
                while (it.hasNext()){
                    String col = it.next();
                    System.out.print(col + " : " + student.get(col) + " \t");
                }
                System.out.println();
            }
        }

    }
}

/**
 * @author nzh
 * @created
 */
class Common {

    public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";

    public static final String EMPTY = "";
    public static final String POINT = ".";
    public static final String NOT_EXCEL_FILE = " : Not the Excel file!";
    public static final String PROCESSING = "Processing...";

}

class Util {

    /**
     * get postfix of the path
     * @param path
     * @return
     */
    public static String getPostfix(String path) {
        if (path == null || Common.EMPTY.equals(path.trim())) {
            return Common.EMPTY;
        }
        if (path.contains(Common.POINT)) {
            return path.substring(path.lastIndexOf(Common.POINT) + 1, path.length());
        }
        return Common.EMPTY;
    }
}