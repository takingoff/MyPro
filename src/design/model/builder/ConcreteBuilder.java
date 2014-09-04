package design.model.builder;

public class ConcreteBuilder extends Builder
{

	@Override
	public void buildClothing(String character, String sex)
	{
		this.clothing = new Clothing("����Ϊ��"+character + "�Ա�Ϊ��" +sex +"�ķ�װ");
	}

	@Override
	public void buildAppearance(String character, String sex)
	{
		this.appearance = new Appearance("����Ϊ��"+character + "�Ա�Ϊ��" +sex +"������");
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
