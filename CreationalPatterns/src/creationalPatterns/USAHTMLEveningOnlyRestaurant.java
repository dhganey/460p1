package creationalPatterns;

public class USAHTMLEveningOnlyRestaurant extends Restaurant implements IReader, IMenuGenerator, IMenuFormatter
{
	public USAHTMLEveningOnlyRestaurant()
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
		formatter = new HTMLMenuFormatter();
		return formatter;
	}
}
