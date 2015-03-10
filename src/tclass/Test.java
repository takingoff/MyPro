/**
 *	2015年3月10日 下午4:08:01
 *	TangLi
 */
package tclass;

/**
 * @author TangLi
 * 2015年3月10日下午4:08:01
 */
public class Test
{
	public static void main(String[] ar)
	{
		TInterface face = new TInterface()		///awesome way!! 免去了 implements！！！
		{
			@Override
			public void method()
			{
				System.out.println("asfd");
			}
		};
		
		
		face.method();
//		System.out.println(TInterface.a + TInterface.f);
//		face.a ++;
		
		TInterface.Good good = new TInterface.Good();
		good.showSome();
		
		TInterface.StaticGood staticGood = new TInterface.StaticGood();
		staticGood.showSome();
		
		
	}
}
