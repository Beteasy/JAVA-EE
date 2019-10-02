import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
public class Test {
private static Configuration configuration = null;
private static SessionFactory sessionFactory = null;
private static ServiceRegistry serviceRegistry = null;
public static void main(String[] args) {
try {
              configuration = new Configuration().configure();
serviceRegistry = newServiceRegistryBuilder()
.applySettings(configuration.getProperties()).buildServiceRegistry();
              sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
 }
