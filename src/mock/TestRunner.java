/**
 *	2015年4月24日 下午2:33:55
 *	TangLi
 */
package mock;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author TangLi 2015年4月24日下午2:33:55
 */
public class TestRunner
{
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(MathApplicationTester.class);

		for (Failure failure : result.getFailures())
		{
			System.out.println(failure.toString());
		}

		System.out.println(result.wasSuccessful());
	}

	static interface CalculatorService
	{
		public double add(double input1, double input2);

		public double subtract(double input1, double input2);

		public double multiply(double input1, double input2);

		public double divide(double input1, double input2);
	}

	static class MathApplication
	{
		private CalculatorService calcService;

		public void setCalculatorService(CalculatorService calcService)
		{
			this.calcService = calcService;
		}

		public double add(double input1, double input2)
		{
			return calcService.add(input1, input2);
		}

		public double subtract(double input1, double input2)
		{
			return calcService.subtract(input1, input2);
		}

		public double multiply(double input1, double input2)
		{
			return calcService.multiply(input1, input2);
		}

		public double divide(double input1, double input2)
		{
			return calcService.divide(input1, input2);
		}
	}

	

}