package syain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

public class TourokuValidation extends ActionSupport{
	private String name;
	private String gender;
	private String birthday;

	public void validate() {
		int sIndex = birthday.indexOf("-");
		int lIndex = birthday.lastIndexOf("-");
		Pattern p = Pattern.compile("[^0-9¥-]");
		Matcher m = p.matcher(getBirthday());

		if ( name == null || name.length() == 0 ) {
            addActionError("名前を入力してください");
        }
		if ( gender==null ) {
            addActionError("性別を選択してください");
        }
		//誕生日が未入力、10文字で入力しているかチェック
		if ( birthday==null || birthday.length() != 10 ) {
            addActionError("YYYY-MM-DDの形式で入力してください");
        //"-"の位置が正常か、数字と"-"以外が入っていないかチェック
        }else if(sIndex != 4 || lIndex != 7 || m.find()){
        	addActionError("生年月日を正しく入力してください");
        }
	}
	public String execute() throws Exception {
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
}
