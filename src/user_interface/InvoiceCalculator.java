package user_interface;

import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Invoice;


/* The class containing the main program for the coffee shop application 
 * 
 * @author Sebastian Whyte
 * @version 11/12/2022
 */

public class InvoiceCalculator extends Application
{
	private Invoice invoice;
	private Stage mainStage;
	
	
	// -----------------------------------------------------------------

	/**
	 * @param args
	 */
	
	public static void main(String[] args) 
	{
		launch(args);

	}

	
	// ------------------------------------------------------------------
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		System.out.println("BrewHaHa Invoice Version 1.00"); 
		System.out.println("Copyright ©2022 Sebastian Whyte");
		
		// Create the top-level container (main stage)
		MainStageContainer.setStage(primaryStage, "BrewHaHa Invoice Version 1.00"); 
		mainStage = MainStageContainer.getStage();
		
		// Enable the GUI to be closed by using the top right X
		mainStage.setOnCloseRequest(new EventHandler <javafx.stage.WindowEvent>() 
		{
			@Override
			public void handle(javafx.stage.WindowEvent event) 
			{
				System.exit(0); 
			}
		});
		
		
	
        invoice = new Invoice();
        
		
		// Place the stage in the center of the screen
		WindowPosition.placeCenter(mainStage);
		
		
		mainStage.show();
	}

}
