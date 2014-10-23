package creationalPatterns;

public class GBHTMLDinerRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public GBHTMLDinerRestaurant()
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
		generator = new MenuGenerator(Country.GB, RestaurantType.DINER);
		return generator;
	}

	public MenuFormatter getMenuFormatter()
	{
		formatter = new HTMLMenuFormatter();
		return formatter;
	}
}
