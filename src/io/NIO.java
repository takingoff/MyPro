/**
 *	2016年7月9日 下午3:00:29
 *	tangli_takingoff
 */
package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author tangli_takingoff
 * 2016年7月9日下午3:00:29
 */
public class NIO
{
	
	public static void main(String[] ars)
	{
		
//		bufferTest();
		
		channel();
		
		
	}

	/**
	 * @throws FileNotFoundException
	 */
	private static void channel() 
	{
		try
		{
			FileInputStream fi = new FileInputStream("text.txt");
			FileChannel channel = fi.getChannel();
			ByteBuffer bb = ByteBuffer.allocate(100);
			channel.read(bb);
			System.out.println(bb);
			
			byte[] bs = new byte[bb.position()];
			bb.flip();	// 必须让position  = 0 !!!
			bb.get(bs);
			
			bb.rewind();
			System.out.println(bb);
			System.out.println(bb.asCharBuffer());
			
			for(int i =0 ;i < bs.length;i++)
				System.out.print(bs[i]+",");
			System.out.println("");
			
			// 直接转为 UTF-16 可以识别
			System.out.println(new String(bs,"UTF-16"));
			
			// 去掉 bom 也可以识别
			System.out.println(new String(bs,2,bs.length-2,"UTF-16"));
			
			fi.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	
	private static void bufferTest()
	{
		ByteBuffer bb = ByteBuffer.allocate(6);
		System.out.println(bb);
		
		System.out.println("----");
		
		bb.put((byte)1);
		bb.put((byte)1);
		bb.put((byte)1);
		bb.put((byte)1);
		bb.put((byte)1);
		System.out.println(bb);
		
		bb.compact();	// position= limit - position ,limit = capacity
		System.out.println("compact:" + bb);
		
		bb.flip();	// position = 0 ,limit = position
		System.out.println("flip   :" + bb);
		
		bb.clear(); // position = 0 limit  = capacity
		System.out.println("clear  :" + bb);
		
		bb.rewind();// position  = 0 
		System.out.println("rewind :" + bb);
		
		bb.position(3);
		bb.mark();
		bb.position(6);
		bb.reset();	// position  = mark
		System.out.println(bb);
	}

}
