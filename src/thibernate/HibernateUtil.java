/**
 *	2015年1月22日 下午3:28:52
 *	TangLi
 */
package thibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author TangLi
 * 2015年1月22日下午3:28:52
 */
public class HibernateUtil
{
	public static final SessionFactory sf;
	
	static{
		
//		sf = new Configuration().addFile("hibernate.xml").configure().buildSessionFactory();
		Configuration configuration = new Configuration(); 
		configuration.configure(); 
		System.out.println(configuration.getProperties());
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sf = configuration.buildSessionFactory(serviceRegistry); 
	}
	
	
	public static final ThreadLocal<Session> session  =  new ThreadLocal<Session>();
	
	public static Session currentSession()
	{
		Session s  = (Session)session.get();
		
		if(s == null)
		{
			s = sf.openSession();
			session.set(s);
		}
		return s;
		
	}
	
	public static void closeSession()
	{
		Session s  = (Session)session.get();
		if(s != null)
			s.close();
		session.set(null);
	}
	
	
	
	public static void main(String[] ar)
	{
		
		Session s = HibernateUtil.currentSession();
		
		TStudent st = new TStudent();
		st.setAge(22);
		st.setBirth(new Date());
		st.setName("小红an");
		s.save(st);
		
	}
	
}
