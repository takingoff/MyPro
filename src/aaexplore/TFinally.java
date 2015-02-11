package aaexplore;

public class TFinally
{

	public static void main(String[] ars)
	{
		System.out.println("asdfasds");
		try
		{
			try
			{

				throw new Exception("exception 1");
			}
			catch (Exception e)
			{
				return;
			}
			finally
			{
				System.out.println("in finally");
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			System.out.println("out finally");
		}
	}

}
