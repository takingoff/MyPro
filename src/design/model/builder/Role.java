package design.model.builder;

public class Role
{
	public Appearance apperance;
	public Clothing clothing;
	public Appearance getApperance()
	{
		return apperance;
	}
	public void setApperance(Appearance apperance)
	{
		this.apperance = apperance;
	}
	public Clothing getClothing()
	{
		return clothing;
	}
	public void setClothing(Clothing clothing)
	{
		this.clothing = clothing;
	}
	Role()
	{
		
	}
}
