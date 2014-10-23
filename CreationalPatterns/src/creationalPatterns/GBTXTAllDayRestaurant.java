package creationalPatterns;

public class GBTXTAllDayRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public GBTXTAllDayRestaurant()
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
		formatter = new TXTMenuFormatter();
		return formatter;
	}
}
