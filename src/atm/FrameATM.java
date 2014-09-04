package atm;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class FrameATM extends javax.swing.JFrame {

	{
	try 
	{
		javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
	} catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	private JPanel keyBoardPanel;
	private JButton button_two;
	private JButton button_ok;
	private JButton button_B4;
	private JLabel label_b4;
	private JButton button_cardOK;
	private JTextField textField_input;
	private JTextPane textPane_information;
	private JButton button_zero;
	private JLabel label_b1;
	private JLabel label_b2;
	private JLabel label_b3;
	private JButton button_B3;
	private JButton button_B2;
	private JLabel label_save;
	private JLabel label_withdraw;
	private JTextField textField_withdraw;
	private JTextField textField_save;
	private JButton button_B1;
	private JPanel panel_display;
	private JTextField textField_card;
	private JLabel label_reciept;
	private JTextField textField_reciept;
	private JButton button_cancel;
	private JButton button_nine;
	private JButton button_eight;
	private JButton button_seven;
	private JButton button_six;
	private JButton button_five;
	private JButton button_four;
	private JButton button_three;
	private JButton button_one;

	public int currentUI;
	
	private Account currentAccount;

	private int bankBalance = 10000;
	
	public int getBankBalance()
	{
		return bankBalance;
	}
	
	public void setBankBalance(int bankBalance)
	{
		this.bankBalance = bankBalance;
	}
	
	private static FrameATM instance = new FrameATM();
	public static FrameATM getInstance()
	{
		return instance;
	}
	private FrameATM() {
		super();
		initGUI();
		
		this.setResizable(false);
	}
	

	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.0, 0.0, 0.0, 0.0, 0.0};
			thisLayout.rowHeights = new int[] {31, 35, 54, 39, 60, 50, 36, 7};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.0};
			thisLayout.columnWidths = new int[] {322, 73, 138, 7};
			getContentPane().setLayout(thisLayout);
			getContentPane().setBackground(new java.awt.Color(192,192,192));
			{
				keyBoardPanel = new JPanel();
				GridLayout keyBoardPanelLayout = new GridLayout(4, 3);
				keyBoardPanelLayout.setColumns(3);
				keyBoardPanelLayout.setHgap(5);
				keyBoardPanelLayout.setVgap(5);
				keyBoardPanelLayout.setRows(4);
				getContentPane().add(keyBoardPanel, new GridBagConstraints(2, 3, 3, 4, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				keyBoardPanel.setLayout(keyBoardPanelLayout);
				{
					button_one = new JButton();
					keyBoardPanel.add(button_one);
					button_one.setText("1");
					
				}
				{
					button_two = new JButton();
					keyBoardPanel.add(button_two);
					button_two.setText("2");
				}
				{
					button_three = new JButton();
					keyBoardPanel.add(button_three);
					button_three.setText("3");
				}
				{
					button_four = new JButton();
					keyBoardPanel.add(button_four);
					button_four.setText("4");
				}
				{
					button_five = new JButton();
					keyBoardPanel.add(button_five);
					button_five.setText("5");
				}
				{
					button_six = new JButton();
					keyBoardPanel.add(button_six);
					button_six.setText("6");
				}
				{
					button_seven = new JButton();
					keyBoardPanel.add(button_seven);
					button_seven.setText("7");
				}
				{
					button_eight = new JButton();
					keyBoardPanel.add(button_eight);
					button_eight.setText("8");
				}
				{
					button_nine = new JButton();
					keyBoardPanel.add(button_nine);
					button_nine.setText("9");
				}
				{
					button_ok = new JButton();
					keyBoardPanel.add(button_ok);
					button_ok.setText("\u786e\u5b9a");
				}
				{
					button_zero = new JButton();
					keyBoardPanel.add(button_zero);
					button_zero.setText("0");
				}
				{
					button_cancel = new JButton();
					keyBoardPanel.add(button_cancel);
					button_cancel.setText("\u53d6\u6d88");
				}
			}
			{
				textField_reciept = new JTextField();
				getContentPane().add(textField_reciept, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				textField_reciept.setEditable(false);
			}
			{
				label_reciept = new JLabel();
				getContentPane().add(label_reciept, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				label_reciept.setText("\u6536\u636e\u7a97\u53e3");
			}
			{
				textField_card = new JTextField();
				getContentPane().add(textField_card, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			}
			{
				panel_display = new JPanel();
				GridBagLayout panel_displayLayout = new GridBagLayout();
				panel_displayLayout.rowWeights = new double[] {0.0, 0.0, 0.1, 0.1};
				panel_displayLayout.rowHeights = new int[] {58, 62, 7, 7};
				panel_displayLayout.columnWeights = new double[] {0.0, 0.0};
				panel_displayLayout.columnWidths = new int[] {249, 76};
				getContentPane().add(panel_display, new GridBagConstraints(0, 0, 1, 6, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
				panel_display.setLayout(panel_displayLayout);
				panel_display.setBackground(new java.awt.Color(255,255,255));
				{
					label_b3 = new JLabel();
					label_b3.setForeground(new Color(223,0,0));
					panel_display.add(label_b3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					label_b2 = new JLabel();
					label_b2.setForeground(new Color(223,0,0));
					panel_display.add(label_b2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					label_b1 = new JLabel();
					label_b1.setForeground(new Color(223,0,0));
					panel_display.add(label_b1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					textPane_information = new JTextPane();
					textPane_information.setForeground(new Color(0,0,233));
					panel_display.add(textPane_information, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
					textPane_information.setEditable(false);
				}
				{
					textField_input = new JTextField(8);
					panel_display.add(textField_input, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
				{
					label_b4 = new JLabel();
					label_b4.setForeground(new Color(223,0,0));
					panel_display.add(label_b4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.SOUTH, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				}
			}
			{
				textField_save = new JTextField();
				getContentPane().add(textField_save, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				textField_save.setEditable(false);
			}
			{
				textField_withdraw = new JTextField();
				getContentPane().add(textField_withdraw, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				textField_withdraw.setEditable(false);
			}
			{
				label_withdraw = new JLabel();
				getContentPane().add(label_withdraw, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				label_withdraw.setText("\u51fa\u949e\u7a97\u53e3");
			}
			{
				label_save = new JLabel();
				getContentPane().add(label_save, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				label_save.setText("\u5b58\u94b1\u7a97\u53e3");
			}
			{
				button_B1 = new JButton();
				getContentPane().add(button_B1, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				button_B1.setText("B1");
			}
			{
				button_B2 = new JButton();
				getContentPane().add(button_B2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				button_B2.setText("B2");
			}
			{
				button_B3 = new JButton();
				getContentPane().add(button_B3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				button_B3.setText("B3");
			}
			{
				button_cardOK = new JButton();
				getContentPane().add(button_cardOK, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				button_cardOK.setText("插入卡");
				button_cardOK.addActionListener(new ActionListener()
				{
					
					@Override
					public void actionPerformed(ActionEvent e)
					{
						switch(currentUI)
						{
						case StaticClass.UI_WELCOME:
							if(findAccount(textField_card.getText()))
							{
								if(currentAccount.failTime == 3)
									uiStopLogin();
								else
									uiInputPassword();
							}
							else
								uiErrorCard();
							break;
						case StaticClass.UI_ERRORCARD:
						case StaticClass.UI_TAKECARDTIP:
							uiWelcome();
							break;
						}
					}
				});
				
			}
			{
				button_B4 = new JButton();
				getContentPane().add(button_B4, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
				button_B4.setText("B4");
			}
			
			button_one.addActionListener(new ActionKeyboardButton(this, 1));
			button_two.addActionListener(new ActionKeyboardButton(this, 2));
			button_three.addActionListener(new ActionKeyboardButton(this,3));
			button_four.addActionListener(new ActionKeyboardButton(this, 4));
			button_five.addActionListener(new ActionKeyboardButton(this,5));
			button_six.addActionListener(new ActionKeyboardButton(this, 6));
			button_seven.addActionListener(new ActionKeyboardButton(this,7));
			button_eight.addActionListener(new ActionKeyboardButton(this,8));
			button_nine.addActionListener(new ActionKeyboardButton(this,9));
			button_zero.addActionListener(new ActionKeyboardButton(this,0));
			
			button_cancel.addActionListener(new ActionKeyboardButton(this, 11));
			button_ok.addActionListener(new ActionKeyboardButton(this, 10));
			
			button_B1.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					switch(currentUI)
					{
					case StaticClass.UI_WITHRDRAWSUCCESS:
					case StaticClass.UI_WITHRDRAW:
					case StaticClass.UI_TAKEBILLETTIP:
					case StaticClass.UI_SAVERESULT:
					case StaticClass.UI_SAVEMONEY:
					case StaticClass.UI_REMAINBALANCE:
						uiBusinessDeal();
						break;
						
					case StaticClass.UI_WITHDRAWFAIL:
						uiWithdraw();
						break;
					
					case StaticClass.UI_STOPLOGINWARNING:
						uiWelcome();
						break;
				
					case StaticClass.UI_INPUTPASSWORD:
					case StaticClass.UI_BUSINESSDEAL:
					case StaticClass.UI_A_PASSWORDERROR:
						uiTakeCardTip();
						break;
					}
				}
			});
			
			button_B2.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					switch(currentUI)
					{
					case StaticClass.UI_A_PASSWORDERROR:
						uiInputPassword();
						break;
					case StaticClass.UI_BUSINESSDEAL:
						uiSaveMoney();
						break;
						
					case StaticClass.UI_WITHRDRAWSUCCESS:
					case StaticClass.UI_REMAINBALANCE:
						uiTakeBilletTip();
						break;
					case StaticClass.UI_SAVEMONEY:
						int saveMoney = 0;
						try
						{
							saveMoney = Integer.parseInt(textField_save.getText());
						}catch(Exception e2)
						{
							uiSaveResult(0);
						}
						uiSaveResult(saveMoney);
						saveSuccese(saveMoney);
						break;
					}
				}
			});
			
			button_B3.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(currentUI == StaticClass.UI_BUSINESSDEAL)
					{
						uiRemainBalance();
					}
				}
			});
			button_B4.addActionListener(new ActionListener()
			{
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					if(currentUI == StaticClass.UI_BUSINESSDEAL)
					{
						uiWithdraw();
					}
				}
			});
			pack();
			this.setSize(645, 319);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

	private class ActionKeyboardButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if((atm.currentUI ==StaticClass.UI_INPUTPASSWORD)||(atm.currentUI ==StaticClass.UI_WITHRDRAW))
			{
				if(num == 10)
				{
					if(atm.currentUI ==StaticClass.UI_INPUTPASSWORD)
					{
						if(atm.currentAccount.password.equals(atm.textField_input.getText()))
						{
							atm.uiBusinessDeal();
							loginSuccess();
						}
						else
						{
							atm.uiAPasswordError();
							atm.aLoginFail();
						}
					}
					else
					{
						String s = atm.textField_input.getText();
						if(s.length() == 0)return;
						int money = 0;
						try
						{
							money = Integer.parseInt(s);
						}
						catch (Exception e1)
						{
							atm.uiWithdrawFail("处理异常。请重试");
							return;
						}
						if(money%100 != 0)
						{
							atm.uiWithdrawFail("必须取100倍数的金额");
							return;
						}
						if(atm.currentAccount.money < money)
						{
							atm.uiWithdrawFail("您卡余额不足");
							return;
						}
						if(money>atm.bankBalance)
						{
							atm.uiWithdrawFail("对不起提款机金额不足，请选择较低的金额");
							return;
						}
						atm.uiWithdrawSuccess(money);
						atm.withdrawSuccess(money);
					}
					
				}
				else if(num == 11)
				{
					String s = atm.textField_input.getText();
					if(s.length() == 0)return;
					s = s.substring(0,s.length()-1);
					atm.textField_input.setText(s);
				}
				else
					atm.textField_input.setText(atm.textField_input.getText() + num);
			}
			else 
				return;
		}
		private FrameATM atm = null;
		private int num ;
		public ActionKeyboardButton(FrameATM atm,int num)
		{
			this.atm = atm;
			this.num = num;
		}
	}

	
	private void withdrawSuccess(int money)
	{
		this.currentAccount.money -= money;
		this.bankBalance -= money;
		AccountManager.modifyAccount(currentAccount);
		
	}
	
	
	private void saveSuccese(int money)
	{
		this.currentAccount.money += money;
		this.bankBalance += money;
		AccountManager.modifyAccount(currentAccount);
	}
	private void aLoginFail()
	{
		this.currentAccount.failTime += 1;
		if(this.currentAccount.failTime == 3)
			this.uiStopLogin();
		AccountManager.modifyAccount(currentAccount);
	}
	private void loginSuccess()
	{
		this.currentAccount.failTime = 0;
		AccountManager.modifyAccount(currentAccount);
	}
	
	private boolean findAccount(String id)
	{
		currentAccount = AccountManager.findAAccount(id);
		if(currentAccount == null)
			return false;
		else 
			return true;
	}
	
	
	
	private void uiInitial()
	{
		this.label_b1.setVisible(false);
		this.label_b2.setVisible(false);
		this.label_b3.setVisible(false);
		this.label_b4.setVisible(false);
		
		this.textField_input.setVisible(false);
		
		this.textField_save.setText("");
		this.textField_withdraw.setText("");
		this.textField_card.setText("");
		this.textField_input.setText("");
		this.textField_reciept.setText("");
		
		
		this.textField_card.setEditable(false);
		this.textField_save.setEditable(false);
		this.textField_withdraw.setEditable(false);
		this.textField_reciept.setEditable(false);
		
		
	}
	
	public void  uiWelcome()
	{
		uiInitial();
		if(this.getBankBalance()<100)
		{
			this.textPane_information.setText("抱歉因为资金问题暂停服务！");
		}
		else
		{
			this.textField_card.setEditable(true);
			this.textPane_information.setText("欢迎登录atm 自动提款机\n" +
					"其插入有效的银行卡");
		}
		currentUI =  StaticClass.UI_WELCOME;
	}
	
	public void   uiErrorCard()
	{
		uiInitial();
		this.textPane_information.setText("对不起你没有插入有效的卡\n" +
				"可以先办理一张卡\n" +
				"请取走你的卡");
		this.textField_card.setText("退卡");
		
		currentUI =  StaticClass.UI_ERRORCARD;
	}
	public void uiInputPassword()
	{
		uiInitial();
		this.textField_input.setVisible(true);
		this.textPane_information.setText("请在下面输入密码");
		this.label_b1.setText("退卡");
		this.label_b1.setVisible(true);
		this.textField_input.setEditable(false);
		currentUI = StaticClass.UI_INPUTPASSWORD;
		
	}
	public void uiAPasswordError()
	{
		uiInitial();
		this.textPane_information.setText("对不起密码错误请重新输入密码" +
				"\n如果忘记密码请及时到柜台咨询" +
				"\n密码连续三次错误将暂停本卡业务！");
		this.label_b1.setText("退卡");
		this.label_b1.setVisible(true);
		this.label_b2.setText("重新输入");
		this.label_b2.setVisible(true);
		currentUI = StaticClass.UI_A_PASSWORDERROR;
	}
	
	public void uiStopLogin()
	{
		uiInitial();
		this.textPane_information.setText("很抱歉你的密码错误已经累计三次" +
				"\n不能再次登录" +
				"\n请你到柜台办理处理手续");
		this.label_b1.setText("确定");
		this.label_b1.setVisible(true);
		currentUI = StaticClass.UI_STOPLOGINWARNING;
	}
	
	
	public void uiTakeCardTip()
	{
		uiInitial();
		this.textPane_information.setText("你已经取消登录" +
				"\n请取走你的卡" +
				"\n欢迎下次光临！");
		this.textField_card.setText("卡弹出");
		currentUI = StaticClass.UI_TAKECARDTIP;
	}
	
	public void uiBusinessDeal()
	{
		uiInitial();
		this.textPane_information.setText("请选择相应业务");
		this.label_b1.setText("退卡");
		this.label_b1.setVisible(true);
		this.label_b2.setText("存款");
		this.label_b2.setVisible(true);
		this.label_b3.setText("查询余额");
		this.label_b3.setVisible(true);
		this.label_b4.setText("取款");
		this.label_b4.setVisible(true);
		currentUI = StaticClass.UI_BUSINESSDEAL;
	}
	
	public void uiRemainBalance()
	{
		uiInitial();
		this.textPane_information.setText("你的余额为：" + this.currentAccount.money+
				"\n需要为你打印吗？");
		this.label_b1.setText("否");
		this.label_b1.setVisible(true);
		this.label_b2.setText("是");
		this.label_b2.setVisible(true);
		currentUI = StaticClass.UI_REMAINBALANCE;
	}
	
	
	public void uiTakeBilletTip()
	{
		uiInitial();
		this.textPane_information.setText("正在打印。。" +
				"\n请在凭条窗口接收");
		this.label_b1.setText("确定");
		this.label_b1.setVisible(true);
		this.textField_reciept.setText("信息条弹出");
		currentUI = StaticClass.UI_TAKEBILLETTIP;
		
	}
	
	public void uiSaveMoney()
	{
		
		uiInitial();
		this.textPane_information.setText("存款窗口已打开" +
				"\n请在存款窗口放入你要存储的金额" +
				"\n若是操作失误请选择取消");
		this.label_b1.setText("取消");
		this.label_b1.setVisible(true);
		this.label_b2.setText("确定");
		this.label_b2.setVisible(true);
		
		this.textField_save.setEditable(true);
		
		currentUI = StaticClass.UI_SAVEMONEY;
	}
	
	
	public void uiSaveResult(int money)
	{
		uiInitial();
		if(money == 0)
		{
			this.textPane_information.setText("没有存入现金");
		}
		else
		{
			this.textPane_information.setText("操作成功" +
					"\n存入金额为：" + money);
		}
		
		this.label_b1.setText("确定");
		this.label_b1.setVisible(true);
		currentUI = StaticClass.UI_SAVERESULT;
	}
	
	public void uiWithdraw()
	{
		uiInitial();
		this.textPane_information.setText("请输入提取金额");
		this.textField_input.setVisible(true);
		this.label_b1.setText("取消");
		this.label_b1.setVisible(true);
		this.textField_input.setEditable(false);
		currentUI = StaticClass.UI_WITHRDRAW;
	}
	
	public void uiWithdrawSuccess(int money)
	{
		uiInitial();
		this.textPane_information.setText("交易正在进行中。。。" +
				"\n请在出钞窗口取走你的钱" +
				"\n是否为你打印凭条？");
		this.label_b1.setText("否");
		this.label_b1.setVisible(true);
	this.label_b2.setVisible(true);
		this.label_b2.setText("是");
		this.textField_withdraw.setText("弹出金额：" + money +"");
		currentUI = StaticClass.UI_WITHRDRAWSUCCESS;
	}
	
	
	public void uiWithdrawFail(String result)
	{
		
		uiInitial();
		this.textPane_information.setText("交易不成功" +
				"\n交易信息："+result);
		this.label_b1.setText("确定");
		this.label_b1.setVisible(true);
		currentUI = StaticClass.UI_WITHDRAWFAIL;
		
	}
	
}
