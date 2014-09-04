package net.access.qq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccessFunc
{
	
	/**
	 * @param id
	 * @param psw
	 * @param printMsg  是否打印出 响应头---已经被抛弃
	 * @param lineNum  如果验证成功返回数据 行数大于 lineNum ---已经被抛弃。
	 * @return 如果返回的数据行数大于 lineNum 那么返回true 否者返回 false
	 */
	public static boolean accessCdutStatic(String id, String psw)
	{
		URL url;
		HttpURLConnection connection =null;
//		BufferedReader br = null;
//		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		OutputStreamWriter outputStreamWriter = null;
		try
		{
			// POST /login.php HTTP/1.1
			// Host: 202.115.133.161
			// Connection: keep-alive
			// Content-Length: 66
			// Accept:
			// text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
			// Origin: http://202.115.133.161
			// User-Agent: Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36
			// (KHTML, like Gecko) Chrome/30.0.1599.69 Safari/537.36
			// Content-Type: application/x-www-form-urlencoded
			// Referer: http://202.115.133.161/
			// Accept-Encoding: gzip,deflate,sdch
			// Accept-Language: zh-CN,zh;q=0.8
			// Cookie: PHPSESSID=aufmvl906s0q7qnsecog4sdad0
			//
			// uname=201005070204&upwd=super_tanghao&usertypex=%B9%DC%C0%ED%D4%B1

			// System.out.println(URLEncoder.encode("学生","utf-8"));
			// System.out.println(URLDecoder.decode("%E5%AD%A6%E7%94%9F","utf-8"));
			// System.out.println(URLEncoder.encode("管理员","gbk"));
			// System.out.println(URLDecoder.decode("%B9%DC%C0%ED%D4%B1","gbk"));

			// POST /login.php HTTP/1.1 数据是通过post 出去的，而不是get因此参数不能写进url
			// ，要write出去。
			url = new URL("http://202.115.133.161/login.php");
			connection = (HttpURLConnection) url.openConnection();

			// /这些字段都不用指定，有的是会自动生成，有的没有用
			// connection.setRequestProperty("Connection","keep-alive");
			// connection.setRequestProperty("Content-Length","66");
			// //content-Length 是writer 的字符长度！ 自动生成的不能够指定。
			// uname=201005070204&upwd=super_tanghao&usertypex=%B9%DC%C0%ED%D4%B1
			// connection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
			// connection.setRequestProperty("Origin","http://202.115.133.161");
			// connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.69 Safari/537.36");
			// connection.setRequestProperty("Content-type","application/x-www-form-urlencoded");
			// connection.setRequestProperty("Referer","http://202.115.133.161/");
			// connection.setRequestProperty("Accept-Encoding","gzip,deflate,sdch");
			// connection.setRequestProperty("Accept-Language","zh-CN,zh;q=0.8");

			connection.setDoInput(true);
			connection.setDoOutput(true);

			// /////post content
			outputStream = connection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			outputStreamWriter.write("uname=" + id + "&upwd=" + psw+ "&usertypex=%B9%DC%C0%ED%D4%B1");
			outputStreamWriter.flush();

			// /////返回的数据
			inputStream = connection.getInputStream();
//			inputStreamReader = new InputStreamReader(inputStream, "gb2312");// 因为服务器返回的是Content-Type
																				// :
																				// [text/html;
																				// charset=GB2312]
//			br = new BufferedReader(inputStreamReader);
//			int lineCounter = 0;
//			
//			while ((br.readLine()) != null)
//			{
//				lineCounter ++;
//				if(lineCounter > lineNum)
//					return true;
//			}
			
//			if (printMsg)
//			{
//				showResponseHead(connection);
//			}
			
			inputStream.read();
			inputStream.read();
			//第三个字节为33 说明成功，115 说明失败。
			if(inputStream.read() == 33)
				return true;
			return false;

		}
		catch (Exception e)
		{
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e1)
			{
			}
			// 抛出异常继续访问。
			return accessCdutStatic(id, psw);
		}
		finally
		{
			try
			{
				
//				if(br != null)
//					br.close();
//				if(inputStreamReader != null)
//					inputStreamReader.close();
				if(inputStream != null)
					inputStream.close();
				if(outputStream!= null)
					outputStream.close();
				if(outputStreamWriter != null)
					outputStreamWriter.close();
			}
			catch (Exception e)
			{
				try
				{
					Thread.sleep(3000);
				}
				catch (InterruptedException e1)
				{
				}
				//抛出异常继续访问一次
				return accessCdutStatic(id, psw);
			}
		}

	}
	
	

	
	
	/**
	 * 访问纯文本数据
	 */
	public static void accessServletAndJsp(String urlStr,String charset)
	{
		URL url ;
		BufferedReader br  = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		try
		{
			url = new URL(urlStr);
//			url = new URL("http://localhost:8080/HotelSystem/main/login.jsp");
//			url = new URL("http://localhost:8080/DWZTest");
			HttpURLConnection connection  = (HttpURLConnection)url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);
			
			inputStream = connection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream,charset);
			br= new BufferedReader(inputStreamReader);
			
			StringBuffer sb = new StringBuffer();
			String tempString;
			while((tempString = br.readLine()) != null)
			{
				sb.append(tempString);
			}
			
			System.out.println(sb.toString());
			showResponseHead(connection);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				br.close();
				inputStreamReader.close();
				inputStream.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.out.println("close exception");
			}
		}
	}
	
	
	private static void showResponseHead(HttpURLConnection connection)
	{
		Map<String,List<String>> map = connection.getHeaderFields();
		Set<String> keys = map.keySet();
		for(String key : keys)
		{
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	
	
	public static void main(String[] arsgs)
	{
		accessServletAndJsp("http://user.qzone.qq.com/431997751/main","utf-8");
	}
	
	
}
