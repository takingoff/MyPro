package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MyAnnotation
{
	/**
	 * Reviews annotation类型只有一个成员， 但是这个成员的类型是复杂的：由Review annotation组成的数组
	 */
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Reviews
	{
		Review[] value();			//Review[] 类型成员 ，名叫 value
	}

	/**
	 * Review annotation类型有3个成员： 枚举类型成员grade、   * 表示Review名称的字符串类型成员Reviewer、
	 *   * 具有默认值的字符串类型成员Comment。
	 */
	public @interface Review
	{
		// 内嵌的枚举类型 （它不是成员！只是定义了一种类型）
		public static enum Grade
		{
			EXCELLENT, SATISFACTORY, UNSATISFACTORY
		};

		// 下面的方法定义了annotation的成员
		
		Grade grade();  			//Grade 类型成员      名叫 grade

		String reviewer();			//String 类型成员   名叫 reviewer

		String comment() default "comment's default";		//带有默认值的的String 类型成员 ，名叫 cooment
	}
}
