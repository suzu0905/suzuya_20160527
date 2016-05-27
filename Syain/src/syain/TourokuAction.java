package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mysql.jdbc.Statement;
import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * 登録画面の登録ボタン押下時実行
 *
 */
public class TourokuAction extends ActionSupport{
	private String name;
	private String gender;
	private String birthday;
	private String syain_id;
	private String ge;

	int year;
	PreparedStatement pStmt = null;
	Connection conn = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/syain";
	String user = "root";
	String password = "kenji0905";

	public String execute() throws Exception{
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
				syain_id = rs.getString("syain_id");
				//[0]にyyyy,[1]にnnn
				String[] s_id = syain_id.split("-", 0);
				//nnnをint型で取得
				int id = Integer.parseInt(s_id[1]);
				//IDのnnnに＋1
				++id;
				//yyyy-nnnの形式に変換
				syain_id = year + "-" + String.format("%03d", id);
			}else{//レコード無し
				//最初の一人目は取得するIDが無い為、'yyyy-001'で作成
				syain_id = year + "-" + String.format("%03d", 1);
			}
			String INSERT = "INSERT INTO t_syain(syain_id,name,seibetsu,birthday) VALUES("
					+"'"+ syain_id +"','"+this.getName() +"','"+ this.getGender() +"','"+ this.getBirthday() +"');";
			Statement statement = (Statement) conn.createStatement();
			statement.executeUpdate(INSERT);

			//結果表示の際"男"or"女"と表示させる
			if(getGender().equals("1")){
				setGe("男");
			}
			if(getGender().equals("2")){
				setGe("女");
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
		return "success";
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
	public void setSyain_id(String syain_id){
		this.syain_id = syain_id;
	}
	public String getSyain_id(){
		return syain_id;
	}
	public void setGe(String ge){
		this.ge = ge;
	}
	public String getGe(){
		return ge;
	}
}
