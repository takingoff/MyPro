package design.model.singleton;

class StudentNumber
{
	private static StudentNumber instance = null;
	public  static StudentNumber getInstance()
	{
		if(instance == null)
		{
			instance = new StudentNumber();
			return instance;
		}
		return instance;
	}
	private String number;
	private Object someProperty;
	
	public String getNumber()
	{
		return number;
	}
	public void setNumber(String number)
	{
		this.number = number;
	}
	public Object getSomeProperty()
	{
		return someProperty;
	}
	public void setSomeProperty(Object someProperty)
	{
		this.someProperty = someProperty;
	}

}

public class ModelSingleton
{
	
	public static void main(String[] args)
	{
		StudentNumber sn = StudentNumber.getInstance();
		sn.setNumber("201005070204");
		System.out.println(sn.getNumber());
			
		
	}
}
