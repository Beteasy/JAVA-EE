
public class HibernateUtil {
private static Log log = LogFactory.getLog(HibernateUtil.class);
private static final SessionFactory.sessionFactory;
static {
try{  //创建SessionFactory
sessionFactory = new Configuration().configure.buildSessionFactory();
}
catch(Throw ex){
//......
}
}
public static final ThreadLocal thread_var = new ThreadLocal();
public static Session currentSession() {
Seesion s = thread_var.get();
//如果这个线程为空，打开一个新的Session
if(s==null){
s = sessionFactory.openSession();
thead_var.get(s);
}
return s;
}
public static void closeSession(){
Session s = thread_var.get();
if(s!=null)
s.close();
thread_var.set(null);
}
}
