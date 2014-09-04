package atm;



public class AtmManager
{
	
	static public void main(String[] arg)
	{
		FrameATM frame = FrameATM.getInstance();
		frame.setVisible(true);
		frame.uiWelcome();
	}
	
	
}
