package aaexplore;

import java.math.BigDecimal;

public class FloatTest
{
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
//		tFloat();
		testMathRound();
		
	}



	public static void tFloat()
	{
		
		System.out.println(0.05 + 0.01);
		System.out.println(0.05f + 0.01f);
		System.out.println(0.06);
		
		// sdf
		System.out.println(1.0 - 0.42);
		System.out.println(4.015 * 100);
		System.out.println(123.3 / 100);
		
		float f1 = 262144.00f;
		float f2 = 262144.01f;
		if (f1 == f2) {
			System.out.println("no equal");
		}
		float f3 = 26214444466232326.00f;
		System.out.println(f3);
		
		BigDecimal big1 = new BigDecimal(0.01);
		BigDecimal big2 = new BigDecimal(0.05);
		System.out.println(big1.add(big2));
		
		BigDecimal big3 = new BigDecimal("0.01");
		BigDecimal big4 = new BigDecimal("0.05");
		System.out.println(big3.add(big4));
	}
	
	
	
	public static void testMathRound()
	{
		System.out.println("负数的四舍五入是逆向的。主要表现在 -0.5上， -0.5会被舍弃而不是变为-1！");
		System.out.println(Math.round(11.4));
		System.out.println(Math.round(-11.4));

		System.out.println(Math.round(11.5));
		System.out.println(Math.round(-11.5));

		System.out.println(Math.round(11.6));
		System.out.println(Math.round(-11.6));
	}
}
