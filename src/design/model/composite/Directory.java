package design.model.composite;

import java.util.ArrayList;

public class Directory extends Component
{

	public String name ;
	public ArrayList<Component> list;
	public Directory(String name)
	{
		this.name = name;
		list = new ArrayList<Component>();
	}

	@Override
	public void add(Component component)
	{
		this.list.add(component);
	}

	@Override
	public void remove(int i)
	{
		this.list.remove(i);
	}

	@Override
	public Component getChild(int i)
	{
		return list.get(i);
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
		for(Component c:this.list)
		{
			c.printStruct(level +1);
		}
	}

}
