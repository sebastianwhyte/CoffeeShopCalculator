# CoffeeShopCalculator
### A program made with JavaFX that generates an invoice for a coffee shop.

The initial interface consists of a login screen for the user. If the program doesn't recognize the login credentials, then it creates an account for them. 

![Screen Shot 2022-11-15 at 9 40 15 PM](https://user-images.githubusercontent.com/62267311/202071203-264a41f8-82eb-49df-843b-4e0b750d7099.png)
![Screen Shot 2022-11-15 at 9 40 28 PM](https://user-images.githubusercontent.com/62267311/202071357-198ead4c-1799-4b51-a06d-6f5f87b504ac.png)

If the user enters the incorrect password, then the message 'Login Failed' will be displayed.

Once the user is successfully authenticated, they will advance to the second screen, which is the Invoice Calculator. On this screen, the user will manually enter the amount that the customer spent on buying any of the available items - Drip Coffee, Mocha Latte, Scones, and Sandwiches.

Example: If the customer bought two scones, and the scones cost $ 1.20 each, then the barista at the register should enter $ 2.40 into the appropriate field in the invoice. The barista will enter $0.00 if the customer did not purchase any units of a particular item. Any empty fields will be read in as $0.00.

Once the user clicks the 'Calculate' button, the total sales amount will be displayed in the "Total Bill" field. This total value includes sales tax, which ranges from 3% to 9% and are in increments of 0.25. The sales tax amount can be adjusted from the drop down menu.

![Screen Shot 2022-11-15 at 9 40 54 PM](https://user-images.githubusercontent.com/62267311/202072985-0b951894-e8b0-48a5-9efa-3de108189a0b.png)
![Screen Shot 2022-11-15 at 10 02 23 PM](https://user-images.githubusercontent.com/62267311/202073360-4fada8ec-a3cc-4d58-8a56-9be7766635b2.png)
