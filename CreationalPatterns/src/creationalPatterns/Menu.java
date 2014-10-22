package creationalPatterns;

import java.util.ArrayList;

public class Menu
{
	private ArrayList<MenuItem> menuItems;

	/**
	 * Constructor just inits list
	 */
	public Menu()
	{
		this.menuItems = new ArrayList<MenuItem>();
	}
	
	public void add(MenuItem m)
	{
		this.menuItems.add(m);
	}
}
