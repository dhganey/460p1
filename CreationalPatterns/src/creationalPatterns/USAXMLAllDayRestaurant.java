package creationalPatterns;

public class USAXMLAllDayRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public USAXMLAllDayRestaurant()
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
		generator = new MenuGenerator(Country.US, RestaurantType.ALL_DAY);
		return generator;
	}

	public MenuFormatter getMenuFormatter()
	{
		formatter = new XMLMenuFormatter();
		return formatter;
	}
}
