package design.model.builder;

public abstract class Builder
{
	Appearance appearance;
	Clothing clothing;
	public abstract void buildClothing(String character,String sex);
	public abstract void buildAppearance(String character,String sex);
	public abstract Role getRole(String character, String sex);
}
