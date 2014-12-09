package applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Event;
import java.awt.Graphics;

public class MyApplet extends Applet
{
	private static final long serialVersionUID = 1L;
	Button b1 = new Button("Button 1"), b2 = new Button("Button 2");

	public void init()
	{
		add(b1);
		add(b2);
	}

 	
//	public boolean action(Event evt, Object arg)
//	{
//		if (evt.target.equals(b1))
//			getAppletContext().showStatus("Button 1");
//		else if (evt.target.equals(b2))
//			getAppletContext().showStatus("Button 2");
//		// Let the base class handle it:
//		else
//			return super.action(evt, arg);
//		return true; // We've handled it here
//	}

	public boolean handleEvent(Event evt)
	{
		if (evt.target.equals(b1))
			getAppletContext().showStatus("Button 1");
		else if (evt.target.equals(b2))
			getAppletContext().showStatus("Button 2");
		// Let the base class handle it:
		else
			return true;
		return true; // We've handled it here
	}

	public void paint(Graphics g)
	{
		g.drawString("First applet", 10, 10);
		g.draw3DRect(0, 0, 100, 20, true);
	}
} // /:~ 