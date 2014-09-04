package design.model.Proxy;


public class ManufacturerTrade implements IManufacturerTrade
{
	static int sellNum = 0;
	public ManufacturerTrade()
	{
		System.out.println("���������˼�����裡���ǵļ۸���2.5");
	}
	
	public void trade(String ic)
	{
		sellNum ++;
		System.out.println("�۳�һ��:" + ic +
				" Ŀǰ�ܹ��۳�����Ϊ��" + ManufacturerTrade.sellNum);
	}
	
	public double howMuch(String ic)
	{
		return 2.5;
	}
	
}
