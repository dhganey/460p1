package creationalPatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RestaurantFactory
{
	private static Restaurant retVal;
	
	public static Restaurant getRestaurantInstance(Country c, Format f, RestaurantType t)
	{
		//inspired by http://stackoverflow.com/questions/9886266/is-there-a-way-to-instantiate-a-class-by-name-in-java
		try
		{
			//get the class name and instantiate it
			String className = "creationalPatterns." + c.toString() + f.toString() + t.toString() + "Restaurant"; //append package name
			Class<?> classType = Class.forName(className);
			Constructor<?> constructor = classType.getConstructor();
			Object instance = constructor.newInstance();
			retVal = (Restaurant) instance;
		}
		catch (Exception e)
		{
			retVal = new Restaurant(); //use the base class if this fails
		}
		finally
		{
			return retVal; //TODO this requires the caller to NULL CHECK WTF ARE YOU DOING
		}
	}
}
