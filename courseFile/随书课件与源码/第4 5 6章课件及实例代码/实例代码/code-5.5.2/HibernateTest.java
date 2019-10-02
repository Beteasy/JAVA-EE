import java.util.Date;  
  
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
import org.junit.Test; 

public class HibernateTest {
	public static void main(String[] args){
		SessionFactory sessions = new Configuration().configure().buildSessionFactory();
		Session session = sessions.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Customer cus = new Customer();
			cus.setUserName("zhangsan");
			cus.setPassword("123456");
			System.out.println("开始插入数据到数据库......")；
			session.save(cus);
			tx.commit();
			session.close();
		} catch (Exception e)        {
            System.out.println("插入失败！");            
        }
	}
}
