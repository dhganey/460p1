package creationalPatterns;

public interface IRestaurant
{
	public FileReader getReader();
	
	public MenuGenerator getMenuGenerator();
	
	public MenuFormatter getMenuFormatter();
}
