package file.access;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyBufferedReader
{

	public FileInputStream fis =  null;
	public InputStreamReader isr = null;
	public BufferedReader br = null;
	
	public MyBufferedReader(String inputPathFile) throws FileNotFoundException
	{
		fis = new FileInputStream(inputPathFile);
		isr = new InputStreamReader(fis);
		br = new BufferedReader(isr);
	}
	
	public void close() throws IOException
	{
		if(br != null)
			br.close();
		if(isr!= null)
			isr.close();
		if(fis!= null)
			fis.close();
	}
	
}
