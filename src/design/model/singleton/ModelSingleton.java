package design.model.singleton;

public class ModelSingleton
{

	public static void main(String[] args)
	{
		Singleton sn = Singleton.getInstance();
		System.out.println(sn.resorce);
	}
}

class Singleton
{
	private static Singleton instance = null;
	private static Object obj = new Object(); // ////一定是所有线程共有的对象用于锁定。

	public static Singleton getInstance()
	{
		if (instance == null)
		{
			synchronized (obj)
			{
				if (instance == null) // //双检测，
					instance = new Singleton();

			}
			return instance;
		}
		return instance;
	}

	public String resorce = "some resorce";

}
