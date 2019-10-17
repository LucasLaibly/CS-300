//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ShoppingCartTests.java
// Files:           ShoppingCart.java
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

// JavaDoc class Header comes here
public class ShoppingCartTests {

    /**
     * Checks whether the total number of items within the cart is incremented after adding one item
     * @return true if the test passes without problems, false otherwise
     */
    public static boolean testCountIncrementedAfterAddingOnlyOneItem()
    {
        boolean testPassed = true; // boolean local variable evaluated to true if this test passed,
        // false otherwise

        {
            // shopping cart
            String[] cart = new String[20];

            // number of items present in the cart (initially the cart is empty)
            int count = 0;

            // Add an item to the cart

            // add an item of index 3 to the cart
            count = ShoppingCart.add(3, cart, count);

            // Check that count was incremented
            if (count != 1)
            {
                System.out.println("Problem detected: After adding only one item to the cart, "
                        + "the cart count should be incremented. But, it was not the case.");
                testPassed = false;
            }
        }


        return testPassed;

    }

    /**
     * Checks whether add and OccurrencesOf return the correct output when only one item is added to
     * the cart
     *
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testAddAndOccurrencesOfForOnlyOneItem()
    {
        boolean testPassed = true; // evaluated to true if test passed without problems, false otherwise
        // define the shopping cart as an oversize array of elements of type String
        // we can set an arbitrary capacity for the cart - for instance 10

        {
            // shopping cart
            String[] cart = new String[10];

            // number of items present in the cart (initially the cart is empty)
            int count = 0;

            // check that OccurrencesOf returns 0 when called with an empty cart
            if (ShoppingCart.occurrencesOf(10, cart, count) != 0)
            {
                System.out.println("Problem detected: Tried calling OccurrencesOf() method when the cart is "
                        + "empty. The result should be 0. But, it was not.");
                testPassed = false;
            }

            // add one item to the cart
            // add an item of index 0 to the cart
            count = ShoppingCart.add(0, cart, count);

            // check that OccurrencesOf("Apples", cart, count) returns 1 after adding the item with key 0
            if (ShoppingCart.occurrencesOf(0, cart, count) != 1)
            {
                System.out.println("Problem detected: After adding only one item with key 0 to the cart, "
                        + "OccurrencesOf to count how many of that item the cart contains should return 1. "
                        + "But, it was not the case.");
                testPassed = false;
            }
        }

        return testPassed;
    }

    /**
     * Checks SubTotal return from the getSubTotalPrice method in ShoppingCart.java
     *
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testSubTotalPrice()
    {
        // boolean flag to ensure that the test passes correctly, default is true
        //if the test does not pass, we set it to false
        boolean testPassed = true;

        // shopping cart
        String[] cart = new String[10];

        //count initially
        int count = 0;

        //fill our cart up
        count = ShoppingCart.add(3, cart, count);
        count = ShoppingCart.add(5, cart, count);
        count = ShoppingCart.add(8, cart, count);

        //sum our cost PRE tax application
        double subtotal = ShoppingCart.getSubTotalPrice(cart, count);

        //compare to see if we got the correct value
        if(subtotal != 9.27)
        {
            System.out.println("The current subtotal values do not match up.");
            testPassed = false;
        }

        return testPassed;
    }

    /**
     * Checks cart return from the remove method in ShoppingCart.java
     *
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testRemoveObject()
    {
        // boolean flag to ensure that the test passes correctly, default is true
        //if the test does not pass, we set it to false
        boolean testPassed = true;

        //shopping cart
        String[] cart = new String[10];

        //count initially
        int count = 0;

        //item we are looking to remove
        String targetItem = "Test";

        //fill our cart up
        count = ShoppingCart.add(3, cart, count);
        count = ShoppingCart.add(5, cart, count);
        count = ShoppingCart.add(8, cart, count);

        //call remove
        int removeHold = ShoppingCart.remove(targetItem, cart, count);

        //we want to test for failure -- to test both iteration over the entire array
        //as well as the return of -1
        if(removeHold == -1)
        {
            System.out.println("Remove did not correctly return a -1, and therefore is wrong.");
            testPassed = false;
        }

        return testPassed;
    }

    /**
     * Checks add return from the add method in ShoppingCart.java
     * We want to add many times over.
     *
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testMultipleAdd()
    {
        boolean testPassed = true;

        //shopping cart
        String[] cart = new String[10];

        //count initially
        int count = 0;

        //item we are looking to remove
        String targetItem = "Test";

        //fill our cart up
        count = ShoppingCart.add(0, cart, count);
        count = ShoppingCart.add(0, cart, count);
        count = ShoppingCart.add(0, cart, count);

        //look for multiple occurences
        if(ShoppingCart.occurrencesOf(0, cart, count) != 3)
        {
            System.out.println("Adding Multiple items does not work correctly.");
            testPassed = false;
        }

        return testPassed;
    }

    /**
     * Checks occurences return from the occurences method in ShoppingCart.java
     * Have many occurences of the same item
     *
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testMultipleOccurences()
    {
        boolean testPassed = true;

        String[] cart = new String[10];

        //count initially
        int count = 0;

        //item we are looking to remove
        String targetItem = "Test";

        //fill our cart up
        count = ShoppingCart.add(0, cart, count);
        count = ShoppingCart.add(0, cart, count);
        count = ShoppingCart.add(0, cart, count);

        //look for multiple occurences
        if(ShoppingCart.occurrencesOf(0, cart, count) != 3)
        {
            System.out.println("Duplicate occurences of items is not being handled correctly.");
            testPassed = false;
        }

        //fill our cart up -- with different items
        count = ShoppingCart.add(1, cart, count);
        count = ShoppingCart.add(2, cart, count);

        if(ShoppingCart.occurrencesOf(0, cart, count) != 3)
        {
            System.out.println("Duplicate occurences of items is not being handled correctly.");
            testPassed = false;
        }



        return testPassed;
    }

    /**
     * Checks the correct return is done when we go beyond what the cart can handle/hold
     *
     * @return true if test passed without problems, false otherwise
     */
    public static boolean testAddBeyondCapacity()
    {
        boolean testPassed = true;

        //shopping cart
        String[] cart = new String[20];

        //count initially
        int count = 20;

        //fill our cart up
        count = ShoppingCart.add(0, cart, count);

        //visual test because we are expecting to see something get printed as we are
        //exceeding the capacity of the add function


        return testPassed;
    }

    /**
     * main method used to call the unit tests
     *
     * @param args
     */
    public static void main(String[] args)
    {
        System.out.println("testCountIncrementedAfterAddingOnlyOneItem(): "
                + testCountIncrementedAfterAddingOnlyOneItem());
        System.out.println(
                "testAddAndOccurrencesOfForOnlyOneItem(): " + testAddAndOccurrencesOfForOnlyOneItem());
        System.out.println(
                "testSubTotalPrice():  " + testSubTotalPrice());
        System.out.println(
                "testRemoveObject():  " + testRemoveObject());
        System.out.println(
                "testMultipleAdd():  " + testMultipleAdd());
        System.out.println(
                "testMultipleOccurences():  " + testMultipleOccurences());
        System.out.println(
                "testAddBeyondCapacity():  " + testAddBeyondCapacity());
    }
}
