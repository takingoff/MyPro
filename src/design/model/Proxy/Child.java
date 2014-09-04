package design.model.Proxy;

public class Child
{
	
	public void Buy(ProxyTrade pt,String ic)
	{
		System.out.println("小孩 决定买了一个" + ic);
		pt.trade(ic);
	}
	public void askHowMuch(ProxyTrade pt,String ic)
	{
		System.out.println("学生询问"+ic+"的价格：" + "零售商回答是：" + pt.howMuch(ic));
	}
}
