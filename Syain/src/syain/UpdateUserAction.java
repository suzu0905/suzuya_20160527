package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * 一覧画面の編集ボタン押下時実行
 *
 */
public class UpdateUserAction extends ActionSupport{
	Connection conn = null;
	PreparedStatement pStmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/syain";
	String user = "root";
	String password = "kenji0905";

	private String syain_id;
	private String name;
	private String gender;
	private String birthday;

	public String Up() throws Exception{
		try {
			//SQL文作成(検索)
			String SELECT = "SELECT syain_id, name, seibetsu, birthday FROM t_syain "
					+ "WHERE syain_id ='" + this.getSyain_id() + "';";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			rs = pStmt.executeQuery();

			while(rs.next()){
				setSyain_id(rs.getString("syain_id"));
				setName(rs.getString("name"));
				setGender(rs.getString("seibetsu"));
				setBirthday(rs.getString("birthday"));
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

	public void setSyain_id(String syain_id){
		this.syain_id = syain_id;
	}
	public String getSyain_id(){
		return syain_id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setGender(String gender){
		this.gender = gender;
	}
	public String getGender(){
		return gender;
	}
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}
	public String getBirthday(){
		return birthday;
	}
}
