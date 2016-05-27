package syain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * ログイン画面のログインボタン押下時実行
 *
 */
public class LoginAction extends ActionSupport implements SessionAware{
	Connection conn = null;
	PreparedStatement pStmt = null;
	ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/syain";
	String user = "root";
	String password = "kenji0905";
	private String id;
	private String pass;
	private String loginID;
	private String loginPass;
	private Map<String, Object> session;

	//DBの情報と照合
	public String execute() throws Exception{
		try {
			String SELECT = "SELECT login_id, password FROM m_user WHERE login_id = '"
								 + this.getId() + "';";
			//DB接続-SQL文を実行
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,user,password);
			pStmt = conn.prepareStatement(SELECT);
			rs = pStmt.executeQuery();

			//カラムの取得
			//DB内M_USERに登録されているユーザか
			if(rs.next()){
				//登録済
				this.loginID = rs.getString("login_id");
				this.loginPass = rs.getString("password");
			}else{
				//登録されてない
				addActionError("認証に失敗しました。");
				return "error";
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
		//登録されたパスワードと入力されたパスワードをチェック
		if (loginID.equals(getId()) && loginPass.equals(getPass()) ) {
			//チェックOK
			session.put("nameKey",getId());
			return "success";
		}else{
			//チェックNG
			addActionError("認証に失敗しました。");
			return "error";
		}

	}
	public String getPass(){
		return pass;
	}
	public void setPass(String pass){
		this.pass = pass;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
