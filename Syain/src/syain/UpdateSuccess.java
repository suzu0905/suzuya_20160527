package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * 更新画面の更新ボタン押下時実行
 *
 */
public class UpdateSuccess extends ActionSupport {

	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/syain";
	String user = "root";
	String password = "kenji0905";

	private String syain_id;
	private String name;
	private String gender;
	private String birthday;
	private String ge;

	public String execute() throws Exception{
		try{
			//SQL文作成(更新)
			String UPDATE = "UPDATE t_syain SET syain_id = '" + getSyain_id() + "', name = '"
					+ getName() + "', seibetsu = '" + getGender() + "', birthday = '" +getBirthday() + "'"
					+ "WHERE syain_id = '" + getSyain_id() + "';";
			conn = DriverManager.getConnection(url,user,password);
			Statement statement = (Statement) conn.createStatement();
			statement.executeUpdate(UPDATE);
			if(getGender().equals("1")){
				setGe("男");
			}
			if(getGender().equals("2")){
				setGe("女");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
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
	public void setGe(String ge){
		this.ge = ge;
	}
	public String getGe(){
		return ge;
	}
}
