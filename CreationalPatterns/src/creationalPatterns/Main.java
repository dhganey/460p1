package creationalPatterns;
import java.util.Scanner;

import javax.swing.JApplet;

/**
 * Driver class. Requests user input, then triggers menu generation
 * @author David Ganey
 */
public class Main extends JApplet implements Definitions
{
	public void init()
	{
		InputPanel ip = new InputPanel();
		this.getContentPane().add(ip);
		this.setSize(350, 300);
	}
}