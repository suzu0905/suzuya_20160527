package syain;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * ログイン画面のログインボタン押下時実行
 *
 */
public class LoginAction extends ActionSupport implements SessionAware{
	private String loginID;
	private String s_loginID;
	private String loginPass;
	private String s_loginPass;
	private Map<String, Object> session;

	//DBの情報と照合
	public String execute() throws Exception{
		M_userDAO mUserDAO = new M_userDAO();
		M_User mUser = new M_User();

		//入力されたIDが登録れているか確認
		if(mUserDAO.CheckUser(getId())){
			mUser = mUserDAO.userSelect(getId());
			this.s_loginID = mUser.getLogin_id();
			this.s_loginPass = mUser.getPassword();
		}else{
			addActionError("認証に失敗しました。");
			return "error";
		}
		//登録されたパスワードと入力されたパスワードをチェック
		if (s_loginID.equals(getId()) && s_loginPass.equals(getPass()) ) {
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
		return loginPass;
	}
	public void setPass(String pass){
		this.loginPass = pass;
	}
	public String getId(){
		return loginID;
	}
	public void setId(String id){
		this.loginID = id;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
