package creationalPatterns;
import java.util.Scanner;

/**
 * Driver class. Requests user input, then triggers menu generation
 * @author David Ganey
 */
public class Main implements Definitions
{
	public static void main(String[] args)
	{
		//Take input from user
		Scanner scan = new Scanner(System.in);
		
		Country selectedCountry = getUserCountry(scan);
		RestaurantType selectedRestaurant = getUserRestaurant(scan);
		Format selectedFormat = getUserFormat(scan);
		
		//Now use factory method to get some type of file reader
		//Client (main) does not care about reader type, just wants a reader
		ReaderFactory rf = new ReaderFactory();
		FileReader myReader = rf.getReader(selectedCountry);
		
		Menu menu = myReader.Read();
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
			else if (input.equalsIgnoreCase(UNITED_STATES) || (input.equalsIgnoreCase(UNITED_STATES2)))
			{
				selectedCountry = Country.US;
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
	private static RestaurantType getUserRestaurant(Scanner scan)
	{
		String input;
		RestaurantType selectedRestaurant = null;
		
		System.out.println("Please select your restaurant " + RESTAURANT_OPTIONS + ": ");
		
		do
		{
			input = scan.next();
			if (input.equalsIgnoreCase(DINER))
			{
				selectedRestaurant = RestaurantType.DINER;
			}
			else if (input.contains(EVENING))
			{
				selectedRestaurant = RestaurantType.EVENING_ONLY;
			}
			else if (input.equalsIgnoreCase(ALL_DAY))
			{
				selectedRestaurant = RestaurantType.DINER;
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