package user_interface;

import javafx.stage.Stage;

/*
 * Holds the main stage
 * 
 * @author Sebastian Whyte
 * @version 03/24/2022
 *
 */

public class MainStageContainer 
{
	// Instance variables
	// private static Stage myStage = null;
	private static Stage stage;
	
	// ----------------------------------------------------
	
	// Getter method for stage
	public static Stage getStage()
	{
		return stage;
	}
	
	
	// ----------------------------------------------------
	
	// Setter method for stage
	public static void setStage(Stage s, String title)
	{
		stage = s;
		stage.setTitle(title);
		stage.setResizable(false);
	}
}
