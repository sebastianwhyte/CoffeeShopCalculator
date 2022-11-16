package user_interface;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * @author Sebastian Whyte
 * @version 03/23/2022
 *
 */

public class MessageView extends Text
{
	public MessageView(String initialMessage)
	{
		super(initialMessage);
		setFont(Font.font("Helvetica", FontWeight.BOLD, 16));
		setFill(Color.BLUE);
		setTextAlignment(TextAlignment.LEFT);		
		
	}
	
	//---------------------------------------------------------- 
	
	/* Displays the message that is passed in
	 *  @param message to display
	 */
	
	public void displayMessage(String message)
	{
		// Display the passed text in blue 
		setFill(Color.BLUE); 
		setText(message);
	}

	
	//----------------------------------------------------------
	
	/* Display error message (errors are typically shown in red) 
	 * @param message to display 
	 */
	
	public void displayErrorMessage(String message)
	{
		// display the passed text in red 
		setFill(Color.RED); 
		setText(message);
	}
	

	//---------------------------------------------------------- 
	
	// Clears the error message
	public void clearErrorMessage()
	{
		setText(" ");
	} 	
	
}
