package design.model.Proxy;

public class ProxyTrade implements IManufacturerTrade
{
	ManufacturerTrade mft;
	double makeMoney = 0.5;
	public ProxyTrade()
	{
		mft = new ManufacturerTrade();
	}
	@Override
	public double howMuch(String ic)
	{
		return mft.howMuch(ic) + this.makeMoney;
	}
	@Override
	public void trade(String ic)
	{
		this.mft.trade(ic);
	}
	
}
