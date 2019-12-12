package service;

import java.util.List;

import dao.UserDao;
import entity.PageVO;
import entity.User;

public class UserService {

	UserDao userDao = new UserDao();

	//查询服务
	
	/**
	 * 分页查询
	 * @param page 当前页
	 * @param recordOfPage 每一页记录数
	 * @return 当前页的用户记录
	 */
	public PageVO<User> search(int page,int recordOfPage){
		
		//System.out.println("第"+ page + "页:" +recordOfPage +"条记录");
		
		PageVO<User> pageVO = new PageVO<User>();
		// 1 查询总记录数量
		int recordCount = userDao.getCount();
		// 2 计算总页数
		int pageCount = (recordCount-1) / recordOfPage + 1;
		// 3 约束当前页码在允许范围
		if(page < 1) { page = 1; }
		if(page > pageCount ) {page = pageCount;}
		// 4 获取当前页的数据记录
		List<User> userList = userDao.selectPage(page, recordOfPage);

		pageVO.setRecordOfPage(recordOfPage);
		pageVO.setRecordCount(recordCount);
		pageVO.setPageCount(pageCount);
		pageVO.setPage(page);
		pageVO.setList(userList);
		//6返回分页查询结果
		return pageVO;
	}
	
	/**
	 * 查找所用用户
	 * @return
	 */
	public List<User> findUserAll(){
		
		return userDao.findAll();
	}
	
	/**
	 * 按姓名查找用户
	 * @param name
	 * @return
	 */
	public List<User> findUserbyName(String name){
		
		return userDao.findByName(name);
	}
	
	/**
	 * 按Id号查找用户
	 * @param id
	 * @return
	 */
	public User findUserbyId(Integer id) {
		
		return userDao.findById(id);
	}

	//更新业务
	/**
	 * 新增用户
	 * @param user
	 */
	public void saveUser(User user) {

		userDao.insertUser(user);		
	}
	
	/**
	 * 修改用户
	 * @param user
	 */
	public void changeUser(User user) {

		userDao.updateUser(user);		
	}
	
	/**
	 * 删除单个用户
	 * @param id
	 */
	public void deleteUser(int id) {

		userDao.deleteUser(id);	
	}

	/**
	 * 批量删除用户
	 * @param ids
	 */
	public void deleteUser(String[] ids) {

		for (String id : ids) {
			userDao.deleteUser(Integer.parseInt(id));
		}
	}
}
