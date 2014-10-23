package creationalPatterns;

import java.io.File;
import java.io.FileNotFoundException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class XMLReader extends FileReader implements Definitions
{
	private final static int nodeOffset = 0;
	
	public Menu read()
	{
		Menu menu = new Menu();
		
		try
		{
			//this code inspired by: http://www.mkyong.com/java/how-to-read-xml-file-in-java-dom-parser/
			String path = new File(XML_FILE_NAME).getAbsolutePath();
			File fXmlFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			
			NodeList nodes = doc.getElementsByTagName(XML_NODE_NAME);
			
			for (int i = 0; i < nodes.getLength(); i++)
			{
				Node n = nodes.item(i);
				
				if (n.getNodeType() == Node.ELEMENT_NODE)
				{
					Element e = (Element) n;
					String country = e.getAttribute(COUNTRY);
					String id = e.getElementsByTagName(ID).item(nodeOffset).getTextContent();
					String name = e.getElementsByTagName(NAME).item(nodeOffset).getTextContent();
					String description = e.getElementsByTagName(DESCRIPTION).item(nodeOffset).getTextContent();
					String category = e.getElementsByTagName(CATEGORY).item(nodeOffset).getTextContent();
					String price = e.getElementsByTagName(PRICE).item(nodeOffset).getTextContent();
					
					menu.add(new MenuItem(country, Integer.parseInt(id), name, description, category, Double.parseDouble(price)));
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Can't find the file in XMLReader");
		}
		catch (Exception e)
		{
			System.out.println("Undefined exception in XMLReader");
		}
		finally
		{
			return menu;
		}
	}
}