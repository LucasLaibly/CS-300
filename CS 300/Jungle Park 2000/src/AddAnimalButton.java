//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           AddAnimalButton.java
// Files:           JunglePark.java ParkGUI.java Animal.java Tiger.java
//                  Deer.java Button.java AddAnimalButton.java ClearButton.java
//                  JungleParkTests.java
// Course:          CS 300 Summer 2019
//
// Author:          Lucas Laibly
// Email:           laibly@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
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

/**
 * AddAnimalButton class :
 * Implements the ADD buttons for each animal.
 *
 * The following creates and locates a button at a given X,Y.
 * If clicked -> the button adds the appropriate animal
 *
 * @author Mouna Kacem
 * @author Lucas Laibly
 *
 */
public class AddAnimalButton extends Button
{
    // type of the animal to add
    private String type;

    /**
     * Builds the button and displays it for the size X and Y passed into the method
     *
     * @param type THe label to be displayed on the button
     * @param x the x coordinate of button
     * @param y the y coordinate of button
     * @param park the Park which the buttons are added to
     *
     */
    public AddAnimalButton(String type, float x, float y, JunglePark park)
    {
        //put the button into the park system
        super(x, y, park);

        //make the type lowercase
        this.type = type.toLowerCase();

        //create the label
        this.label = "Add " + type;
    }

    /**
     * If the button is clicked there are two options and associated actions.
     * IF the button lab. "tiger" -> we add a tiger
     * IF the bytton lab. "deer" -> we add a deer
     */
    @Override
    public void mousePressed()
    {
        //only activate the button is the mouse is over said button
        if (isMouseOver())
        {
            switch (type)
            {
                case "tiger":
                    //add deer to array
                    processing.listGUI.add(new Tiger(processing));
                    //get out of the case statement
                    break;
                case "deer":
                    //add deer to array
                    processing.listGUI.add(new Deer(processing));
                    //get out of the case statement
                    break;
            }
        }
    }
}
