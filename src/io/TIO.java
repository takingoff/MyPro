/**
 *	2014年11月11日 上午10:11:59
 *	TangLi
 */
package io;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.io.SequenceInputStream;
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
		// charRead();
		
//		sequenceStream();
		
//		pushBackStream();
		printStream();
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

	
	public static void sequenceStream()throws Exception
	{
		
		InputStream is1= new FileInputStream(new File("text.txt"));
		InputStream is2 = new FileInputStream(new File("text2.txt"));
		SequenceInputStream sis = new SequenceInputStream(is1, is2);
		
		DataInputStream dis = new DataInputStream(sis);

		try
		{
			while(true)
			{
				System.out.println(dis.readChar());
			}
			
		}catch(EOFException e)
		{
			
		}
		sis.close();
		is1.close();
		is2.close();
	}
	
	public static void pushBackStream()throws Exception
	{
		InputStream is = new FileInputStream(new File("text.txt"));
		PushbackInputStream pis = new PushbackInputStream(is,8);
		
		System.out.println("/*read three byte*/");
		System.out.println(pis.read());
		System.out.println(pis.read());
		System.out.println(pis.read());
		
		pis.unread(new byte[]{1,1,1});
		
//		pis.skip(2);
		
		System.out.println("/*after pushback three 1 ,then read three byte*/");
		System.out.println(pis.read());
		System.out.println(pis.read());
		System.out.println(pis.read());
		
		pis.close();
		is.close();
		
	}
	
	
	
	public static void printStream()throws Exception
	{
		
		PrintStream ps = new PrintStream(new File("print.txt"));
		ps.print(false);
		ps.print(12);
		
		System.err.println("err print");
		ps.close();
	}
	
	
}
