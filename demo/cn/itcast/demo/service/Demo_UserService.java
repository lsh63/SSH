package cn.itcast.demo.service;

import java.util.List;

import cn.itcast.demo.model.Demo_User;

public interface Demo_UserService {
	
	/*增*/
	public void save(Demo_User user);
	
	/*删*/
	public void delete(Long id);
	
	/*改*/
	public void updata(Demo_User user);
	
	/*查*/
	public void getbyID(Long id);
	
	/*查找所有*/
	public List<Demo_User> findAll();

}
