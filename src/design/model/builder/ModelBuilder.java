package design.model.builder;
public class ModelBuilder
{
	public static void main(String[] args)
	{
		Builder builder = new ConcreteBuilder();
		Role role1 = builder.getRole("��", "��");
		System.out.println("������һ����ɫ:" + role1.apperance.appearance + 
				"," + role1.clothing.clothing);
		
		Role role2 =  builder.getRole("ľ", "Ů");
		System.out.println("������һ����ɫ:" + role2.apperance.appearance +
				"," + role2.clothing.clothing);
		
	}
	
}
