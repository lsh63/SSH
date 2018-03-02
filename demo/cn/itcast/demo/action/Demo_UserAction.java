package cn.itcast.demo.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionContext;

import cn.itcast.demo.model.Demo_User;
import cn.itcast.demo.service.Demo_UserService;

public class Demo_UserAction {
	
	@Resource
	Demo_UserService demo_UserService;
	
	private Long id;
	private String userName;
	private String loginName;
	private String password;
	private String photoNum;
	
	List<Demo_User> demo_UserList = new ArrayList<Demo_User>();

	/*列表*/
	public String list(){
		demo_UserList = demo_UserService.findAll();
		ActionContext.getContext().put("demo_UserList", demo_UserList);
		return "list";
	}
	
	Demo_User demo_User = new Demo_User();
	
	public String add(){	
		demo_User.setUserName(userName);
		demo_User.setLoginName(loginName);
		demo_User.setPassword(password);
		demo_User.setPhotoNum(photoNum);
		demo_UserService.save(demo_User);
		return "add";
	}
	
	public String delete(){	
		demo_UserService.delete(demo_User.getId());
		return "delete";
	}

	//getter and setter methods

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoNum() {
		return photoNum;
	}

	public void setPhotoNum(String photoNum) {
		this.photoNum = photoNum;
	}

}
