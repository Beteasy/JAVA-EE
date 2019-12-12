package cn.edu.cuit.fhzheng.daotest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import cn.edu.cuit.fhzheng.dao.UserDao;
import cn.edu.cuit.fhzheng.pojo.User;

public class UserDaoTest {
	
	// 启用日 志
	private static final Logger log = Logger.getLogger(UserDaoTest.class.getName());
	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void getUserByIdTest() {
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(12);
		log.info(user.toString());
		System.out.println(user.toString());		
	}

	@Test
	public void getAllUsersTest() {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getAllUsers();
		for (User user2 : userList) {
			log.info(user2.toString());
		}
	}
	
	@Test
	public void getUserByNameTest() {
		UserDao userDao = new UserDao();
		List<User> userList = userDao.getUserByName("帅哥");
		for (User user : userList) {
			log.info(user.toString());
		}
	}

}
