package syain;

//1件のユーザーのレコードを格納するクラス
public class ListUser {
		private String name;
		private String gender;
		private String birthday;
		private String syain_id;
		private String ge;

		public ListUser() { }

		public ListUser(String syain_id, String name, String gender, String birthday) {
			setSyain_id(syain_id);
			setName(name);
			setGender(gender);
			setBirthday(birthday);
		}
		public void setName(String name){
			this.name = name;
		}
		public String getName(){
			return name;
		}
		public void setGender(String gender){
			this.gender = gender;
			//genderの値が1:男、2:女
			if(getGender().equals("1")){
				setGe("男");
			}
			if(getGender().equals("2")){
				setGe("女");
			}
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
