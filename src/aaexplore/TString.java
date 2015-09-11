package aaexplore;

import java.net.URLEncoder;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;



public class TString
{

	public static void main(String[] ars) throws Exception
	{
		String dateStr = "[\"2014/10/14\",\"2014/10/18\",\"2014/10/13\"]";
		System.out.println(dateStr);
		
		String[] list = ((String)dateStr.subSequence(1, dateStr.length()-1)).split(",");
		for(String s: list)
		{
			System.out.println(s);
		}
		
		
		System.out.println(StringUtils.isBlank("   "));
		System.out.println(StringUtils.isBlank(""));
		System.out.println(StringUtils.isBlank(null));
		
		System.out.println(StringUtils.isEmpty("   "));
		System.out.println(StringUtils.isEmpty(""));
		System.out.println(StringUtils.isEmpty(null));
		
		
		
		String url = "|";
		System.out.println(URLEncoder.encode(url, "utf-8"));
		
		System.out.println(UUID.randomUUID().toString());;
		
		
	}
	
	
	
	
}

