package syain;

import com.opensymphony.xwork2.ActionSupport;
/**
 *
 * 一覧表示から削除ボタン押下時実行
 *
 */
public class DeleteUserAction extends ActionSupport{
	private String syain_id;

	public String execute() throws Exception{
		T_syainDAO tSyainDAO = new T_syainDAO();
		tSyainDAO.syianDelete(getSyain_id());
		return "success";
	}
	public void setSyain_id(String syain_id){
		this.syain_id = syain_id;
	}
	public String getSyain_id(){
		return syain_id;
	}
}
