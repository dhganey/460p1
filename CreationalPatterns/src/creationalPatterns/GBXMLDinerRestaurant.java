package creationalPatterns;

public class GBXMLDinerRestaurant extends Restaurant
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
	
	//TODO two more get methods
}
