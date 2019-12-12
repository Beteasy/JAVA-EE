package test;

import java.util.ArrayList;
import java.util.List;

import dao.UserDao;
import entity.User;
import service.UserService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		findByIdTest();
		findByNameTest();
	}
	
	public static void findByNameTest() {
		//UserDao userDao = new UserDao();
		UserService userService = new UserService();
		List<User> userlist = new ArrayList<User>();
		
		userlist = userService.findUserbyName("周");
		for (User user2 : userlist) {
			System.out.println(user2.toString());

		}
	}	
	
	
	public static void findByIdTest() {
		UserDao userDao = new UserDao();
		User user = new User();
		user = userDao.findById(11);
		System.out.println(user.toString());
	}

}
