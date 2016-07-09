package syain;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
/**
 *
 * 一覧画面から検索ボタン押下時実行
 *
 */
public class ListAction extends ActionSupport implements ModelDriven<ListUser>{
	private String name;
	private ListUser listuser;
	private ArrayList<ListUser> syainList = new ArrayList<ListUser>();

	public String execute() throws Exception{
		T_syainDAO tSyainDAO = new T_syainDAO();
		ArrayList<ListUser> list = tSyainDAO.sayinSearch(this.getName());
		for(ListUser syainData : list){
			syainList.add(syainData);
		}
		return "success";
	}
	@Override
	public ListUser getModel() {
		return listuser;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public ArrayList<ListUser> getList() {
		return syainList;
	}
	public void setList(ArrayList<ListUser> list) {
		this.syainList = list;
	}
}
