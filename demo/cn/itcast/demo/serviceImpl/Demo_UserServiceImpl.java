package cn.itcast.demo.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import cn.itcast.demo.dao.Demo_UserDao;
import cn.itcast.demo.model.Demo_User;
import cn.itcast.demo.service.Demo_UserService;

@Service
public class Demo_UserServiceImpl implements Demo_UserService {

	@Resource
	Demo_UserDao demo_UserDao;

	@Override
	public void save(Demo_User user) {
		demo_UserDao.save(user);
	}

	@Override
	public void delete(Long id) {
		demo_UserDao.delete(id);
	}

	@Override
	public void updata(Demo_User user) {
		demo_UserDao.updata(user); 
	}

	@Override
	public void getbyID(Long id) {
		demo_UserDao.getbyID(id);
	}

	@Override
	public List<Demo_User> findAll() {
		return demo_UserDao.findAll();
	}

}
