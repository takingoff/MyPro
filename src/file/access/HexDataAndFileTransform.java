package file.access;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

public class HexDataAndFileTransform
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		
		System.out.println("如果字节的值是 -128~-1 那么将取其补码，即：加上256");
		
		
//		fileToHexData("C:/Users/LiTang/Desktop/test.txt","C:/Users/LiTang/Desktop/test2.txt");
//		
//		hexDataToFile("C:/Users/LiTang/Desktop/test2.txt","C:/Users/LiTang/Desktop/test3.txt");
		
		gzipDecompressFile("C:/Users/LiTang/Desktop/新建文本文档3.txt","C:/Users/LiTang/Desktop/新建文本文档3.txt");
	
		
	}
	
	
	public static String byteToHexString(byte b)
	{
		
		//如果 字节为负 对其取补  即：加上 256.
		
		int val = b;
		if(val <0)
			val += 256;
		
		int high = val/16;
		int low  = val%16;
		
//		char c = 'A'; 			// 0 是48  9 是57   a 是97 A是65
		
		if(high > 9)
			high = high + 55;
		else
			high = high + 48;
		
		if(low >9 )
			low = 65 +(low - 10 );
		else
			low = low + 48;
		
		char h = (char) high;
		char l = (char) low;
		
		return  Character.toString(h) + Character.toString(l);
	}
	
	public static void fileToHexData(String inputPathFile,String outPutPathFile)
	{
		FileInputStream fis =  null;
		MyBufferedWriter mbw = null;
		try
		{
			fis = new FileInputStream(inputPathFile);
			byte[] b = new byte[1];
			StringBuffer sb = new StringBuffer();
			while((fis.read(b)) != -1)
			{
				//字节的十六进制表示 加上空格
				sb.append(byteToHexString(b[0]) + " ");
			}
			
			mbw = new MyBufferedWriter(outPutPathFile);
			mbw.bw.write(sb.toString());
			mbw.bw.flush();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				
				if(fis != null)
					fis.close();
				
				if(mbw != null)
					mbw.close();
			}
			catch(Exception e)
			{
				System.out.println("close exception");
			}
		}
	}

	
	
	/**
	 * @param s  s必须是两个十六进制的数字字符(十六进制的abcd要大写)。 否者exception
	 * @return
	 */
	public static byte hexStringToByte(String s)throws Exception
	{
		
//		char c = 'A'; 			// 0 是48  9 是57   a 是97 A是65 F是 70
		
		if(s.length()!= 2 )
			throw new Exception("analyses failed ! the data is incorrect");
		
		byte[] b = s.getBytes();
		if(b.length != 2)
			throw new Exception("analyses failed ! the data is incorrect");
		
		
		
		int val=0;
		int sum=0;
		
		for(int i = 0 ;i <=1 ;i ++)
		{
			
			if(b[i] <48 || b[i] > 70 || (b[i]>57 && b[i] <65) )
				throw new Exception("analyses failed ! the data is incorrect");
			else if(b[i] >=48 && b[i] <= 57)
				val =  b[i] - 48;
			else 
				val = b[i] - 55;
			
			sum = (int) (sum + val*(Math.pow(16,(1-i))));
			
		}
		
		return (byte) sum;
	}
	
	/**
	 * @param inputPathFile  指定的文件必须满足一个十六进制一个空格的格式
	 * @param outPutPathFile
	 */
 	public static void hexDataToFile(String inputPathFile,String outPutPathFile)
	{
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		FileOutputStream fos = null;
		try
		{
			
			fis = new FileInputStream(inputPathFile);
			isr =new InputStreamReader(fis);
			
			fos = new FileOutputStream(outPutPathFile);
			
			char[] cs =new char[2];
			//每次读两个字符。
			while(isr.read(cs) != -1)
			{
				StringBuffer sb = new StringBuffer();
				sb.append(cs);
				fos.write(hexStringToByte(sb.toString()));
				
				isr.read();	//读走空格。
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(fos!= null)
					fos.close();
				
			}
			catch(Exception e)
			{
				System.out.println("close exception");
			}
		}
	}
	

		
 	public static void gzipDecompressFile(String inputpathFile,String outPutPathFile)
 	{
 		
 		GZIPInputStream gzipInput = null;
 		FileInputStream fis = null;
 		FileOutputStream fos = null;
 		try
 		{
 			fis = new FileInputStream(inputpathFile);
 			gzipInput = new GZIPInputStream(fis);
 			
 			fos = new FileOutputStream(outPutPathFile);
 			
 			
 			byte[] bs = new byte[1024];
 			int index ;
 			while((index= gzipInput.read(bs)) != -1)
 			{
 				fos.write(bs,0,index);
 			}
 				
 			
 		}catch(Exception e)
 		{
 		
 			e.printStackTrace();
 		}
 		finally
 		{
 			try
 			{
 				
 				if(gzipInput != null)
 					gzipInput.close();
 				
 				if(fis != null)
 					fis.close();
 				
 			}catch(Exception e)
 			{
 				e.printStackTrace();
 			}
 		}
 		
 	}
 	
 	
}
