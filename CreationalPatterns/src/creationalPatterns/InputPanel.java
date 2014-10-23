package creationalPatterns;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Takes input from the user and drives the class
 * @author David
 */
public class InputPanel extends JPanel
{
	/**
	 * UIElements
	 */
	private ButtonGroup countryButtons;
	private JRadioButton GBButton;
	private JRadioButton USAButton;
	
	private ButtonGroup outputButtons;
	private JRadioButton XMLButton;
	private JRadioButton HTMLButton;
	private JRadioButton TXTButton;
	
	private ButtonGroup typeButtons;
	private JRadioButton dinerButton;
	private JRadioButton allDayButton;
	private JRadioButton eveningOnlyButton;
	
	private JButton submitButton;
	
	/**
	 * Member variables
	 */
	private Country country;
	private Format format;
	private RestaurantType type;
	
	/**
	 * Constructor called by Main.init()
	 */
	public InputPanel()
	{
		countryButtons = new ButtonGroup();
		GBButton = new JRadioButton();
		USAButton = new JRadioButton();
		
		outputButtons = new ButtonGroup();
		XMLButton = new JRadioButton();
		HTMLButton = new JRadioButton();
		TXTButton = new JRadioButton();
		
		typeButtons = new ButtonGroup();
		dinerButton = new JRadioButton();
		allDayButton = new JRadioButton();
		eveningOnlyButton = new JRadioButton();
		
		submitButton = new JButton();
		
		GBButton.setText("Great Britain");
		USAButton.setText("United States");
		XMLButton.setText("XML");
		HTMLButton.setText("HTML");
		TXTButton.setText("TXT");
		dinerButton.setText("Diner");
		allDayButton.setText("All Day");
		eveningOnlyButton.setText("Evening Only");
		submitButton.setText("Submit");
		
		countryButtons.add(GBButton);
		countryButtons.add(USAButton);
		
		outputButtons.add(XMLButton);
		outputButtons.add(HTMLButton);
		outputButtons.add(TXTButton);
		
		typeButtons.add(dinerButton);
		typeButtons.add(allDayButton);
		typeButtons.add(eveningOnlyButton);
		
		ButtonListener listener = new ButtonListener();
		submitButton.addActionListener(listener);
		
		this.add(GBButton);
		this.add(USAButton);
		this.add(XMLButton);
		this.add(HTMLButton);
		this.add(TXTButton);
		this.add(dinerButton);
		this.add(allDayButton);
		this.add(eveningOnlyButton);
		this.add(submitButton);
	}
	
	/**
	 * Takes action when submit is pressed
	 * @author David
	 */
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			System.out.println("Submit pressed");
			
			//when the user hits Submit, first grab the input and set the members:
			if (GBButton.isSelected())
			{
				country = Country.GB;
			}
			else if (USAButton.isSelected())
			{
				country = Country.US;
			}
			else
			{
				//TODO fail
			}
			
			if (XMLButton.isSelected())
			{
				format = Format.XML;
			}
			else if (HTMLButton.isSelected())
			{
				format = Format.HTML;
			}
			else if (TXTButton.isSelected())
			{
				format = Format.TXT;
			}
			else
			{
				//TODO fail
			}
			
			if (dinerButton.isSelected())
			{
				type = RestaurantType.DINER;
			}
			else if (allDayButton.isSelected())
			{
				type = RestaurantType.ALL_DAY;
			}
			else if (eveningOnlyButton.isSelected())
			{
				type = RestaurantType.EVENING_ONLY;
			}
			else
			{
				//TODO fail
				System.out.println("Radio button failure");
			}
			
			//next, create the relevant restaurant
			//again, using an interface means we don't have to care about the specific type of restaurant
			Restaurant myRestaurant = RestaurantFactory.createRestaurant(country, format, type);
			System.out.println("Restaurant created");
			
			//TODO: figure out if these return anything
			myRestaurant.createReader();
			myRestaurant.createMenuGenerator();
			myRestaurant.createMenuFormatter();
		}
		
	}
}