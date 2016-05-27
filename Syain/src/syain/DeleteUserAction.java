package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * 一覧表示から削除ボタン押下時実行
 *
 */
public class DeleteUserAction extends ActionSupport{
	private String syain_id;

	PreparedStatement pStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/syain";
	String user = "root";
	String password = "kenji0905";

	public String execute() throws Exception{
		try {
			String DELETE = "DELETE FROM t_syain WHERE syain_id = '" +getSyain_id()+ "';";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			Statement statement = (Statement) conn.createStatement();
			statement.executeUpdate(DELETE);
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
}
