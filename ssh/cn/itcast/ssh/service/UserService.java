package cn.itcast.ssh.service;

import java.util.List;

import cn.itcast.ssh.entity.SshUser;

public interface UserService {
	
	/*保存实体数据*/
	void save(SshUser user);
	
	/*删除实体数据*/
	void delete(SshUser user);
	
	/*更新实体数据*/
	void update(SshUser user);
	
	/*获取全部实体数据*/
	List<SshUser> get();
	
	/*根据ids获取实体数据集合*/
	List<SshUser> getByIds(Long[] ids);
	
	/*根据id获取实体数据*/
	SshUser getById(Long id);
	
	/*根据id删除实体数据*/
	void deleteById(Long id);

}
