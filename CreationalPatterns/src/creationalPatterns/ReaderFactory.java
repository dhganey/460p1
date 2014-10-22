package creationalPatterns;

public class ReaderFactory implements IReader
{
	public FileReader getReader(Country c)
	{
		//if country based input types change, only modification necessary is right here!
		if (c == Country.GB)
		{
			return new XMLReader();
		}
		else
		{
			return new JSONReader();
		}
	}
	
}