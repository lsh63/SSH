package cn.itcast.demo.model;

@SuppressWarnings("serial")
public class Demo_User implements java.io.Serializable {
	
	private Long id;
	private String userName;
	private String loginName;
	private String password;
	private String photoNum;
	
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
