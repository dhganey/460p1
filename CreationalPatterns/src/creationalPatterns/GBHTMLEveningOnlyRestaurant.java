package creationalPatterns;

public class GBHTMLEveningOnlyRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public GBHTMLEveningOnlyRestaurant()
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
		generator = new MenuGenerator(Country.GB, RestaurantType.EVENING_ONLY);
		return generator;
	}

	public MenuFormatter getMenuFormatter()
	{
		formatter = new HTMLMenuFormatter();
		return formatter;
	}
}