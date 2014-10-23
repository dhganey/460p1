package creationalPatterns;

public enum RestaurantType
{
	DINER, EVENING_ONLY, ALL_DAY;
	
	//http://stackoverflow.com/questions/9662170/java-override-valueof-and-tostring-in-enum	
	
	@Override
	public String toString()
	{
		return this.getValue();
	}
	
	private String getValue()
	{
		if (this.equals(ALL_DAY))
		{
			return "AllDay";
		}
		else if (this.equals(EVENING_ONLY))
		{
			return "EveningOnly";
		}
		else
		{
			return "Diner";
		}
	}
}
