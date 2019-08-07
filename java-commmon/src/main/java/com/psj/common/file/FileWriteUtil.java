package com.psj.common.file;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class FileWriteUtil {
	public static void writeStringToFile(String filePath, String contents) {
		try (BufferedWriter fw = new BufferedWriter(new FileWriter(filePath, true))) {
			fw.write(contents);
			fw.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 바이너리 데이터 파일에 쓰는 기능 만들기 
	 **/
	
	public static void main(String[] args) {

	}
}
