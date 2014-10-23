package creationalPatterns;

public class USAXMLDinerRestaurant extends Restaurant
{
	public USAXMLDinerRestaurant()
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
}
