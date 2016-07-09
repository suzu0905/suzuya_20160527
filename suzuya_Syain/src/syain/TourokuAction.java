package syain;

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



	public String execute() throws Exception{
		T_syainDAO t_syaindao = new T_syainDAO();
		ListUser user = new ListUser();
		user = t_syaindao.sayinTouroku(this.getName(),this.getGender(),this.getBirthday());
		this.setSyain_id(user.getSyain_id());
		this.setName(user.getName());
		this.setGender(user.getGender());
		this.setBirthday(user.getBirthday());
		this.setGe(user.getGe());

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
