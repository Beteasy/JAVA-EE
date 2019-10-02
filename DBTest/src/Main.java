import java.sql.*;
public class Main {
  public static void main(String args[]) {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");     //����MYSQL JDBC��������   
      //Class.forName("org.gjt.mm.mysql.Driver");
     System.out.println("Success loading Mysql Driver!");
    }
    catch (Exception e) {
      System.out.print("Error loading Mysql Driver!");
      e.printStackTrace();
    }
    try {
      Connection connect = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/servlet?serverTimezone=UTC","root","root");
           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������

      System.out.println("Success connect Mysql server!");
      Statement stmt = connect.createStatement();
//      ResultSet rs = stmt.executeQuery("select * from student");
                                                              //user Ϊ��������
      stmt.executeUpdate("insert into student values(1,1,1,1,1)");
      ResultSet rs = stmt.executeQuery("select * from student");
while (rs.next()) {
        System.out.println(rs.getString("name"));
      }
    }
    catch (Exception e) {
      System.out.print("get data error!");
      e.printStackTrace();
    }
  }
}