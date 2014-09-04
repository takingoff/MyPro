package annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import annotation.MyAnnotation.Review;
import annotation.MyAnnotation.Reviews;

public class AnnotationTest
{

	public static void main(String[] args) throws Exception
	{

//		getAnnotationFromClassHead();
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("newName","myName");
		map.put("date", Long.toString(new Date().getTime()));
		
		ABean bean = convertRequestToBean(map,ABean.class);
		
		System.out.println(bean.getDate());
		System.out.println(bean.getName());

	}

	public static void getAnnotationFromClassHead()
	{

		AnnotatedElement target = HaveAnnotationClass.class; // 选择某个类作为目标

		Reviews annotation = target.getAnnotation(Reviews.class); // 从目标中获取
																	// Reviews
																	// 类型的annotation

		Review[] views = annotation.value();

		for (Review view : views)
		{
			System.out.println(view.reviewer());
			System.out.println(view.comment());
			System.out.println(view.grade());
			System.out.println();
		}

	}

	/**
	 * 通过request获取对应的对象
	 * map 模拟 request 请求
	 * @param <T>
	 * @param request
	 * @param clazz
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> T convertRequestToBean(Map<String,Object> request, Class<T> clazz)
			throws InstantiationException, IllegalAccessException
	{
		Object object = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		
		
		for (Field field : fields)
		{
			field.setAccessible(true);
			String requestName = field.getName();
			
			//获取变量上的annotation
			RequestAnnotation requestAnnotation = field.getAnnotation(RequestAnnotation.class);
			
			
			boolean isDateString = false;
			if (requestAnnotation != null)
			{
				//获得annotation指定的两个属性
				if (!requestAnnotation.name().trim().equals("")) 
					//如果 annotation为字段指定了名字那么使用指定的名字检索 map 而不是 字段的名字。
					requestName = requestAnnotation.name();
				isDateString = requestAnnotation.dateString();
			}
			
			Class<?> clazzf = field.getType();
			//如果变量为字符串类型。
			if (clazzf == String.class)
			{
				///如果annotation指定该变量为 日期，那么转换为相应的格式保存。
				if (isDateString)
				{
					String dateStr = (String) request.get(requestName);
					if (dateStr != null)
					{
						field.set(object, DateFormat.getDateInstance(DateFormat.DEFAULT).format(new Date(Long.valueOf(dateStr))));
					}
				}
				else
				{
					field.set(object,(String) request.get(requestName));
				}
			}
			
			else if (clazzf == Integer.class)
				field.set(object, (Integer) request.get(requestName));
			else if (clazzf == Long.class)
				field.set(object,(Long) request.get(requestName));
			else
			{
				
				////other type...
			}
			
		}
		return (T) object;
	}

}

@Reviews(
{
		@Review(grade = Review.Grade.SATISFACTORY, reviewer = "Review's reviewer"),
		@Review(grade = Review.Grade.EXCELLENT, reviewer = "Review's reviewer", comment = "this is a review comment") })
class HaveAnnotationClass
{

}
