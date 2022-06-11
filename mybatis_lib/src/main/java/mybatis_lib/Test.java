package mybatis_lib;

public class Test {

	public static void main(String[] args) {
		String str = "SELECT SHOP_NO, SHOP_NAME, SHOP_LOCATION, SHOP_STATUS FROM SHOP WHERE SHOP_NO = ? AND SHOP_STATUS = ?";
		
		System.out.println(str.split("?")[0]);
		System.out.println(str.split("?")[1]);
	}
}