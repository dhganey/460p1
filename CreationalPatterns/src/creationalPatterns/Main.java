package creationalPatterns;
import java.util.Scanner;

public class Main
{
	public enum Country
	{
		GB, USA;
	}
	
	public enum Restaurant
	{
		DINER, EVENING_ONLY, ALL_DAY;
	}
	
	public enum Format
	{
		HTML, XML, TXT;
	}
	
	public final static String 	GREAT_BRITAIN = "GB",
								UNITED_STATES = "USA",
								DINER = "Diner",
								EVENING = "Evening",
								ALL_DAY = "All day"
								,HTML = "HTML",
								XML = "XML",
								TXT = "TXT",
								COUNTRY_OPTIONS = "(GB or USA)",
								RESTAURANT_OPTIONS = "(diner, evening, or all day)",
								FORMAT_OPTIONS = "(HTML, XML, or TXT)";
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		IReader reader;
		IMenuGenerator generator;
		IMenuFormatter formatter;
		
		Country selectedCountry = getUserCountry(scan);
		Restaurant selectedRestaurant = getUserRestaurant(scan);
		Format selectedFormat = getUserFormat(scan);
		
		if (selectedCountry == Country.GB)
		{
			reader = new XMLReader();
		}
		else
		{
			reader = new JSONReader();
		}
		
		//todo: this part makes no sense
		reader.getReader();
	}
	
	/**
	 * Returns a Country enum with the user's selected country based on string comparison
	 * @param scan System.in Scanner object
	 * @return Country enum
	 */
	private static Country getUserCountry(Scanner scan)
	{
		String input;
		Country selectedCountry = null;
		
		System.out.println("Please select your country " + COUNTRY_OPTIONS + ": ");
	
		do
		{
			input = scan.next();
			if (input.equalsIgnoreCase(GREAT_BRITAIN))
			{
				selectedCountry = Country.GB;
			}
			else if (input.equalsIgnoreCase(UNITED_STATES))
			{
				selectedCountry = Country.USA;
			}
			else
			{
				System.out.println("Please enter your country again " + COUNTRY_OPTIONS + ": ");
			}
		} while (selectedCountry == null);
		
		return selectedCountry;
	}
	
	/**
	 * Returns a Restaurant enum with the user's selected country based on string comparison
	 * @param scan System.in Scanner object
	 * @return Restaurant enum
	 */
	private static Restaurant getUserRestaurant(Scanner scan)
	{
		String input;
		Restaurant selectedRestaurant = null;
		
		System.out.println("Please select your restaurant " + RESTAURANT_OPTIONS + ": ");
		
		do
		{
			input = scan.next();
			if (input.equalsIgnoreCase(DINER))
			{
				selectedRestaurant = Restaurant.DINER;
			}
			else if (input.contains(EVENING))
			{
				selectedRestaurant = Restaurant.EVENING_ONLY;
			}
			else if (input.equalsIgnoreCase(ALL_DAY))
			{
				selectedRestaurant = Restaurant.DINER;
			}
			else
			{
				System.out.println("Please select your restaurant again " + RESTAURANT_OPTIONS + ": ");
			}
		} while (selectedRestaurant == null);
		
		return selectedRestaurant;
	}
	
	/**
	 * Returns a Format enum with the user's selected format based on string comparison
	 * @param scan System.in Scanner object
	 * @return Format enum
	 */
	private static Format getUserFormat(Scanner scan)
	{
		String input;
		Format selectedFormat = null;
		
		System.out.println("Please select your menu format " + FORMAT_OPTIONS + ": ");
		do
		{
			input = scan.next();
			if (input.equalsIgnoreCase(HTML))
			{
				selectedFormat = Format.HTML;
			}
			else if (input.equalsIgnoreCase(XML))
			{
				selectedFormat = Format.XML;
			}
			else if (input.equalsIgnoreCase(TXT))
			{
				selectedFormat = Format.TXT;
			}
			else
			{
				System.out.println("Please enter your format again " + FORMAT_OPTIONS + ": ");
			}
		} while (selectedFormat == null);
		
		return selectedFormat;
	}
}