package design.model.singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ModelSingleton
{

	public static void main(String[] args) throws IOException
	{
		Singleton sn = Singleton.getInstance();
		System.out.println(sn.resorce);
		
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.maxMemory()/1024/1024);
		System.out.println(rt.freeMemory()/1024/1024);
		System.out.println(rt.totalMemory()/1024/1024);
		
//		rt.exit(0);
		rt.gc();
		Process p =  rt.exec("ping 127.0.0.1");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"gbk"));
		
		char[] c = new char[20];;
		do{System.out.print(c);}while(br.read(c)!=-1);
		
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
