package creationalPatterns;

public class USAXMLEveningOnlyRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public USAXMLEveningOnlyRestaurant()
	{
		//TODO
	}
	
	public FileReader getReader()
	{
		reader = new JSONReader();
		return reader;
	}
	
	public MenuGenerator getMenuGenerator()
	{
		generator = new MenuGenerator(Country.US, RestaurantType.EVENING_ONLY);
		return generator;
	}

	public MenuFormatter getMenuFormatter()
	{
		formatter = new XMLMenuFormatter();
		return formatter;
	}
}
