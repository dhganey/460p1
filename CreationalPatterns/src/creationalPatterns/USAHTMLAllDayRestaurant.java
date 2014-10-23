package creationalPatterns;

public class USAHTMLAllDayRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public USAHTMLAllDayRestaurant()
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
		formatter = new HTMLMenuFormatter();
		return formatter;
	}
}
