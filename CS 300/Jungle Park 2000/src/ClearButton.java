//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ClearButton.java
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
 * ClearButton class:
 *
 * Handles the implementation of the clearing the board
 * Extension from the Button class
 * @author Lucas Laibly
 *
 */
public class ClearButton extends Button
{
    /**
     * Builds the button and displays it for the size X and Y passed into the method
     * Label set as
     *
     * @param x the x coordinate of button
     * @param y the y coordinate of button
     * @param park the Park which the buttons are added to
     *
     */
    public ClearButton(float x, float y, JunglePark park)
    {
        //put the button onto/into the park
        super(x, y, park);

        //apply the label "Clear Park"
        this.label = "Clear Park";

    }

    /**
     * Checks if the mouse is over the given button object as long as the mouse is over said object
     *
     * If isMouseOver = true, AND the list is not null, we clear the board
     *
     */
    @Override
    public void mousePressed()
    {
        //ensure the mouse is over the button
        if (isMouseOver())
        {
            //avoid NullPointerException =>
            if(processing.listGUI != null)
            {
                //clear the board
                processing.clear();
            }
        }
    }
}
