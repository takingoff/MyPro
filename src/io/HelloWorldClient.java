package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;

/**
 * @author tangli_takingoff 2016年7月16日下午1:24:09
 */
public class HelloWorldClient
{

	static InetSocketAddress ip = new InetSocketAddress("localhost", 9999);
	static CharsetEncoder encoder = Charset.forName("GB2312").newEncoder();

	public static void main(String[] args) throws IOException
	{
		for (int index = 0; index < 1; index++)
			new Thread(new Message("jeff[" + index + "]")).start();
	}
		
	static class Message implements Runnable
	{
		protected String name;

		public Message(String index)
		{
			this.name = index;
		}

		public void run()
		{
			try
			{
				// 打开Socket通道
				SocketChannel client = SocketChannel.open();
				// 设置为非阻塞模式
				client.configureBlocking(false);
				
				// 打开选择器
				Selector selector = Selector.open();
				// 注册连接服务端socket动作
				client.register(selector, SelectionKey.OP_CONNECT);
				
				// 连接
				client.connect(ip);
				
				
				ByteBuffer buffer = ByteBuffer.allocate(8 * 1024);

				_FOR:
				while(true)
				{
					
					selector.select();
					
					Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
					while (iter.hasNext())
					{
						SelectionKey key = (SelectionKey) iter.next();
						iter.remove();
						
						if (key.isConnectable())
						{
							System.err.println("connectable*****************");
							SocketChannel channel = (SocketChannel) key.channel();
							if (channel.isConnectionPending())
								channel.finishConnect();
							
							channel.write(encoder.encode(CharBuffer.wrap(name)));
							System.err.println("	client send data:"+name);
							channel.register(selector, SelectionKey.OP_READ);
							
						}
						else if (key.isReadable())
						{
							System.err.println("readable*****************");
							SocketChannel channel = (SocketChannel) key.channel();
							int count = channel.read(buffer);
							if (count > 0)
							{
								String msg= "";
								buffer.flip();
								while (buffer.remaining() > 0)
								{
									byte b = buffer.get();
									msg += (char) b;
								}
								buffer.clear();
								System.err.println("	client received data:"+msg);
							}
							else
							{
								System.err.println("	client received no data");
								client.close();
								break _FOR;
							}
						}
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	
}