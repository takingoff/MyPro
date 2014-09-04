package design.model.composite;

public class ModelComposite
{
	public static void main(String[] args)
	{
		Directory dir  = new Directory("rootDirectory");
		SomeFile image = new SomeFile("图片1");
		SomeFile txt = new SomeFile("txt文件1");
		Directory dir2 = new Directory("mydirectory");
		SomeFile image2 = new SomeFile("图片2");
		SomeFile txt2 = new SomeFile("txt文件2");
		
		dir2.add(image2);
		dir2.add(txt2);
		
		dir.add(image);
		dir.add(txt);
		dir.add(dir2);
		
		dir.operation();
		image.operation();
		
		dir.printStruct(0);
		
	}

}
