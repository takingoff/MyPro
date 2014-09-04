package design.model.composite;

public class ModelComposite
{
	public static void main(String[] args)
	{
		Directory dir  = new Directory("rootDirectory");
		SomeFile image = new SomeFile("ͼƬ1");
		SomeFile txt = new SomeFile("txt�ļ�1");
		Directory dir2 = new Directory("mydirectory");
		SomeFile image2 = new SomeFile("ͼƬ2");
		SomeFile txt2 = new SomeFile("txt�ļ�2");
		
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
