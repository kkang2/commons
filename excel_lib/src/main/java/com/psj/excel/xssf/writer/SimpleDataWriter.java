package com.psj.excel.xssf.writer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.psj.excel.common.Constans;

public class SimpleDataWriter {
	public static String filePath = Constans.CREATE_FOLDER;
    public static String fileNm = "poi_making_file_test.xlsx";
    
	public static void main(String[] args) {
		Workbook wb = new XSSFWorkbook();
		
		Sheet sheet = wb.createSheet("sample_sheet");
		
		// Sheet를 채우기 위한 데이터들을 Map에 저장
        Map<String, Object[]> data = new TreeMap<>();
        
        data.put("1", new Object[]{"ID", "NAME", "PHONE_NUMBER"});
        data.put("2", new Object[]{"1", "cookie", "010-1111-1111"});
        data.put("3", new Object[]{"2", "sickBBang", "010-2222-2222"});
        data.put("4", new Object[]{"3", "workingAnt", "010-3333-3333"});
        data.put("5", new Object[]{"4", "wow", "010-4444-4444"});
        
     // data에서 keySet를 가져온다. 이 Set 값들을 조회하면서 데이터들을 sheet에 입력한다.
        Set<String> keyset = data.keySet();
        int rownum = 0;

        // 알아야할 점, TreeMap을 통해 생성된 keySet는 for를 조회시, 키값이 오름차순으로 조회된다.
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String)obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer)obj);
                }
            }
        }

        try(FileOutputStream out = new FileOutputStream(new File(filePath, fileNm))) {
            wb.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}