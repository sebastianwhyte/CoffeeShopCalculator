package user_interface;


import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import model.Invoice;

/*
 * The class containing the Invoice View for the Invoice Calculator application
 * 
 * @author Sebastian Whyte <whyte.sebastian14@gmail.com>
 * @version 1.00
 * @date 03/23/2022
 *
 */


public class InvoiceView extends View
{
	// Instance variables
	private Invoice invoice;
	private TextField dripTextField; 
	private TextField mochaTextField;
	private TextField sconesTextField;
	private TextField sandwichTextField;
	private TextField totalBillTextField;
	private ComboBox<String> salesTaxComboBox;
	private Button calculateButton;
	private Button backButton; 
	private MessageView statusLog;
	

	//------------------------------------------------------------- 
	
	public InvoiceView(Invoice invoice) 
	{

		this.invoice = invoice;
		
		// Create a container for the contents 
		 VBox container = new VBox(10); 
		 container.setPadding(new Insets(15,5,5,5));

		// Create our GUI components, add them to this panel 
		 container.getChildren().add(createTitle()); 
		 container.getChildren().add(createFormContent());
		 
		// Error message area 
		 getChildren().add(container);
		 
		 populateFields();		
	}
	
	
	//-------------------------------------------------------------
	
	/* Creates a container for the title
	 * @return node for the container
	 */
	private Node createTitle()
	{
		// Hbox that holds the title
		HBox container = new HBox(); 
		container.setAlignment(Pos.CENTER);
		
		Text titleText = new Text(" Invoice Calculator "); 
		titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20)); 
		titleText.setWrappingWidth(300); 
		titleText.setTextAlignment(TextAlignment.CENTER); 
		titleText.setFill(Color.DARKGREEN); 
		container.getChildren().add(titleText);
		
		return container;
	}
	
	
	//-------------------------------------------------------------
	
	/* Creates the main form content
	 * @return vbox containing the content of the main form
	 */
	private VBox createFormContent()
	{
		VBox vbox = new VBox(10);
		
		// Create a grid layout
		GridPane grid = new GridPane(); 
		grid.setAlignment(Pos.CENTER); 
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		// Create labels and text fields for the menu 
		Text dripCoffeeLabel = new Text ("Drip Coffee: ");
		dripCoffeeLabel.setWrappingWidth(150); 
		dripCoffeeLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(dripCoffeeLabel, 0, 0);
		
		
		dripTextField = new TextField();
		dripTextField.setMinSize(100, 20);
		grid.add(dripTextField, 1, 0);
		
		
		Text mochaLatteLabel = new Text("Mocha Latte: "); 
		mochaLatteLabel.setWrappingWidth(150); 
		mochaLatteLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(mochaLatteLabel, 0, 1);
		
		
		mochaTextField = new TextField(); 
		mochaTextField.setMinSize(100, 20); 
		grid.add(mochaTextField, 1, 1);
		
		
		Text sconesLabel = new Text("Scones: "); 
		sconesLabel.setWrappingWidth(150); 
		sconesLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(sconesLabel, 0, 2);
		
		
		sconesTextField = new TextField();
		sconesTextField.setMinSize(100, 20); 
		grid.add(sconesTextField, 1, 2);
		
		
		Text sandwichLabel = new Text("Sandwich: "); 
		sandwichLabel.setWrappingWidth(150); 
		sandwichLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(sandwichLabel, 0, 3);
		
		
		sandwichTextField = new TextField(); 
		grid.add(sandwichTextField, 1, 3);
		
		
		Text salesTaxLabel = new Text("Sales Tax: "); 
		salesTaxLabel.setWrappingWidth(150); 
		salesTaxLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(salesTaxLabel, 0, 4);
			
		
		salesTaxComboBox = new ComboBox<String>(); 
		grid.add(salesTaxComboBox, 1, 4);
		
		
		Text totalBillLabel = new Text("Total Bill: "); 
		totalBillLabel.setWrappingWidth(150); 
		totalBillLabel.setTextAlignment(TextAlignment.RIGHT); 
		grid.add(totalBillLabel, 0, 5);
		
		
		totalBillTextField = new TextField(); 
		grid.add(totalBillTextField, 1, 5);
		
		
		// Create calculate button & add event handler to it
		calculateButton = new Button("Calculate"); 
		calculateButton.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				processAction(e);
			} 
		});
		
		
		// Create back button & add event handler to it
		backButton = new Button("Back"); 
		backButton.setOnAction(new EventHandler<ActionEvent>() 
		{	@Override
			public void handle(ActionEvent e) 
			{
				try
				{
					invoice.cancelTransaction();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
			} 
		});
		
		
		// Create hbox container to hold the buttons
		HBox buttonContainer = new HBox(100); 
		buttonContainer.setAlignment(Pos.CENTER); 
		buttonContainer.getChildren().add(calculateButton); 
		buttonContainer.getChildren().add(backButton);
		
		
		vbox.getChildren().add(grid); 
		vbox.getChildren().add(buttonContainer);
		
		return vbox;
	}
	
	//-------------------------------------------------------------
	
	/* Creates a status log that displays an error messages to the user
	 * @param message to display to user 
	 * @return status log
	 */
	private MessageView createStatusLog(String initialMessage)
	{
		statusLog = new MessageView(initialMessage);
	    return statusLog;
	}
	
	//-------------------------------------------------------------
	
	// Reset/Populate the fields
	public void populateFields()
	{
		salesTaxComboBox.getItems().add("3.0"); 
		salesTaxComboBox.getItems().add("3.25"); 
		salesTaxComboBox.getItems().add("3.50"); 
		salesTaxComboBox.getItems().add("3.75"); 
		salesTaxComboBox.getItems().add("4.0"); 
		salesTaxComboBox.getItems().add("4.25"); 
		salesTaxComboBox.getItems().add("4.50");
		salesTaxComboBox.getItems().add("4.75");
		salesTaxComboBox.getItems().add("5.0");
		salesTaxComboBox.getItems().add("5.25");
		salesTaxComboBox.getItems().add("5.50");
		salesTaxComboBox.getItems().add("5.75");
		salesTaxComboBox.getItems().add("6.0");
		salesTaxComboBox.getItems().add("6.25");
		salesTaxComboBox.getItems().add("6.50");
		salesTaxComboBox.getItems().add("6.75");
		salesTaxComboBox.getItems().add("7.0");
		salesTaxComboBox.getItems().add("7.25");
		salesTaxComboBox.getItems().add("7.50");
		salesTaxComboBox.getItems().add("7.75");
		salesTaxComboBox.getItems().add("8.0");
		salesTaxComboBox.getItems().add("8.25");
		salesTaxComboBox.getItems().add("8.50");
		salesTaxComboBox.getItems().add("8.75");
		salesTaxComboBox.getItems().add("9.0");
		
		
		salesTaxComboBox.setValue( salesTaxComboBox.getItems().get(0));
		
		// Set the default values as an empty string
		dripTextField.setText("");
		mochaTextField.setText("");
		sconesTextField.setText("");
		sandwichTextField.setText("");
	}
	
	
	//-------------------------------------------------------------
	
	// Processes events generated from the GUI components	
	public void processAction(Event event)
	{
		
		// Get the values from the TextFields
		String dripValue = dripTextField.getText();
		String mochaValue = mochaTextField.getText();
		String sconesValue = sconesTextField.getText();
		String sandwichValue = sandwichTextField.getText();
		String salesTaxValue = salesTaxComboBox.getValue();
	
		
		// Check if the user leaves the TextFields empty
		if (dripValue == null || dripValue.length() == 0)
		{
			dripValue = "0.00";
		}
		if (mochaValue == null || mochaValue.length() == 0)
		{
			mochaValue = "0.00";
		}
		if (sconesValue == null || sconesValue.length() == 0)
		{
			sconesValue = "0.00";
		}
		if (sandwichValue == null || sandwichValue.length() == 0)
		{
			sandwichValue = "0.00";
		}
		
		
		processInvoice(dripValue, mochaValue, sconesValue, sandwichValue, salesTaxValue);
		
	}
	
	
	//----------------------------------------------------------
	
	/* Process the data selected and entered by user.
	 * Action is to pass this info on to the Invoice (Model) object by 
	 * calling the appropriate method on the Invoice object.
	 */
	private void processInvoice(String dripValue, String mochaValue, String sconesValue, String sandwichValue, String salesTaxValue) 
	{
		Properties props = new Properties(); 
		props.setProperty("Drip Coffee", dripValue); 
		props.setProperty("Mocha Latte", mochaValue); 
		props.setProperty("Scones", sconesValue); 
		props.setProperty("Sandwich", sandwichValue); 
		props.setProperty("Sales Tax", salesTaxValue);
		invoice.processInvoice(props);
	}
		
	
	//----------------------------------------------------------
	
	/* Displays error message to the user
	 * @param message to display
	 */
	public void displayErrorMessage(String message)
	{
		statusLog.displayErrorMessage(message); 
	}
	
	
	//----------------------------------------------------------
	
	// Clears the error message from the status log
	public void clearErrorMessage()
	{
		statusLog.clearErrorMessage();
	}
	
	
	// ---------------------------------------------------------
	
	/* Updates the state of the total bill cost
	 * @param key and value 
	 * 
	 */
	public void updateState(String key, String value)
	{
		totalBillTextField.setText(value);
	}
	
	
}
