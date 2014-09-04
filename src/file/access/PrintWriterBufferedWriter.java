package file.access;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintWriterBufferedWriter
{
	public static void main(String[] args)
	{
		PrintWriter pw = new PrintWriter(System.out, true);
		pw.write("this is write by printWriter");
		pw.println();

		pw.write("second line");
		pw.println();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				System.out));
		try
		{
			bw.write("this is write by BufferedWriter");
			bw.flush();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
		
}
