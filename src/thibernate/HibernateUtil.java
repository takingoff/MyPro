/**
 *	2015年1月22日 下午3:28:52
 *	TangLi
 */
package thibernate;


import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
	
	
	public static final ThreadLocal<Session> local  =  new ThreadLocal<Session>();
	
	public static Session currentSession()
	{
		Session s  = (Session)local.get();
		if(s == null)
		{
			s = sf.openSession();
			local.set(s);
		}
		return s;
	}
	
	public static void closeSession()
	{
		Session s  = (Session)local.get();
		if(s != null)
			s.close();
		local.set(null);
	}
	
	
	public static void main(String[] ar)
	{
		// testSave();

		System.exit(0);

	}
	
	

	/**
	 * 
	 */
	public static void testSave()
	{
		Session s = HibernateUtil.currentSession();
		Transaction tx = s.beginTransaction();  
		
		for(int i = 0 ;i < 10000 ;i++)
		{
			TStudent st = new TStudent();
			st.setAge(22);
			st.setBirth(new Date());
			st.setName("tangli唐力"+i);
			s.save(st);
		}
		tx.commit(); 
		
		HibernateUtil.closeSession();
	}
	
}
