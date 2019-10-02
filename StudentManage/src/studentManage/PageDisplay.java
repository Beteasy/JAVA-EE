package studentManage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class PageDisplay extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public PageDisplay() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		this.doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String op = request.getParameter("op");	//这是什么意思?????????????????????????????????????????????
		int method = Integer.parseInt(op);
		try {
			if(method == 0) {
				insert(request,response);
			}
			else if(method == 1) {
				delete(request,response);
			}
			else if(method == 2) {
				update(request,response);
			}
			else if(method == 3) {
				select(request,response);
			}
			else {
				add(request,response);
			}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//插入方法
	public void insert(HttpServletRequest request, HttpServletResponse response){
		try {
			String id = request.getParameter("id");		//这个是不是根据html中的name属性来确定的
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String major = request.getParameter("major");
			if(id.equals("") || age.equals("")) {
				JOptionPane.showMessageDialog(null, "学号和年龄不能为空，且必须为整数");
				response.sendRedirect("index.html");
			}
			else if(isNumber(age) == false) {
				JOptionPane.showMessageDialog(null, "年龄必须为整数，请重新输入");
				response.sendRedirect("index.html");
			}
			else {
				Student st = new Student();
				st.setId(Integer.parseInt(id));
				st.setName(name);
				st.setAge(Integer.parseInt(age));
				st.setGender(gender);
				st.setMajor(major);
				DataBaseMethods dbmeth = new DataBaseMethods();
				dbmeth.insert(st);
				response.sendRedirect("/StudentManage/PageDisplay?op=3");
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	public boolean isNumber(String str)
    {
        java.util.regex.Pattern pattern=java.util.regex.Pattern.compile("[0-9]*");
        java.util.regex.Matcher match=pattern.matcher(str);
        if(match.matches()==false)
        {
             return false;
        }
        else
        {
             return true;
        }
    }
	
	// 信息删除方法
		public void delete(HttpServletRequest request, HttpServletResponse response)
				throws ClassNotFoundException, SQLException, ServletException, IOException {

			String id = request.getParameter("id");
			DataBaseMethods dbmeth = new DataBaseMethods();
			dbmeth.delete(id);

			response.sendRedirect("/StudentManage/PageDisplay?op=3");
		}

		// 信息修改方法
		public void update(HttpServletRequest request, HttpServletResponse response)
				throws ClassNotFoundException, SQLException, ServletException, IOException {

			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String major = request.getParameter("major");
			Student st = new Student();
			st.setId(Integer.parseInt(id));
			st.setName(name);
			st.setAge(Integer.parseInt(age));
			st.setGender(gender);
			st.setMajor(major);

			DataBaseMethods dbmeth = new DataBaseMethods();
			dbmeth.update(st);

			response.sendRedirect("/StudentManage/PageDisplay?op=3");
		}

		// 查询方法
		public void select(HttpServletRequest request, HttpServletResponse response)
				throws ClassNotFoundException, SQLException, IOException {

			List<String> result = new ArrayList<String>();
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			if (id == null)
				id = "";
			if (name == null)
				name = "";
			DataBaseMethods dbmeth = new DataBaseMethods();
			Set<Student> sts = dbmeth.selectStudents(id, name);

			String str = "";
			str = "<table frame=\"border\" bordercolor=\"black\" style=\"width: 600px; \" >	";
			result.add(str);
			str = "<tr><td style=\"border:1px solid black;\">学号</td><td style=\"border:1px solid black;\">姓名</td><td style=\"border:1px solid black;\">年龄</td><td style=\"border:1px solid black;\">性别</td><td style=\"border:1px solid black;\">专业</td><td style=\"border:1px solid black;\">操作</td></tr>";
			result.add(str);
			Iterator<Student> it = sts.iterator();
			while (it.hasNext()) {
				Student st = it.next();
				str = "<tr>";
				str = str + "<td style=\"border:1px solid black;\">" + st.getId() + "</td>";
				str = str + "<td style=\"border:1px solid black;\">" + st.getName() + "</td>";
				str = str + "<td style=\"border:1px solid black;\">" + st.getAge() + "</td>";
				str = str + "<td style=\"border:1px solid black;\">" + st.getGender() + "</td>";
				str = str + "<td style=\"border:1px solid black;\">" + st.getMajor() + "</td>";
				str = str + "<td style=\"border:1px solid black;\">" + "<a href='PageDisplay?op=1&id=" + st.getId()
						+ "'>  删除</a>" + "&nbsp&nbsp&nbsp&nbsp" + "<a href='PageDisplay?op=4&id=" + st.getId()
						+ "'>  修改</a>" + "</td>";
				str = str + "</tr>";
				result.add(str);
			}
			str = "</table>" + "<BR>" + "<a href='index.html'> 返回主页面</a>";
			result.add(str);

			OutPut.outputToClient(result, response);
		}

		// 查询方法
		public void add(HttpServletRequest request, HttpServletResponse response)
				throws ClassNotFoundException, SQLException, IOException {

			List<String> result = new ArrayList<String>();
			String id = request.getParameter("id");
			DataBaseMethods dbmeth = new DataBaseMethods();
			Set<Student> sts = dbmeth.selectStudents(id, "");
			Iterator<Student> it = sts.iterator();

			String str = "<form action = '/StudentManage/PageDisplay?op=2' method='post' target='workspace'>";
			result.add(str);
			while (it.hasNext()) {
				Student st = it.next();
				str = "学号：<input type='text' name='id' value='" + st.getId() + "'><br>"
						+ "姓名：<input type='text' name='name' value='" + st.getName() + "'><br>"
						+ "年龄：<input type='text' name='age' value='" + st.getAge() + "'><br>"
						+ "性别：<input type='text' name='gender' value='" + st.getGender() + "'><br>"
						+ "专业：<input type='text' name='major' value='" + st.getMajor() + "'><br>";
				result.add(str);
			}
			str = "<input type='submit' name='modify' value='修改'> <br>"
					+ "<a  href=\"/StudentManage/PageDisplay?op=3\"  target=\"workspace\">返回查询结果页面</a>" + "</form>";

			result.add(str);

			OutPut.outputToClient(result, response);
		}
}
