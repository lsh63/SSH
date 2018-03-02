package cn.itcast.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.itcast.demo.model.Demo_User;
@Repository
public interface Demo_UserDao {
	
	/*增*/
	void save(Demo_User user);
	
	/*删*/
	void delete(Long id);
	
	/*改*/
	void updata(Demo_User user);
	
	/*查*/
	Demo_User getbyID(Long id);
	
	/*查找所有*/
	List<Demo_User> findAll();

}
