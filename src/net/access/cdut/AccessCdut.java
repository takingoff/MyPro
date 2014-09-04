package net.access.cdut;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author LiTang
 * test compare show that it is slower than AccessFunc.AccessCdutStatic()!!!
 */
public class AccessCdut
{
	URL url;
	HttpURLConnection connection =null;
	InputStream inputStream = null;
	OutputStream outputStream = null;
	OutputStreamWriter outputStreamWriter = null;
	
	
	public  AccessCdut(String urlPath)
	{
		try
		{
			url = new URL(urlPath);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public boolean accessOnece(String id,String pasw)
	{
		try
		{
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setDoOutput(true);

			// /////post content
			outputStream = connection.getOutputStream();
			outputStreamWriter = new OutputStreamWriter(outputStream);
			outputStreamWriter.write("uname=" + id + "&upwd=" + pasw+ "&usertypex=%B9%DC%C0%ED%D4%B1");
			outputStreamWriter.flush();

			// /////返回的数据
			inputStream = connection.getInputStream();
			
			inputStream.read();
			inputStream.read();
			//第三个字节为33 说明成功，115 说明失败。
			if(inputStream.read() == 33)
				return true;
			return false;
		}
		catch (IOException e)
		{
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException e1)
			{
			}
			return accessOnece(id,pasw);
			
		}
		
	}
	
	
	@Override
	protected void finalize() throws Throwable
	{
		try
		{
			if(inputStream != null)
				inputStream.close();
			if(outputStream!= null)
				outputStream.close();
			if(outputStreamWriter != null)
				outputStreamWriter.close();
		}
		catch (Exception e)
		{
			System.out.println("close exception");
		}
	}
	
	
	
}
