package cn.itcast.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import cn.itcast.ssh.dao.UserDao;
import cn.itcast.ssh.entity.SshUser;
import cn.itcast.ssh.service.UserService;

public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao; 

	@Override
	public void save(SshUser user) {
		userDao.save(user);
	}

	@Override
	public void delete(SshUser user) {
		userDao.delete(user);
	}

	@Override
	public void update(SshUser user) {
		userDao.update(user);
	}

	@Override
	public List<SshUser> get() {
		List<SshUser> getList = userDao.get();
		return getList;
	}

	@Override
	public List<SshUser> getByIds(Long[] ids) {
		List<SshUser> getListByIds = userDao.getByIds(ids);
		return getListByIds;
	}

	@SuppressWarnings("unchecked")
	@Override
	public SshUser getById(Long id) {
		List<SshUser> getListById = (List<SshUser>) userDao.getById(id);
		return (SshUser) getListById;
	}

	@Override
	public void deleteById(Long id) {
		userDao.deleteById(id);
	}

}
