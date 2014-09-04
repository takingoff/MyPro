package design.model.builder;

public class ConcreteBuilder extends Builder
{

	@Override
	public void buildClothing(String character, String sex)
	{
		this.clothing = new Clothing("特征为："+character + "性别为：" +sex +"的服装");
	}

	@Override
	public void buildAppearance(String character, String sex)
	{
		this.appearance = new Appearance("特征为："+character + "性别为：" +sex +"的外形");
	}

	@Override
	public Role getRole(String character, String sex)
	{
		buildClothing(character,sex);
		buildAppearance(character,sex);
		Role role = new Role();
		role.setApperance(this.appearance);
		role.setClothing(this.clothing);
		return role;
	}
	
}
