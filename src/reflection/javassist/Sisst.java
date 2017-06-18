package reflection.javassist;

import java.lang.instrument.Instrumentation;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * @author tangli_takingoff
 * 2016年7月23日上午11:16:09
 */
public class Sisst
{
	
	public static void premain(String agentArgs, Instrumentation inst) {  
//	        Trace.BeginTrace(); // it's important for trace files  
//	        inst.addTransformer(new ASMAgent());  
		
		System.out.println("premain.");
	}  
	

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		
		ClassPool pool = ClassPool.getDefault();
		CtClass cc = pool.get("bean.Student");
		cc.setSuperclass(pool.get("bean.Person"));
		
//		cc.writeFile("C:/Users/tangli_takingoff/Desktop/");
		
		Class<?> clazz = cc.toClass();
		System.out.println(clazz.getSuperclass());
		
		

		cc = pool.get("reflection.javassist.Point");
		CtMethod m = cc.getDeclaredMethod("move");
		m.insertBefore("{ System.out.println(\"arg1 :\"+$1); System.out.println(\"arg2 :\"+$2); }");
//		cc.writeFile();
		
		clazz = cc.toClass();
		Point point = (Point)clazz.newInstance();
		point.move(1,3);

	}
	
}
