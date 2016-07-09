package syain;

public class chkLoadJdbc {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		String msg = "";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			msg = "ロード成功";
		}catch(ClassNotFoundException e){
			msg = "失敗";
		}
		System.out.println(msg);

	}

}
