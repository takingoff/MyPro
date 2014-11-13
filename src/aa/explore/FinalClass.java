/**
 *	2014年10月23日 下午2:32:33
 *	TangLi
 */
package aa.explore;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLi
 * 2014年10月23日下午2:32:33
 */
public final class FinalClass
{
	
	public String name ;
	
	public FinalClass(String value)
	{
		this.name = value;
	}

	
	@Override
	public String toString()
	{
		return "FinalClass [name=" + name + "]";
	}


	public static void  main(String[] args)
	{
		List<FinalClass> list = new ArrayList<FinalClass>();
		FinalClass f = new FinalClass("TL");
		list.add(f);
		
		f.name ="afterChage";
		
		System.out.println(list);
	}
	
	
}
