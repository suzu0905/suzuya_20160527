package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;

public class T_syainDAO extends ActionSupport {
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement pStmt = null;
	private String url = "jdbc:mysql://localhost:3306/syain";
	private String user = "root";
	private String password = "kenji0905";
	private String syain_id;
	private String name;
	private String seibetsu;
	private String birthday;
	int columnNum = 1;
	private ListUser listuser = new ListUser();
	private ArrayList<ListUser> list = new ArrayList<ListUser>();

	//新規社員登録
	public ListUser sayinTouroku(String name,String gender,String birthday){
		int year;
		PreparedStatement pStmt2 = null;
		int pStmt2_rs = 0;

		try{
			//最新のレコードを取得するSQL文
			String SELECT = "SELECT syain_id FROM t_syain ORDER BY syain_id desc limit 1;";
			//現在の西暦
			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);

			//DBに接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			rs = pStmt.executeQuery();

			if(rs.next()){//レコードあり
				//変数syain_idにテーブルのsyain_idを取得 (yyyy-nnn,西暦-ナンバー)
				this.syain_id = rs.getString("syain_id");
				//[0]にyyyy,[1]にnnn
				String[] s_id = this.syain_id.split("-", 0);
				//nnnをint型で取得
				int id = Integer.parseInt(s_id[1]);
				//IDのnnnに＋1
				++id;
				//yyyy-nnnの形式に変換
				this.syain_id = year + "-" + String.format("%03d", id);
			}else{//レコード無し
				//最初の一人目は取得するIDが無い為、'yyyy-001'で作成
				this.syain_id = year + "-" + String.format("%03d", 1);
			}
			String INSERT = "INSERT INTO t_syain(syain_id,name,seibetsu,birthday) VALUES(?,?,?,?);";
			pStmt2 = conn.prepareStatement(INSERT);
			pStmt2.setString(columnNum++, this.syain_id);
			pStmt2.setString(columnNum++, name);
			pStmt2.setString(columnNum++, gender);
			pStmt2.setString(columnNum, birthday);
			pStmt2_rs = pStmt2.executeUpdate();
			if (pStmt2_rs != 0) {
				pStmt2.close();
				System.out.println("INSERT文をクローズしました。");
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
		ListUser user = this.syainSelect(this.syain_id);
		return user;
	}

	//検索
	public ArrayList<ListUser> sayinSearch(String name){
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try{
			String searchName = '%' + name + '%' ;

			String SELECT = "SELECT syain_id, name, seibetsu, birthday FROM t_syain WHERE name LIKE  ?  ;";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			pStmt.setString(columnNum, searchName);
			rs = pStmt.executeQuery();
			while(rs.next()){
				listuser = new ListUser();
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
		}finally{
			//db 切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}

	//社員情報更新
	public ListUser syainUpdate(String name, String seibetsu, String birthday,String syain_id){
		try{
			PreparedStatement pStmt = null;
			String UPDATE = "UPDATE t_syain SET name = ? , seibetsu = ? , birthday = ? WHERE SYAIN_ID = ? ;";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);

			pStmt = conn.prepareStatement(UPDATE);
			pStmt.setString(columnNum++, name);
			pStmt.setString(columnNum++, seibetsu);
			pStmt.setString(columnNum++, birthday);
			pStmt.setString(columnNum, syain_id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			//db 切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		ListUser user = this.syainSelect(syain_id);
		return user;
	}


	//社員情報削除
	public void syianDelete(String syain_id){
		try{
			PreparedStatement pStmt = null;
			int pStmt_rs = 0;
			String DELETE = "DELETE FROM t_syain WHERE syain_id = ? ;";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(DELETE);
			pStmt.setString(columnNum, syain_id);
			pStmt_rs = pStmt.executeUpdate();
			if(pStmt_rs != 0){
				System.out.println("ok");
			}else{
				System.out.println("ng");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			//db 切断
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public ListUser syainSelect(String syain_id){
		try{
			PreparedStatement pStmt = null;
			ResultSet rs = null;
			columnNum = 1;

			String SELECT = "SELECT SYAIN_ID, NAME, SEIBETSU, BIRTHDAY FROM T_SYAIN WHERE SYAIN_ID = ? ;";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
			pStmt = conn.prepareStatement(SELECT);
			pStmt.setString(columnNum, syain_id);
			rs = pStmt.executeQuery();
			while(rs.next()) {
				this.syain_id = rs.getString("SYAIN_ID");
				this.name = rs.getString("NAME");
				this.seibetsu = rs.getString("SEIBETSU");
				this.birthday = rs.getString("BIRTHDAY");
			}
			ListUser user = new ListUser(this.syain_id,this.name,this.seibetsu,this.birthday);
			listuser = user;
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
		return listuser;
	}
}
