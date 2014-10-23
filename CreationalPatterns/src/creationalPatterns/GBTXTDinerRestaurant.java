package creationalPatterns;

public class GBTXTDinerRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public GBTXTDinerRestaurant()
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
		formatter = new TXTMenuFormatter();
		return formatter;
	}
}
