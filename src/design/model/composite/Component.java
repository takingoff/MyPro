package design.model.composite;

public abstract class Component
{
	public void add(Component component) 
	{
	}

	public void remove(int i) 
	{
	}

	public Component getChild(int i) 
	{
		throw new UnsupportedOperationException();
	}

	public abstract void operation(); 
	
	public abstract void  printStruct(int level);

}
