package cn.itcast.ssh.test;

import org.junit.Test;

import cn.itcast.ssh.dao.UserDao;
import cn.itcast.ssh.dao.impl.UserDaoImpl;

public class BaseDaoImplTest {
	
	@SuppressWarnings("unused")
	@Test
	public void UserDaoImplTest(){
		UserDao userDao = new UserDaoImpl();
	}

}
