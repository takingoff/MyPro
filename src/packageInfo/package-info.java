/**
 * 
 */
/**
 * @author LiTang
 *
 */

@javax.xml.bind.annotation.XmlSchema(namespace = "http://lianlian.soap.core.risetek.com/")
package packageInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

class PkgConst
{
	static final String PACAKGE_CONST = "ABC";
}

class myAnnotation
{
	@Target(ElementType.PACKAGE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface PkgAnnotation
	{
		
	}
}