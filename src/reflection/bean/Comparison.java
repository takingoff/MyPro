/**
 *	2015年9月11日 下午11:31:18
 *	tangli
 */
package reflection.bean;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//字段
/**
 * @author tangli 2015年9月11日下午11:31:18
 */
public class Comparison
{

	private String Field;
	// 名称
	private String FieldName;
	// 字段类型
	private Class<?> FieldType;
	// 之前
	private Object Before;
	// 之后
	private Object After;

	public String getField()
	{
		return Field;
	}

	public void setField(String field)
	{
		Field = field;
	}

	public String getFieldName()
	{
		return FieldName;
	}

	public void setFieldName(String fieldName)
	{
		FieldName = fieldName;
	}

	public Class<?> getFieldType()
	{
		return FieldType;
	}

	public void setFieldType(Class<?> fieldType)
	{
		FieldType = fieldType;
	}

	public Object getBefore()
	{
		return Before;
	}

	public void setBefore(Object before)
	{
		Before = before;
	}

	public Object getAfter()
	{
		return After;
	}

	public void setAfter(Object after)
	{
		After = after;
	}

	public boolean isdifferent()
	{
		if (Before == null && After == null)
			return true;
		if (Before == null || After == null)
			return false;
		if (FieldType.isAssignableFrom(Integer.class))
		{
			if ((Integer) Before == (Integer) After)
				return true;
		}
		else if (FieldType.isAssignableFrom(Boolean.class))
		{
			if ((Boolean) Before == (Boolean) After)
				return true;
		}
		else if (FieldType.isAssignableFrom(Long.class))
		{
			if ((Long) Before == (Long) After)
				return true;
		}
		else if (FieldType.isAssignableFrom(java.util.Date.class) || FieldType.isAssignableFrom(Date.class))
		{
			if (((java.util.Date) Before).compareTo((java.util.Date) After) == 0)
				return true;
		}
		else if (FieldType.isAssignableFrom(Timestamp.class))
		{
			if (((Timestamp) Before).compareTo((Timestamp) After) == 0)
				return true;
		}
		else
		{
			if (((String) Before).equals((String) After))
				return true;
		}
		return false;
	}

	public String getBeforeStirng()
	{
		return objtostr(Before);
	}

	public String getAfterString()
	{
		return objtostr(After);
	}

	private String objtostr(Object obj)
	{
		if (obj == null)
			obj = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		if (FieldType.isAssignableFrom(Integer.class) || FieldType.isAssignableFrom(Long.class))
		{
			return (String) obj;
		}
		else if (FieldType.isAssignableFrom(Boolean.class))
		{
			return (((Boolean) obj) ? "1" : "0");
		}
		else if (FieldType.isAssignableFrom(java.util.Date.class) || FieldType.isAssignableFrom(Date.class))
		{
			return formatter.format((java.util.Date) obj);
		}
		else if (FieldType.isAssignableFrom(Timestamp.class))
		{
			return formatter.format((Timestamp) obj);
		}
		else
		{
			return (String) obj;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	}

}