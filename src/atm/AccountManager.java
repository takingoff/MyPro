package atm;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.jdom2.Comment;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class AccountManager
{

	/*
	 * public static void domParse() { File file = new File(""); String filePath
	 * = "file:\\" + file.getAbsolutePath() + "\\src\\atm\\Accounts.xml";
	 * System.out.println(filePath); DocumentBuilderFactory factory =
	 * DocumentBuilderFactory.newInstance(); Document document = null;
	 * DocumentBuilder builder = null; try { builder =
	 * factory.newDocumentBuilder(); document = builder.parse(filePath);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } NodeList accountsList =
	 * document.getChildNodes(); for (int k = 0; k < accountsList.getLength();
	 * k++) { System.out.println("锟斤拷锟斤拷 一锟斤拷 Accounts"); Node a_accounts =
	 * accountsList.item(k); NodeList accountList = a_accounts.getChildNodes();
	 * 
	 * for (int i = 0; i < accountList.getLength(); i++) {
	 * System.out.println("锟斤拷锟斤拷 一锟斤拷 Account"); Node a_account =
	 * accountList.item(i); NodeList accountMetaList =
	 * a_account.getChildNodes(); for (int j = 0; j <
	 * accountMetaList.getLength(); j++) {
	 * 
	 * Node a_accountMeta = accountMetaList.item(j);
	 * System.out.println("锟斤拷锟斤拷一锟斤拷锟斤拷锟斤拷"+a_accountMeta.getTextContent()); }
	 * 
	 * } } }
	 */

	static String  filePath =  new File("").getAbsolutePath() + "\\src\\atm\\Accounts.xml";
	static public void jdomCreateXml()
	{

		Document document = new Document();

		Element accounts = new Element("Accounts");

		document.addContent(accounts);

		Comment comment = new Comment("This is the comment");
		accounts.addContent(comment);

		
		Element account = new Element("Account");
		account.setAttribute("failTime", "1212");
		
		
		Element element = new Element("money");
		element.setText("100000");
		account.addContent(element);
		
		element = new Element("password");
		element.setText("111");
		account.addContent(element);
		
		element = new Element("failTime");
		element.setText("0");
		account.addContent(element);

		accounts.addContent(account);		
		Format format = Format.getPrettyFormat();
		format.setIndent("	");
		format.setEncoding("UTF-8");
		XMLOutputter out = new XMLOutputter(format);

		try
		{
			out.output(document, new FileOutputStream(filePath));
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
	static public void  jdomParseXml()
	{
		@SuppressWarnings("deprecation")
		SAXBuilder builder=new SAXBuilder(false);
		try
		{
			Document doc = builder.build("file:\\"+filePath);
			Element root = doc.getRootElement();
			List<Element> accounts = root.getChildren("Account");
			
			for(int i = 0;i< accounts.size();i++)
			{
				Element account = (Element) accounts.get(i);
				System.out.println(account.getChild("password").getText());
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/**
	 * @param id
	 * @return
	 */
	static public Account findAAccount(String id)
	{
		@SuppressWarnings("deprecation")
		SAXBuilder builder=new SAXBuilder(false);
		try
		{
			Document doc = builder.build("file:\\"+filePath);
			Element root = doc.getRootElement();
			List<Element> accounts = root.getChildren("Account");
			
			Account result = new Account();
			for(int i = 0;i< accounts.size();i++)
			{
				Element account = (Element) accounts.get(i);
				if(account.getAttributeValue("id").equals(id))
				{
					result.cardId = account.getAttributeValue("id");
					result.failTime = Integer.parseInt(account.getChildText("failTime"));
					result.money = Integer.parseInt(account.getChildText("money"));
					result.password = account.getChildText("password");
					return result;
				}
			}
			return null;
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * @param account
	 */
	static public void modifyAccount(Account account)
	{
		
		@SuppressWarnings("deprecation")
		SAXBuilder builder=new SAXBuilder(false);
		Document doc = null;
		try
		{
			doc = builder.build("file:\\"+filePath);
			Element root = doc.getRootElement();
			List<Element> accounts = root.getChildren("Account");
			
			for(int i = 0;i< accounts.size();i++)
			{
				Element element = (Element) accounts.get(i);
				if(element.getAttributeValue("id").equals(account.cardId))
				{
					element.getChild("password").setText(account.password);
					element.getChild("failTime").setText(Integer.toString(account.failTime));
					element.getChild("money").setText(Integer.toString(account.money));
					break;
				}
			}
			Format format = Format.getPrettyFormat();
			format.setIndent("	");
			format.setEncoding("UTF-8");
			XMLOutputter out = new XMLOutputter(format);

			try
			{
				out.output(doc, new FileOutputStream(filePath));
			}
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
