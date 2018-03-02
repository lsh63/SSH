package cn.itcast.demo.dao;

import org.springframework.stereotype.Repository;

import cn.itcast.demo.model.Demo_Filter;

public interface Demo_FilterDao {
	
	/*增*/
	public void save(Demo_Filter filter);
	/*删*/
	public void delete(Long id);
	/*改*/
	public void updata(Demo_Filter filter);
	/*查*/
	public void getbyID(Long id);

}
