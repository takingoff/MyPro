package design.model.Proxy;

public class Child
{
	
	public void Buy(ProxyTrade pt,String ic)
	{
		System.out.println("С�� ��������һ��" + ic);
		pt.trade(ic);
	}
	public void askHowMuch(ProxyTrade pt,String ic)
	{
		System.out.println("ѧ��ѯ��"+ic+"�ļ۸�" + "�����̻ش��ǣ�" + pt.howMuch(ic));
	}
}
