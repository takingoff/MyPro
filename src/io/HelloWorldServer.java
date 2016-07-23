package io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * @author tangli_takingoff 2016年7月16日下午12:57:46
 */
public class HelloWorldServer
{
	public static void main(String[] args)
	{
		ServerSocketChannel server = null;
		try
		{
			server = ServerSocketChannel.open();
			server.socket().bind(new InetSocketAddress(8888));
			server.configureBlocking(false);
			
			Selector selector = Selector.open();
			server.register(selector, SelectionKey.OP_ACCEPT);
			
			while(true)
			{
				//...........
				selector.select();
				//...........
				
				Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				while (iter.hasNext())
				{
					SelectionKey key = (SelectionKey) iter.next();
					iter.remove();
					
					process(selector, key);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(server != null)
					server.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param selector
	 * @param key
	 */
	private static void process(Selector selector, SelectionKey key) throws Exception
	{
		Charset charset = Charset.forName("GB2312");
		CharsetDecoder decoder = charset.newDecoder();
		CharsetEncoder encoder = charset.newEncoder();
		ByteBuffer clientBuffer = ByteBuffer.allocate(1024);
		
		// 接收请求
		if (key.isAcceptable())
		{ 
			System.out.println("acceptable ..............");
			ServerSocketChannel server = (ServerSocketChannel) key.channel();
			SocketChannel channel = server.accept();
			
			// 设置非阻塞模式
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_READ);
		}
		// 读信息
		else if (key.isReadable())
		{ 
			System.out.println("readable ..............");
			SocketChannel channel = (SocketChannel) key.channel();
			
			int count = channel.read(clientBuffer);
			if (count > 0)
			{
				clientBuffer.flip();
				CharBuffer charBuffer = decoder.decode(clientBuffer);
				String name = charBuffer.toString();
				 System.out.println(name);
				SelectionKey sKey = channel.register(selector, SelectionKey.OP_WRITE);
				sKey.attach(name);
			}
			else
				channel.close();

			clientBuffer.clear();
		}
		// 写事件
		else if (key.isWritable())
		{ 
			System.out.println("writeable ..............");
			SocketChannel channel = (SocketChannel) key.channel();
			String name = (String) key.attachment();

			ByteBuffer block = encoder.encode(CharBuffer.wrap("Hello !" + name));

			channel.write(block);

			 channel.close();
		}
	}
}