package creationalPatterns;

public class GBXMLAllDayRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public GBXMLAllDayRestaurant()
	{
		//TODO
	}
	
	public FileReader getReader()
	{
		reader = new XMLReader();
		return reader;
	}

	public MenuGenerator getMenuGenerator()
	{
		generator = new MenuGenerator(Country.GB, RestaurantType.ALL_DAY);
		return generator;
	}

	public MenuFormatter getMenuFormatter()
	{
		formatter = new XMLMenuFormatter();
		return formatter;
	}
}
