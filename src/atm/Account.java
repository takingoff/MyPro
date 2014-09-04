package atm;

public class Account
{
	String cardId ;
	String password;
	int money;
	int failTime = 0;
	public Account(String cardId, String password, int money)
	{
		super();
		this.cardId = cardId;
		this.password = password;
		this.money = money;
	}
	public Account()
	{}
}
