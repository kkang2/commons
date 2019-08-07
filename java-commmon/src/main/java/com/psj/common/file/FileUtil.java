package com.psj.common.file;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	/*
	 * 디렉터리 안의 파일리스트 리턴
	 **/
	public static List<String> getDirFileList(String dirPath) {
		List<String> filepathList = new ArrayList<String>();
		
		// Files.newDirectoryStream(path, "*.{png,jpg,bmp}" 처럼 패턴으로 파일을 제한할수 있음
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(Paths.get(dirPath))) {
            for (Path file : ds) {
            	if(file.toFile().isFile()) {
            		filepathList.add(file.getFileName().toString());
            	}
            }
        } catch (IOException e) {
            System.err.println(e);
        }
		
		return filepathList;
	}
	
	public static void main(String[] args) {
		System.out.println(getDirFileList(new java.io.File("").getAbsolutePath() + "\\src\\main\\resources\\data\\cvs\\"));
		//System.out.println(getDirFileList("C:\\Users\\ff\\eclipse_2019_workspace\\beam\\src\\main\\resources\\data\\cvs\\"));
		//System.out.println(new java.io.File("").getAbsolutePath());
		//System.out.println(FileUtil.class.getClassLoader().getResource("").getPath());
	}
}
