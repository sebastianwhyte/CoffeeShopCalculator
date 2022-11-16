/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javafx.scene.Scene;
import javafx.stage.Stage;
import user_interface.InvoiceView;
import user_interface.LoginView;
import user_interface.MainStageContainer;
import user_interface.WindowPosition;
import user_interface.View;


/**
 * @author Sebastian Whyte
 * @version 11/11/2022
 */

public class Invoice 
{
	
	private Map<String, String> accounts;
	private Stage stage;
	private View loginView;
	private View invoiceView;
	private Scene currentScene;
	private String loginErrorMessage = "";
	private String transactionErrorMessage = "";
	
	
	public Invoice()
	{
		accounts = new HashMap<>();
		
		// Get the main stage
		stage = MainStageContainer.getStage();
		
		createAndShowLoginView();
	}
	
	// ----------------------------------------------------------------------
	
	/* Processes the username and password from the user at the login screen.
	 * @param username/password that were passed into the props
	 */
	public void processLogin(Properties props)
	{
		String username = props.getProperty("ID");
		String passwordSent = props.getProperty("Password");
		
		
		// If username is not in map, then add it and map it to the given password 
		if (!accounts.containsKey(username))
		{
			loginView.updateState("", "Account not found. Creating user account...Login again.");
			
			accounts.put(username, passwordSent);
		}
		// Else, get the username from the map and check if the given password matches the real/correct password
		else if (passwordSent.equals(accounts.get(username)))
		{
			createAndShowInvoiceView();
		}
		else
		{
			loginView.updateState("", "Login failed");
		}
	}
	
	
	
	//----------------------------------------------------------
	
	/*
	 * Processes the invoice
	 * @param properties object
	 */
		
	public void processInvoice(Properties props)
	{
		
		String dripCoffeeString = props.getProperty("Drip Coffee"); 
		String mochaLatteString = props.getProperty("Mocha Latte"); 
		String sconesString = props.getProperty("Scones");
		String sandwichString = props.getProperty("Sandwich");
		String salesTaxString = props.getProperty("Sales Tax");
				
		
		double dripCost = Double.parseDouble(dripCoffeeString); 
		double mochaCost = Double.parseDouble(mochaLatteString); 
		double sconesCost = Double.parseDouble(sconesString);
		double sandwichCost = Double.parseDouble(sandwichString);
		double salesTax = Double.parseDouble(salesTaxString);
				
		
		double totalBill = 0;
				
		
		double preTaxSum = dripCost + mochaCost + sconesCost + sandwichCost;
				
		
		double totalTax = preTaxSum * (salesTax/100);
		
		
		totalBill = preTaxSum + totalTax;
				
				
		String formatTotalBill = String.format("%.2f", totalBill);
				
		invoiceView.updateState("Total Bill", formatTotalBill);
			
	}
		
				
	//---------------------------------------------------------- 
		
	// If the user clicks the 'Back' button, go back to the login screen 
	public void cancelTransaction()
	{
		createAndShowLoginView();
	}
			
			
	//---------------------------------------------------------- 
	
	// Builds the scene for the invoice
	private void createAndShowInvoiceView()
	{
		// Create the new view
		invoiceView = new InvoiceView(this); 
		currentScene = new Scene(invoiceView);
		
		// Make the view visible by installing it into the stage 
		swapToView(currentScene);
	}
	
	
	//------------------------------------------------------------ 
	
	// Builds the scene for the login screen
	private void createAndShowLoginView()
	{
		
		loginView = new LoginView(this);
		
		// Create a scene of the new view 
		currentScene = new Scene(loginView);
		
		swapToView(currentScene);
	}
			
			
	//--------------------------------------------------------------- 
	
	/* Changes the current scene
	 * @param the scene you wish to swap to
	 */
	public void swapToView(Scene scene)
	{
	    if (scene == null)
	    {
	    	System.out.println("Invoice.swapToView(): Missing view for display"); 
	    	return;
	    }
	      
		
		stage.setScene(scene);
		
		stage.sizeToScene();
		
		WindowPosition.placeCenter(stage);
	}
	
}
