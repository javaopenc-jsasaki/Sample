
public class Program {

	public static void main(String[] args) {
		User firstUser = new User("123456", "佐々木");
		firstUser.setPassword("admin12345");
		
		System.out.println("ユーザ名：" + firstUser.getName());
		
		if (firstUser.login("admin12333")) {
			System.out.println("ログイン１回目成功");
		}
		else {
			System.out.println("ログイン１回目失敗");
		}
		
		if (firstUser.login("admin12345")) {
			System.out.println("ログイン２回目成功");
		}
		else {
			System.out.println("ログイン２回目失敗");
		}
	}
}
