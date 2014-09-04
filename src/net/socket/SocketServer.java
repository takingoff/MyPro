package net.socket;

//: JabberServer.java 
//Very simple server that just 
//echoes whatever the client sends. 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
	// Choose a port outside of the range 1-1024:
	public static final int PORT = 9090;

	public static void main(String[] args) throws IOException
	{
		ServerSocket s = new ServerSocket(PORT);
		Socket socket = null;
		System.out.println("Started: " + s);
		try
		{
			
			while(true)
			{
				
				// Blocks until a connection occurs:
				socket = s.accept();
				System.out.println("Connection accepted: " + socket);
				BufferedReader in = new BufferedReader(new InputStreamReader(
						socket.getInputStream()));
				// Output is automatically flushed
				// by PrintWriter:
				PrintWriter out = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(socket.getOutputStream())), true);
				while (true)
				{
					String str = in.readLine();
					if (str.equals("END"))
						break;
					System.out.println("Server receiveed: " + str);
					out.println("message from server");
				}
				// Always close the two sockets...
			}
		}
		finally
		{
			System.out.println("closing...");
			socket.close();
			s.close();
		}
	}
} // /:~ 