package creationalPatterns;

public class GBXMLDinerRestaurant extends Restaurant implements IReader, IMenuGenerator
{
	public GBXMLDinerRestaurant()
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
	

}
