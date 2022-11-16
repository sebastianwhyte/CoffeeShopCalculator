package user_interface;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/*
 * This class provides a means of placing the main stage of the application * in the center of the screen, top left corner, bottom right
 * corner, top right corner, bottom left corner
 * 
 * @author Sebastian Whyte
 * @version 03/22/2022
 *
 */


public class WindowPosition 
{
	// Get the bounds of the window
	private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

	
	//---------------------------------------------------------------
	
	
	/* Used to place the stage in the center of the screen
	*
	*  @param s Stage to place at the center of the screen
	*/ 
	
	public static void placeCenter(Stage stage)
	{
		if (stage != null)
		{
			stage.centerOnScreen();
		} 
	}
	
	
	//--------------------------------------------------------------
	
	
	public static void placeTopLeft(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX()); stage.setY(primaryScreenBounds.getMinY());
		} 
	}
	
	
	//--------------------------------------------------------------
		
	public static void placeTopRight(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - stage.getWidth());
			stage.setY(primaryScreenBounds.getMinY());
		} 	

	}
	
	
	//--------------------------------------------------------------
	
	public static void placeBottomLeft(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX()); 
			stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - stage.getHeight());
		} 	
	}
	
	
	//--------------------------------------------------------------
	
	public static void placeBottomRight(Stage stage)
	{
		if (stage != null)
		{
			stage.setX(primaryScreenBounds.getMinX() + primaryScreenBounds.getWidth() - stage.getWidth()); 
			stage.setY(primaryScreenBounds.getMinY() + primaryScreenBounds.getHeight() - stage.getHeight());
		}
	}


}
