package file.access;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MyBufferedWriter
{
	public FileOutputStream fos = null;
	public OutputStreamWriter osw = null;
	public BufferedWriter bw = null;
	
	public MyBufferedWriter(String outPathFile) throws FileNotFoundException
	{
		fos = new FileOutputStream(outPathFile);
		osw = new OutputStreamWriter(fos);
		bw = new BufferedWriter(osw);
	}
	
	
	public void close() throws IOException
	{
		if(bw != null)
			bw.close();
		if(osw != null)
			osw.close();
		if(fos != null)
			fos.close();
	}
	
}
