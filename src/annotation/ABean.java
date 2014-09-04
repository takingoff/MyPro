package annotation;

public class ABean
{
	
	@RequestAnnotation(name="newName")
	private String name;
	
	@RequestAnnotation(dateString=true)
	private String date;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDate()
	{
		return date;
	}

	public void setDate(String date)
	{
		this.date = date;
	}
	
	
	
}
