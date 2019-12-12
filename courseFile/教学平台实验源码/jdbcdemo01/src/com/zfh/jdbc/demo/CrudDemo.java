package com.zfh.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.zfh.jdbc.demo.pojo.User;

/**
 * 1程序可能会有哪些异常 2程序可能会用到哪些基础知识 3数据的自然流向和封装 4业务描述与对应的数据操作 5可能的漏洞会有哪些
 * 6有哪些是公共的，是不是可以重构一下代码 7有哪些是以后还可能会用的，是不是可以封装成工具 8这些异常都往上抛，最终会由谁来处理？
 * 
 * @author fhzheng
 *
 */
public class CrudDemo {

	public static String drvier = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/easybuy";
	public static String username = "root";
	public static String password = "rootcuit";

	public static Connection conn = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

//		queryUser01();
//		getUserbyIdTest();
//		registerMoc();
		managerMoc();
//		loginMoc();
	}

	private static void managerMoc() throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请将要修改用户名的用户ID号");
		Integer id = Integer.parseInt(scanner.nextLine());
		System.out.println("请输入新的用户名：");
		String userName = scanner.nextLine();
		User user = new User();
		user = queryUserbyId(id);
		System.out.println("原用户信息" + user.toString());
		user.setUserName(userName);
		updateUser(user);
		// 重取用户信息
		user = queryUserbyId(id);
		System.out.println("新用户信息" + user.toString());
	}

	private static void registerMoc() throws ClassNotFoundException, SQLException {
		// 创建用户
		Scanner scanner = new Scanner(System.in);
		User user = new User();
		// 数据准备
		System.out.println("请输入用户登录名");
		String loginName = scanner.nextLine();
		System.out.println("请输入用户名");
		String userName = scanner.nextLine();
		System.out.println("请输入密码");
		String password = scanner.nextLine();
		System.out.println("请输入性别");
		Integer sex = Integer.parseInt(scanner.nextLine());
		System.out.println("请输入身份证号");
		String identityCode = scanner.nextLine();
		System.out.println("请输入邮箱");
		String email = scanner.nextLine();
		System.out.println("请输入电话");
		String mobile = scanner.nextLine();
		System.out.println("请输入类型");
		Integer type = Integer.parseInt(scanner.nextLine());
		// 封装到对象
		user.setLoginName(loginName);
		user.setUserName(userName);
		user.setPassword(password);
		user.setSex(sex);
		user.setIdentityCode(identityCode);
		user.setEmail(email);
		user.setMobile(mobile);
		user.setType(type);
		System.out.println("将要注册的用户信息是：" + user.toString());
		// 注册用户
		saveUser(user);
	}

	private static void updateUser(User user) throws ClassNotFoundException, SQLException {
		// 0 语句准备
		String sql = "update easybuy_user set userName = ? where id = ?";
		// 1 申请驱动
		Class.forName(drvier);
		// 2 创建连接
		conn = DriverManager.getConnection(url, username, password);
		// 3 创建执行
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getUserName());
		ps.setInt(2, user.getId());
		// 4 执行
		ps.executeUpdate();
		// 5 处理结果，没有拿结果，不需要处理
		// 6 关闭连接
		ps.close();
		conn.close();
	}

	private static void saveUser(User user) throws ClassNotFoundException, SQLException {
		// 0 语句准备
		String sql = "insert into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile,type) values(?,?,?,?,?,?,?,?)";
		// 1 申请驱动
		Class.forName(drvier);
		// 2 创建连接
		conn = DriverManager.getConnection(url, username, password);
		// 3 创建执行
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, user.getLoginName());
		ps.setString(2, user.getUserName());
		ps.setString(3, user.getPassword());
		ps.setInt(4, user.getSex());
		ps.setString(5, user.getIdentityCode());
		ps.setString(6, user.getEmail());
		ps.setString(7, user.getMobile());
		ps.setInt(8, user.getType());
		// 4 执行
		ps.executeUpdate();
		rs = ps.getGeneratedKeys();
		if (rs != null) {
			rs.next();
			System.out.println("新注册的用户自动编号是：" + rs.getInt(1));
		}
		// 5 处理结果，没有拿结果，不需要处理
		// 6 关闭连接
		ps.close();
		conn.close();
	}

	private static void loginMoc() throws ClassNotFoundException, SQLException {
		// 输入用户名和密码，模拟用户登录
		System.out.println("请输入用户名:");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("请输入密码:");
		String password = scanner.nextLine();
		System.out.println("您输入的用户名和密码是：" + username + ":" + password);
		User user = queryUserbyNameandPass(username, password);
		if (user != null) {
			System.out.println("用户登录成功");
			System.out.println("用户信息是：" + user.toString());
		} else {
			System.out.println("用户登录失败");
		}
	}

	private static User queryUserbyNameandPass(String username2, String password2)
			throws ClassNotFoundException, SQLException {
		User user = null;
		// 0 语句准备
		String sql = "select * from easybuy_user where loginName = ? and password=?";
		// 1 申请驱动
		Class.forName(drvier);
		// 2 创建连接
		conn = DriverManager.getConnection(url, username, password);
		// 3 创建执行
		ps = conn.prepareStatement(sql);
		ps.setString(1, username2);
		ps.setString(2, password2);
		// 4 获取结查
		rs = ps.executeQuery();
		// 5 处理结果
		if (rs.next()) {
//			private Integer id;
//			private String loginName;
//			private String userName;
//			private String password;
//			private Integer sex;
//			private String identityCode;
//			private String email;
//			private String mobile;
//			private Integer type;
			user = new User();
			user.setId(rs.getInt("id"));
			user.setSex(rs.getInt("sex"));
			user.setType(rs.getInt("type"));
			user.setLoginName(rs.getString("loginName"));
			user.setUserName(rs.getString("userName"));
			user.setPassword(rs.getString("password"));
			user.setIdentityCode(rs.getString("identityCode"));
			user.setEmail(rs.getString("email"));
			user.setMobile(rs.getString("mobile"));
		}
		// 6 关闭连接
		rs.close();
		ps.close();
		conn.close();

		return user;
	}

	private static void getUserbyIdTest() throws ClassNotFoundException, SQLException {
		User user = queryUserbyId(2);
		System.out.println(user.toString());
	}

	private static User queryUserbyId(Integer id) throws ClassNotFoundException, SQLException {

		User user = new User();
		// 0 语句准备
		String sql = "select * from easybuy_user where id = ?";
		// 1 申请驱动
		Class.forName(drvier);
		// 2 创建连接
		conn = DriverManager.getConnection(url, username, password);
		// 3 创建执行
		ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		// 4 获取结查
		rs = ps.executeQuery();
		// 5 处理结果
		if (rs.next()) {
			user.setId(id);
			user.setLoginName(rs.getString("loginName"));
		}
		// 6 关闭连接
		rs.close();
		ps.close();
		conn.close();

		return user;
	}

	private static void queryUser01() throws ClassNotFoundException, SQLException {
		String sql = "select * from easybuy_user";
		// 1 申请驱动
		Class.forName(drvier);
		// 2 创建连接
		conn = DriverManager.getConnection(url, username, password);
		// 3 创建执行
		ps = conn.prepareStatement(sql);
		// 4 获取结果
		rs = ps.executeQuery();
		// 5 处理结果

		// 列处理
		ResultSetMetaData rsmd = rs.getMetaData(); // 用于动态获取列名,获取列集
		int count = rsmd.getColumnCount(); // 获取列数
		List<String> colNames = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			colNames.add(rsmd.getColumnName(i + 1)); // 它是从1开始的
		}
		System.out.println("该表的列名是：");
		for (String name : colNames) {
			System.out.print(name + " ");
		}
		System.out.println();

//		rs.next();
//		System.out.println("第一行记录的第1个字段结果是：" + null);

		// 遍历结果集
		// 将第1行结果处理到一个Map中，数据结构：列名：列值，刚好是一个map结构，即键值对
		Map<String, Object> dataMap = new HashMap<String, Object>();
		if (rs.next()) {
			ResultSetMetaData rsMeta = rs.getMetaData();
			int columnCount = rsMeta.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				dataMap.put(rsMeta.getColumnLabel(i), rs.getObject(i));
			}
		}
		// 输出该map
		// 输出列名，映射集操作
		for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
			String columnName = entry.getKey();
			System.out.print(columnName + "\t\t");
		}
		System.out.println();
		// 输出列值，映射集操作，不管是什么具体的数据类型，一切皆为对象
		for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
			Object columnValue = entry.getValue();
			System.out.print(columnValue.toString() + "\t");
		}
		System.out.println();
		System.out.println();
		System.out.println();

		// 将所有结果处理到一个List中，一行为一个map，多行则为这些map构成的list
		rs.beforeFirst(); // rs指针归位，即指向首行之前
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		ResultSetMetaData rsMeta = rs.getMetaData();
		int columnCount = rsMeta.getColumnCount();
		// 行指针后移
		while (rs.next()) {
			Map rowData = new HashMap(); // 声明Map，更安全的方式，是跟上面一样
			// 列指针后移
			for (int i = 1; i <= columnCount; i++) {
				rowData.put(rsMeta.getColumnName(i), rs.getObject(i));// 获取键名及值
			}
			rows.add(rowData);
		}
		// 遍历输出
		for (Map<String, Object> row : rows) {
			for (Map.Entry<String, Object> entry : row.entrySet()) {
				Object columnValue = entry.getValue();
				System.out.print(columnValue.toString() + "\t");
			}
			System.out.println();
		}

		// 6 关闭连接
		rs.close();
		ps.close();
		conn.close();
	}

}
