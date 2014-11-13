package aa.explore;



public class TString
{

	public static void main(String[] ars)
	{
		String dateStr = "[\"2014/10/14\",\"2014/10/18\",\"2014/10/13\"]";
		
		System.out.println(dateStr);
		
		String[] list = ((String)dateStr.subSequence(1, dateStr.length()-1)).split(",");
		
		for(String s: list)
		{
			System.out.println(s);
		}
	}
	
}
