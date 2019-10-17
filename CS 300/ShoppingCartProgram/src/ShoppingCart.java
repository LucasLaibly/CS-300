//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ShoppingCart.java
// Files:           ShoppingCartTests.java
// Course:          CS300, Summer 2019
//
// Author:          Lucas Laibly
// Email:           laibly@wisc.edu
// Lecturer's Name: MOUNA AYARI BEN HADJ KACEM
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    I Do Not Have A Partner
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   X Write-up states that pair programming is allowed for this assignment.
//   X We have both read and understand the course Pair Programming Policy.
//   X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.*;

public class ShoppingCart
{
    // Define final parameters
    // shopping cart max capacity
    private static final int CART_CAPACITY = 20;

    // sales tax
    private static final double TAX_RATE = 0.05;

    // a perfect-size two-dimensional array that stores the available items in the market
    // MARKET_ITEMS[i][0] refers to a String that represents the description of the item
    //                   identified by index i
    // MARKET_ITEMS[i][1] refers to a String that represents the unit price of the item
    //                   identified by index i in dollars.
    public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},
            {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},
            {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},
            {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},
            {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},
            {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},
            {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};

    /**
     * adds the item with the given identifier index at the end of the cart
     *
     * @param index of the item within the marketItems array
     * @param cart shopping cart
     * @param count number of items present within the cart before this add method is called
     * @return the number of items present in the cart after the item with identifier index is added
     */
    public static int add(int index, String[] cart, int count)
    {
        //we first want to see if the cart is at or above capacity
        if(count >= CART_CAPACITY)
        {
            //if it is, we print the warning
            System.out.println("WARNING: The cart is full. You cannot add any new item.");
        }

        //otherwise, we move the item specified into the cart
        else
        {
            cart[count] = MARKET_ITEMS[index][0];
        }

        //increment and return count as that is how many items are in the cart
        count++;
        return count;
    }

    /**
     * Returns how many occurrences of the item with index itemIndex are present in the shopping cart
     *
     * @param itemIndex identifier of the item to count its occurrences in the cart
     * @param cart shopping cart
     * @param count number of items present within the cart
     * @return the number of occurrences of item in the cart
     * */
    public static int occurrencesOf(int itemIndex, String[] cart, int count)
    {
        //holding space for how many times an item occurs in the array
        int occurences = 0;

        //for loop to iterate through the cart
        for (int i = 0; i <= count; i++)
        {
            //if the item is found in the cart, we increment that it has occurred (been found)
            if(cart[i] == MARKET_ITEMS[itemIndex][0])
            {
                occurences++;
            }
        }

        //we increment count, and return occurrences
        count++;
        return occurences;
    }

    /**
     * Returns the index of an item within the shopping cart
     *
     * @param item description
     * @param cart Shopping cart
     * @return index of the item within the shopping cart, and -1 if the item does not exist in the
     *         cart
     */
    private static int indexOf(String item, String[] cart)
    {
        //for loop to iterate over the shopping cart
        for (int i = 0; i < cart.length; i++)
        {
            //once we find the item in the cart, then we return the index we are on
            if (cart[i] == item)
            {
                return i;
            }
        }

        //if we do not find it, we return -1 to represent a failure in finding it
        return -1;
    }

    /**
     * removes the first and only occurrence of itemToRemove if found
     * if the item is not found, it returns a -1
     *
     * @param itemToRemove of the item within the cart
     * @param cart shopping cart
     * @param count number of items present within the cart after item is removed
     * @return the number of items present in the cart after the item is removed
     */
    public static int remove(String itemToRemove, String[] cart, int count)
    {

        //we first want to make sure the cart is not null or empty
        if(cart == null || cart.length == 0)
        {
            //if it is, we return the count.
            return count;
        }

        //holds the index of the item we are looking to remove
        int hold = indexOf(itemToRemove, cart);

        //if we get a -1, the item was not found
        if(hold == -1)
        {
            //print the warning
            System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");
        }

        //if the item was found, we move the last itme in the cart to the index we are at,
        //increment count
        else
        {
            cart[hold] = cart[cart.length-1];
            count--;
        }

        //return the count of items in the cart
        return count;
    }


    /**
     * returns the total value (cost) of the cart without tax in $ (double)
     *
     * @param cart shopping cart
     * @param count number of items present within the cart
     * @return the cost of all the items before the tax is added on to it
     */
    public static double getSubTotalPrice(String[] cart, int count)
    {
        //variable to hold out total cost for the entirety of the cart
        double totalCost = 0.0;

        //first for loop goes through our cart
        for (int i = 0; i <= count; i++)
        {
            //second for loop goes through our market options
            for (int j = 0; j < MARKET_ITEMS.length; j++)
            {
                //compare each item in the cart to all the items in market list
                if(cart[i] == MARKET_ITEMS[j][0])
                {
                    //if it is found, we hold that items cost in a string element
                    String item = MARKET_ITEMS[j][1];

                    //remove the $ sign from the start of the string
                    item = item.substring(1);

                    //parse it as a double and compound it to our variable totalCost
                    totalCost += Double.parseDouble(item);
                }
            }
        }

        //once done, we return the totalCost of our cart
        return totalCost;
    }


    /**
     * prints the Market Catalog (item identifiers, description, and unit prices)
     *
     * @return prints the entire market catalog. I had to make my own algorithm to handle the spacing
     * as the code given was not cooperating with me.
     */
    public static void printMarketCatalog()
    {
        //print the header message
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Item id         Description      Price       ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        //for loop to iterate through the entire market options
        for (int i = 0; i < MARKET_ITEMS.length; i++)
        {
            //retrieve each items name and cost
            String food = MARKET_ITEMS[i][0];
            String price = MARKET_ITEMS[i][1];

            //get the length of the id, the item, and the cost
            int idLength = String.valueOf(i).length();
            int foodLength = food.length();
            int priceLength = price.length();

            //format each portion of the string the match with the 45 char bars
            String idSpaces = String.format("%" + (16 - idLength) + "s", " ");
            String fSpaces = String.format("%" + (17 -foodLength) + "s", " ");
            String pSpaces = String.format("%" + (12 - priceLength) + "s", " ");

            //put all the pieces together
            System.out.println(i + idSpaces + food + fSpaces + price + pSpaces);
        }

        //print the ending bar
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
    }


    /**
     * Displays the cart content (items separated by commas)
     *
     * @param cart shopping cart
     * @param count number of items present within the cart
     * @return no return, just prints all the items in the cart currently
     */
    public static void displayCartContent(String[] cart, int count)
    {
        //print the opening line of the cart
        System.out.print("Cart Content: ");

        //for each item in the cart
        for(String item : cart)
        {
            //as long as the item is not null
            if(item != null)
            {
                //print said item, and as the comma
                System.out.print(item + ", ");
            }
        }

        //finish with a new line
        System.out.println();
    }

    /**
     * displays the welcome message
     *
     * @return there is no return here, this method simply holds the sout lines
     * for which the welcome message is displayed.
     */
    private static void welcomeMessage()
    {
        //trivial comment, this is just the entire opening message
        System.out.println("COMMAND MENU:");
        System.out.println(" [P] print the market catalog");
        System.out.println(" [A <index>] add one occurrence of an item to the cart given its identifier");
        System.out.println(" [C] checkout");
        System.out.println(" [D] display the cart content");
        System.out.println(" [O <index>] number of occurrences of an item in the cart given its identifier");
        System.out.println(" [R <index>] remove one occurrence of an item from the cart given its identifier");
        System.out.println(" [Q]uit the application");
        System.out.println();
        System.out.print("ENTER COMMAND: ");
    }

    /**
     * main method
     *
     * @return the heart and soul of the shopping cart
     */
    //main method
    public static void main(String args[])
    {
        // Scanner object to be used throughout the program
        Scanner scnr = new Scanner(System.in);

        //the cart of items we want
        String[] cart = new String[CART_CAPACITY];

        // count value to how many objects we added to our cart
        int count = 0;

        // keeps the application running until the user enters a Q or q
        boolean flag = true;

        //welcome's the user and prints two new lines -- this is ONLY done at the start of the application
        System.out.println("=============   Welcome to the Shopping Cart App   =============");
        System.out.println();
        System.out.println();

        //as long as the flag is true, we will continue running the application
        while(flag)
        {
            //print the welcome message
            welcomeMessage();

            //read in the user choice
            String userInput = scnr.nextLine();

            //if the user's choice is p, we want to print the catalog
            if(userInput.equals("P") || userInput.equals("p"))
            {
                printMarketCatalog();
            }

            //if the user choice is A,
            else if(userInput.contains("A") || userInput.contains("a"))
            {
                //we first make a sub string to get the number which follows the character
                String userSpecifiedInt = userInput.substring(2).trim();

                //parse that substring as an integer
                int userIndex = Integer.parseInt(userSpecifiedInt);

                //call the add function
                count = add(userIndex, cart, count);
            }

            //if the user is C,
            else if(userInput.equals("C")|| userInput.equals("c"))
            {
                //call the sub total price
                double cost = getSubTotalPrice(cart, count);

                //find the tax cost from the tax rate
                double taxCost = TAX_RATE * cost;

                //sum those values together
                double totalCostC = cost + taxCost;

                //format the string to that it is only 2 digits past the decimal point
                String taxResult = String.format("%.2f", taxCost);
                String totalResult = String.format("%.2f", totalCostC);

                //format the output string
                System.out.println("#items: " + count +" Subtotal: $" + cost +
                        " Tax: $"+ taxResult + " TOTAL: $" + totalResult);
            }

            //if the user choice is D,
            else if(userInput.equals("D") || userInput.equals("d"))
            {
                //display the cart contents
                displayCartContent(cart, count);
            }

            //if the user choice is O,
            else if(userInput.contains("O") || userInput.contains("o"))
            {
                //make a substring to of the number following the character
                String userSpecifiedInt = userInput.substring(2).trim();

                //parse it as an integer
                int userIndexOccur = Integer.parseInt(userSpecifiedInt);

                //call occurrences, and get the number of occurrences
                int occur = occurrencesOf(userIndexOccur, cart, count);

                //format the string and output
                System.out.println("The number of occurrences of " + MARKET_ITEMS[userIndexOccur][0] +
                        " (id #" + userIndexOccur +") is: " + occur);
            }

            //is the user character is R,
            else if(userInput.contains("R")|| userInput.contains("r"))
            {
                //make a substring to get the number after the character
                String itemToRemove = userInput.substring(2).trim();

                //parse it as an integer
                int userIndex = Integer.parseInt(itemToRemove);

                //call for remove of the item, and increment count
                count = remove(MARKET_ITEMS[userIndex][0], cart, count);
            }

            //if the user enters Q,
            else if(userInput.equals("Q") || userInput.equals("q"))
            {
                //set flag to false
                flag = false;

                //print the exit bar of the application
                System.out.print("=============  Thank you for using this App!!!!!  =============");
            }

            //new line
            System.out.println();
        }
    }
}
