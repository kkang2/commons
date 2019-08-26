package com.psj.common.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
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
	 * 바이너리 데이터 destFile 에 쓰기
	 **/
	public static void writeBytesToFile(byte[] data, File destFile) {
		try (FileOutputStream fileOutputStream = new FileOutputStream(destFile)) {
			fileOutputStream.write(data);
			fileOutputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/* ex) file object convert to bytes
			Path fileLocation = Paths.get("C:\\log\\dt=20190724\\tm=00\\1564130405213");
			byte[] data = Files.readAllBytes(fileLocation); 
		*/
	}
	
	public static void main(String[] args) {

	}
}
