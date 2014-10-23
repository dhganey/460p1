package creationalPatterns;

public class USATXTAllDayRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public USATXTAllDayRestaurant()
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
		formatter = new TXTMenuFormatter();
		return formatter;
	}
}
