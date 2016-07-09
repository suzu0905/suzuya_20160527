package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class M_userDAO {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pStmt = null;
	private String url = "jdbc:mysql://localhost:3306/syain";
	private String user = "root";
	private String password = "kenji0905";
	private int columnNum = 1;

	private String loginID;
	private String l_Pass;
	M_User mUser;

	public M_User userSelect(String searchID) {
		try{
			String SELECT = "SELECT login_id, password FROM m_user WHERE login_id = ? ;";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			pStmt.setString(columnNum, searchID);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				this.loginID = rs.getString("LOGIN_ID");
				this.l_Pass = rs.getString("PASSWORD");
			}
			mUser = new M_User(this.loginID,this.l_Pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//db 切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return mUser;
	}
	/**
	 * ログインIDがDB内M_USERテーブルに登録されているか確認するメソッド
	 * 登録されている:true
	 * 未登録	  :false
	 */
	public boolean CheckUser(String id){
		boolean flg = false;
		try{
			String SELECT = "SELECT login_id FROM m_user WHERE login_id = ? ;";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			pStmt.setString(columnNum, id);
			rs = pStmt.executeQuery();
			if(rs.next()) {
				flg = true;
			}else{
				flg = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//db 切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return flg;
	}
}
