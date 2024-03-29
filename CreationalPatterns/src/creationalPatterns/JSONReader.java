package creationalPatterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

//https://code.google.com/p/json-simple/
//http://www.tutorialspoint.com/json/json_java_example.htm

public class JSONReader extends FileReader implements Definitions
{
	public Menu read()
	{
		Menu menu = new Menu();
		
		JSONParser parser = new JSONParser();
		String path = new File(JSON_FILE_NAME).getAbsolutePath();
		//String fullFile = "[" + readFile(path, Charset.defaultCharset()) + "]";
		
		try
		{
			Object obj = parser.parse(new java.io.FileReader(path));
			
			JSONArray array = (JSONArray) ((JSONObject) obj).get("FoodItemData");
			
			for (int i = 0; i < array.size(); i++)
			{
				JSONObject cur = (JSONObject) array.get(i);
				String country = (String)cur.get("-country");
				String id = (String)cur.get("id");
				String name = (String)cur.get("name");
				String description = (String)cur.get("description");
				String category = (String)cur.get("category");
				String price = (String)cur.get("price");
				
				menu.add(new MenuItem(country, Integer.parseInt(id), name, description, category, Double.parseDouble(price)));
			}
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (FileNotFoundException e)
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
			return menu;
		}
	}
	
	/**
	 * Helper method
	 * Inspired by http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
	 * @param path
	 * @param encoding
	 * @return
	 */
	private String readFile(String path, Charset encoding)
	{
		File jsonFile = new File(path);
		byte[] encoded = null;
		try
		{
			encoded = Files.readAllBytes(Paths.get(path));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new String(encoded, encoding);
	}
}