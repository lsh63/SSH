package cn.itcast.ssh.base;

import java.util.List;

public interface BaseDao<T> {
	
	/*保存实体数据*/
	void save(T entity);
	
	/*删除实体数据*/
	void delete(T entity);
	
	/*更新实体数据*/
	void update(T entity);
	
	/*获取全部实体数据*/
	List<T> get();
	
	/*根据ids获取实体数据集合*/
	List<T> getByIds(Long[] ids);
	
	/*根据id获取实体数据*/
	T getById(Long id);
	
	/*根据id删除实体数据*/
	void deleteById(Long id);

}
