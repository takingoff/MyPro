/**
 *	2015年12月19日 下午5:45:36
 *	tangli
 */
package arithmetic.express;

import java.io.File;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author tangli 2015年12月19日下午5:45:36
 */
public class ScriptExecutor
{

	/*SUN提供的JDK6中有一个命令行工具——jrunscript，你可以在<JDK6_Home>/bin下面找到这个工具，jrunscript是一个脚本语言的解释程序，
	它独立于脚本语言，但默认是用JavaScript，我们可以用jrunscript来测试自己写的脚本*/
	
	public static void main(String[] args) throws Exception
	{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		testScriptVariables(engine);// 演示如何暴露Java对象为脚本语言的全局变量
		testInvokeScriptMethod(engine);// 演示如何在Java中调用脚本语言的方法
		testScriptInterface(engine);// 演示脚本语言如何实现Java的接口
//		testUsingJDKClasses(engine);// 演示脚本语言如何使用JDK平台下的类
	}

	public static void testScriptVariables(ScriptEngine engine) throws Exception
	{
		String path = new File("").getCanonicalPath();
		File file = new File(path+"/print.txt");
		engine.put("f", file);
		engine.eval("println('Total Space:'+f.getTotalSpace())");
		System.out.println(file.getTotalSpace());
	}

	public static void testInvokeScriptMethod(ScriptEngine engine) throws Exception
	{
		String script = "function hello(name) { return 'Hello,' + name;}";
		engine.eval(script);
		Invocable inv = (Invocable) engine;
		String res = (String) inv.invokeFunction("hello", "Scripting");
		System.out.println("res:" + res);
	}

	public static void testScriptInterface(ScriptEngine engine) throws ScriptException
	{
		String script = "var obj = new Object(); obj.run = function() { println('run method called'); }";
		engine.eval(script);
		Object obj = engine.get("obj");
		Invocable inv = (Invocable) engine;
		Runnable r = inv.getInterface(obj, Runnable.class);
		Thread th = new Thread(r);
		th.start();
	}

	public static void testUsingJDKClasses(ScriptEngine engine) throws Exception
	{
		// Packages是脚本语言里的一个全局变量,专用于访问JDK的package
		String js = "function doSwing(t){var f=new Packages.javax.swing.JFrame(t);f.setSize(400,300);f.setVisible(true);}";
		engine.eval(js);
		Invocable inv = (Invocable) engine;
		inv.invokeFunction("doSwing", "Scripting Swing");
	}

}
