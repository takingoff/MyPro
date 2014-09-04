package packageInfo;

import java.lang.annotation.Annotation;

public class AccessPackage
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 可以通过I/O操作或配置项获得包名
		String pkgName = "packageInfo";
		Package pkg = Package.getPackage(pkgName);
		// 获得包上的注解
		Annotation[] annotations = pkg.getAnnotations();
		// 遍历注解数组
		for (Annotation an : annotations)
		{
			if (an instanceof javax.xml.bind.annotation.XmlSchema)
			{
				System.out.println("Hi,I'm the PkgAnnotation");
			}
		}

	}

}
