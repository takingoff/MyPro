package design.model.Proxy;

public class ProxyModel
{
	public static void main(String[] arg)
	{
		ProxyTrade pt = new ProxyTrade();
		Child ch = new Child();
		
		ch.askHowMuch(pt, "������1");
		ch.Buy(pt, "������1");
	}
}
