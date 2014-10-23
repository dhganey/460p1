package creationalPatterns;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class RestaurantFactory
{
	private static String[][][] typeArray = new String[2][3][3];
	private static Restaurant retVal;
	
	public static Restaurant getRestaurantInstance(Country c, Format f, RestaurantType t)
	{
		//prepare an array of all possible class names
		typeArray[0][0][0] = "GBHTMLDinerRestaurant";
		typeArray[0][0][1] = "GBHTMLEveningOnlyRestaurant";
		typeArray[0][0][2] = "GBHTMLAllDayRestaurant";
		typeArray[0][1][0] = "GBXMLDinerRestaurant";
		typeArray[0][1][1] = "GBXMLEveningOnlyRestaurant";
		typeArray[0][1][2] = "GBXMLAllDayRestaurant";
		typeArray[0][2][0] = "GBTXTDinerRestaurant";
		typeArray[0][2][1] = "GBTXTAllDayRestaurant";
		typeArray[0][2][2] = "GBTXTEveningOnlyRestaurant";
		typeArray[1][0][0] = "USAHTMLDinerRestaurant";
		typeArray[1][0][1] = "USAHTMLEveningOnlyRestaurant";
		typeArray[1][0][2] = "USAHTMLAllDayRestaurant";
		typeArray[1][1][0] = "USAXMLDinerRestaurant";
		typeArray[1][1][1] = "USAXMLEveningOnlyRestaurant";
		typeArray[1][1][2] = "USAXMLAllDayRestaurant";
		typeArray[1][2][0] = "USATXTDinerRestaurant";
		typeArray[1][2][1] = "USATXTAllDayRestaurant";
		typeArray[1][2][2] = "USATXTEveningOnlyRestaurant";
		
		//now, return the appropriate one
		//inspired by http://stackoverflow.com/questions/9886266/is-there-a-way-to-instantiate-a-class-by-name-in-java
		try
		{
			//get the class name and instantiate it
			String className = "creationalPatterns." + typeArray[c.ordinal()][f.ordinal()][t.ordinal()]; //append package name
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
