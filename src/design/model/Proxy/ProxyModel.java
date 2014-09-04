package design.model.Proxy;

public class ProxyModel
{
	public static void main(String[] arg)
	{
		ProxyTrade pt = new ProxyTrade();
		Child ch = new Child();
		
		ch.askHowMuch(pt, "±ù¼¤Áè1");
		ch.Buy(pt, "±ù¼¤Áè1");
	}
}
