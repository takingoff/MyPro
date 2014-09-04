package design.model.builder;
public class ModelBuilder
{
	public static void main(String[] args)
	{
		Builder builder = new ConcreteBuilder();
		Role role1 = builder.getRole("金", "男");
		System.out.println("创建了一个角色:" + role1.apperance.appearance + 
				"," + role1.clothing.clothing);
		
		Role role2 =  builder.getRole("木", "女");
		System.out.println("创建了一个角色:" + role2.apperance.appearance +
				"," + role2.clothing.clothing);
		
	}
	
}
