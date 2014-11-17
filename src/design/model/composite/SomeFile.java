package design.model.composite;

public class SomeFile extends Component
{

	public String name ;
	public SomeFile(String name)
	{
		this.name = name;
	}
	@Override
	public void operation()
	{
		System.out.println(this.name + "做了某些操作！");
	}
	@Override
	public void  printStruct(int level)
	{
		for(int i = 0; i<level; i++)
		{
			System.out.print("	");
		}
		System.out.println(this.name);
	}
	
}
