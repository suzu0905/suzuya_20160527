package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 *
 * 一覧画面から検索ボタン押下時実行
 *
 */
public class ListAction extends ActionSupport implements ModelDriven<ListUser>{
	Connection conn = null;
	PreparedStatement pStmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/syain";
	String user = "root";
	String password = "kenji0905";

	private String name;
	private ListUser listuser;
	private ArrayList<ListUser> list = new ArrayList<>();

	public String execute() throws Exception{
		try {
			//SQL文作成(検索)
			String SELECT = "SELECT syain_id, name, seibetsu, birthday FROM t_syain WHERE name LIKE '%"
					+ this.getName() +"%';";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			//DB接続-SQL文を実行
			rs = pStmt.executeQuery();

			//検索条件に合ったレコードを繰り返し取得しlistに追加
			while(rs.next()){
				listuser= new ListUser();
				listuser.setSyain_id(rs.getString("syain_id"));
				listuser.setName(rs.getString("name"));
				listuser.setGender(rs.getString("seibetsu"));
				listuser.setBirthday(rs.getString("birthday"));
				list.add(listuser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally{
			//db 切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return "success";
	}
	@Override
	public ListUser getModel() {
		return listuser;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public ArrayList<ListUser> getList() {
		return list;
	}
	public void setList(ArrayList<ListUser> list) {
		this.list = list;
	}
}
