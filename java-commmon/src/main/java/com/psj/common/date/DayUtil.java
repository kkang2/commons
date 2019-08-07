package com.psj.common.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DayUtil {
	public enum DateType {
        BEFORE, AFTER
    }
	
	/*
	 * 현재 날짜 얻어오기
	 * format : yyyy-MM-dd HH:mm:ss
	 **/
	public static String getCurDate(String format) {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
	}
	
	/*
	 * 타겟 날짜 기준으로 앞/뒤 날짜 리스트 가져옴
	 **/
	public static List<String> getBeforeAndAfterDateList(DateType dateType, LocalDate targetDate, int dayCount, String format) {
		List<String> dateList = new ArrayList<>();
		
		//dateList.add(targetDate.format(DateTimeFormatter.ofPattern(format)));
		
		for (int i = 0; i < dayCount; i++) {
			if(dateType.equals(DateType.BEFORE)) {
				dateList.add(targetDate.minusDays(i).format(DateTimeFormatter.ofPattern(format)));
			} else if(dateType.equals(DateType.AFTER)) {
				dateList.add(targetDate.plusDays(i).format(DateTimeFormatter.ofPattern(format)));
			}
		}
		
		return dateList;
	}
	
	public static void main(String args[]) {
		System.out.println(getCurDate("yyyy-MM-dd"));
		System.out.println(getBeforeAndAfterDateList(DateType.BEFORE, LocalDate.now(), 3, "yyyyMMdd"));
		System.out.println(getBeforeAndAfterDateList(DateType.AFTER, LocalDate.now(), 3, "yyyyMMdd"));
	}
}
