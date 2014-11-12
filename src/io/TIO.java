/**
 *	2014年11月11日 上午10:11:59
 *	TangLi
 */
package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author TangLi 2014年11月11日上午10:11:59
 */
public class TIO implements Serializable
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] arg) throws Exception
	{

		// writeObject();
		// readObject();
		// dataRead();
		// byteArray();
		charRead();
	}

	public String name = "TIO";

	public static void writeObject() throws Exception
	{
		FileOutputStream fos = new FileOutputStream("objectfile.obj");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		TIO obj = new TIO();
		obj.name = "good name";
		oos.writeObject(obj);
		oos.close();

	}

	public static void readObject() throws Exception
	{
		FileInputStream fos = new FileInputStream(new File("objectfile.obj"));
		ObjectInputStream oos = new ObjectInputStream(fos);

		TIO obj = (TIO) oos.readObject();
		System.out.println(obj.name);

		oos.close();
	}

	public static void dataRead() throws Exception
	{
		File file = new File("text.txt");

		FileInputStream fis = new FileInputStream(file);

		BufferedInputStream bis = new BufferedInputStream(fis);

		DataInputStream dis = new DataInputStream(bis);

		System.out.println(dis.readChar());
		System.out.println(dis.readChar());
		System.out.println(dis.readChar());
		System.out.println(dis.readChar());
		System.out.println(dis.readChar());

		dis.close();
	}

	public static void byteArray()
	{
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout.write(1);
		bout.write(0);
		bout.write(1);
		byte[] buf = bout.toByteArray();// 获取内存缓冲中的数据
		System.out.println(buf[0]);
		System.out.println(buf[1]);
		System.out.println(buf[2]);
	}

	public static void charRead()throws Exception
	{
		File file = new File("text.txt");

		FileInputStream fis = new FileInputStream(file);

		BufferedInputStream bis = new BufferedInputStream(fis);

		InputStreamReader isr = new InputStreamReader(bis,"utf-16");

		char[] cs = new char[10];
		
		int result =0;
		do
		{
			result = isr.read(cs);
			for(int i = 0 ;i <result;i++)
			{
				System.out.print(cs[i]);
			}
		}
		while(result == 10);
		
		isr.close();
		
		
	}

}
