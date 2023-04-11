package mybatis_lib;

import java.nio.file.Paths;

public class Test {

	public static void main(String[] args) {
		String str1 = "ddd:rrr";
		System.out.println(str1.substring(0, str1.indexOf(":")));
		System.out.println(System.getProperty("user.dir"));
		System.out.println(Paths.get("").toAbsolutePath().toString());
		System.out.println(Test.class.getClassLoader().getResource("").getPath());
		
		String str = "SELECT SHOP_NO, SHOP_NAME, SHOP_LOCATION, SHOP_STATUS FROM SHOP WHERE SHOP_NO = ? AND SHOP_STATUS = ?";
		
		System.out.println(str.split("?")[0]);
		System.out.println(str.split("?")[1]);
	}
}