package creationalPatterns;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HTMLMenuFormatter extends MenuFormatter implements Definitions
{
	private String filepath;
	
	public HTMLMenuFormatter()
	{
		filepath = "";
	}
	
	public String format(Menu m)
	{
		//First, sort the Menu by category since that's how XML does the output
		//Inspired by http://stackoverflow.com/questions/18441846/how-sort-a-arraylist-in-java
		List<MenuItem> menuItems = m.getMenuItemList();
		Collections.sort(menuItems, new Comparator<MenuItem>() {
				@Override
				public int compare(MenuItem m1, MenuItem m2)
				{
					return m1.getCategory().ordinal() - (m2.getCategory().ordinal());
				}
			});
		
		Writer writer = null;
		try
		{
			File tempFile = new File(HTML_OUT);
			filepath = tempFile.getAbsolutePath();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(HTML_OUT), "utf-8"));
			writer.write("<HTML>\n");
			writer.write("<HEAD>\n");
			writer.write("<TITLE>Menu</TITLE>\n");
			writer.write("<BODY>\n");
			writer.write("    <CENTER>Menu</CENTER>");
			
			FoodCategory curCat = null;
			for (int i = 0; i < menuItems.size(); i++)
			{
				MenuItem cur = menuItems.get(i);
				if (curCat != cur.getCategory()) //new section
				{
					curCat = cur.getCategory();
					writer.write("    <h1>" + curCat.toString().toUpperCase() + "</h1>\n\n");
					writer.write("    <UL>\n");
				}
				
				//print a menu item
				writer.write("        <LI>\n");
				writer.write(cur.getDescription() + "\n\n");
				writer.write(cur.getName() + (cur.getCountry() == Country.GB ? "GBP" : "USD") + cur.getPrice() + "\n");
				writer.write(cur.getDescription() + "\n\n");
				
				int nextIndex = i+1;
				if (nextIndex >= menuItems.size() ||				  //if we're at the end OR
					menuItems.get(nextIndex).getCategory() != curCat) //if we're about to transition to a new category
				{
					writer.write("    </FoodItemCategory>\n");
				}
			}
		}
		catch (UnsupportedEncodingException | FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch (Exception e)
			{
				//TODO
			}
		}
		
		return filepath;
	}
}
