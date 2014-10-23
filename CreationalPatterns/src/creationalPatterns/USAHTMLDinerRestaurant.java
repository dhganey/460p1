package creationalPatterns;

public class USAHTMLDinerRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public USAHTMLDinerRestaurant()
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
		generator = new MenuGenerator(Country.US, RestaurantType.DINER);
		return generator;
	}

	public MenuFormatter getMenuFormatter()
	{
		formatter = new HTMLMenuFormatter();
		return formatter;
	}
}
