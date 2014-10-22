package creationalPatterns;

import java.io.File;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

//https://code.google.com/p/json-simple/
//http://www.tutorialspoint.com/json/json_java_example.htm

public class JSONReader extends FileReader implements Definitions
{
	public Menu Read()
	{
		JSONParser parser = new JSONParser();
		
		String path = new File(JSON_FILE_NAME).getAbsolutePath();
		File jsonFile = new File(path);
		
		try
		{
			Object obj = parser.parse(jsonFile.toString());
			JSONArray array = (JSONArray)obj;
			
			for (int i = 0; i < array.size(); i++)
			{
				JSONObject js = (JSONObject) array.get(i);
			}
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO:
		
		return new Menu();
	}
}