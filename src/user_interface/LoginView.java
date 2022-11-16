package user_interface;

import java.util.Properties;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.*;
import model.Invoice;

/*
 * This class contains the Login View
 * 
 * @author Sebastian Whyte
 * @version 03/22/2022
 *
 */

public class LoginView extends View
{
	
    private Invoice invoice;

    // GUI stuff
    private TextField userID;
    private PasswordField passwordField;
    private Button submitButton;
    private MessageView statusLog;

  
    //----------------------------------------------------------
    
    /* Constructor
     * @param Invoice object
     */
    
    public LoginView(Invoice invoice)
    {
        
        this.invoice = invoice;

        // Make a vbox container to hold the scene
        VBox container = new VBox(10);

        container.setPadding(new Insets(15, 5, 5, 5));

        container.getChildren().add(createTitle());
        container.getChildren().add(createFormContents());

        // Error message area
        container.getChildren().add
        (createStatusLog("                          "));
        
        getChildren().add(container);

        // Pre-populate the fields. This method will go to the model and get data to use as values in the controls
        populateFields();

    }

    
    //-------------------------------------------------------------
    
    /* Creates the title of the login screen
     * @return a node of the title
     */
    private Node createTitle()
    {
        Text titleText = new Text("\t\tBrewHaHa Coffee Shop\t\t");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        titleText.setTextAlignment(TextAlignment.CENTER);
        titleText.setFill(Color.DARKGREEN);

        return titleText;
    }

   
    //-------------------------------------------------------------
    
    /* Creates the main form contents
     * @return grid that contains the contents of the main form
     */
    private GridPane createFormContents()
    {
    	// Create the grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        // Username label and text field properties
        Label usernameLabel = new Label("User ID:");
        grid.add(usernameLabel, 0, 0);

        
        userID = new TextField();
        userID.setOnAction(new EventHandler<ActionEvent>() 
        {
        	@Override
            /* Each event handler has a ‘handle()’ method. In this case, it gathers data and sends it to the Model
            * for processing
            */
            public void handle(ActionEvent e) 
            {
               processAction(e);    
            }
        });
        
        
 
        grid.add(userID, 1, 0);

        
        // Password label and text field properties
        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 1);

 
        passwordField = new PasswordField();
        passwordField.setOnAction(new EventHandler<ActionEvent>() 
        {

        	@Override
            public void handle(ActionEvent e) 
            {
        		processAction(e);    
            }
       });
        
        
        
        grid.add(passwordField, 1, 1);
        

        
        submitButton = new Button("Submit");
        submitButton.setOnAction(new EventHandler<ActionEvent>() 
        {
                @Override
                public void handle(ActionEvent e) 
                {
                    processAction(e);    
                }
         });

       
        // Create hbox to hold buttons
        HBox buttonContainer = new HBox(10);
        buttonContainer.setAlignment(Pos.BOTTOM_RIGHT);
        buttonContainer.getChildren().add(submitButton);
        grid.add(buttonContainer, 1, 3);

        return grid;
    }

    
    //-------------------------------------------------------------
    
    /* Creates a status log (which displays errors) to the user
     * @param message to display on the status log
     */
    private MessageView createStatusLog(String initialMessage)
    {
        statusLog = new MessageView(initialMessage);
        return statusLog;
    }

    
    //-------------------------------------------------------------
    
    // Populates the username and password text fields with an empty string
    public void populateFields()
    {
        userID.setText("");
        passwordField.setText("");
    }

  
    //-------------------------------------------------------------
    
    /* Processes the events generated from the GUI components
     * @param event to process
     */
    public void processAction(Event event)
    {

        clearErrorMessage();

        String userIDEntered = userID.getText();

        if ((userIDEntered == null) || (userIDEntered.length() == 0))
        {
            displayErrorMessage("Please enter a User ID!");
            userID.requestFocus();
        }
        else
        {
            String passwordEntered = passwordField.getText();
            processUserIDAndPassword(userIDEntered, 
                passwordEntered);
        }
    }

    
    //----------------------------------------------------------
    
    /* Process the userID and password supplied when Submit button was hit 
     * @param the userID and password to process
     */
    private void processUserIDAndPassword(String userIDEntered,
    String passwordEntered)
    {
        Properties props = new Properties();
        props.setProperty("ID", userIDEntered);
        props.setProperty("Password", passwordEntered);

        // Clear fields for next time around
        userID.setText("");
        passwordField.setText("");

        invoice.processLogin(props);
    }

    
    //---------------------------------------------------------
    
    /* Updates the values displayed in the controls of the GUI
     * @param key and value to display
     */
    public void updateState(String key, String value)
    {
        displayErrorMessage(value);

    }

   
    //----------------------------------------------------------
    
    /* Displays any error messages into the status log
     * @param message to display
     */
    public void displayErrorMessage(String message)
    {
        statusLog.displayErrorMessage(message);
    }
    
    
    //----------------------------------------------------------
   
    // Clears the current error message that is on the status log
    public void clearErrorMessage()
    {
        statusLog.clearErrorMessage();
    }
}

