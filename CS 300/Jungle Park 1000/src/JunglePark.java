//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           JunglePark.java
// Files:           JunglePark.java
// Course:          CS300,Summer 2019
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
import java.util.Random;

public class JunglePark
{
    // PApplet object that represents the graphic interface of the JunglePark application
    private static PApplet processing;

    // PImage object that represents the background image
    private static PImage backgroundImage;

    // array storing the current tigers present in the Jungle Park
    private static Tiger[] tigers;

    // Generator of random numbers
    private static Random randGen;

    /**
     * Defines the initial environment properties of the application
     * @param processingObj represents a reference to the graphical
     *  interface of the application
     */
    public static void setup(PApplet processingObj)
    {

        // create a Random object and store its reference in randGen
        randGen = new Random();

        // initialize the processing field to the one passed into
        // the input argument parameter
        processing = processingObj;

        // initialize and load the image of the background
        backgroundImage = processing.loadImage("images/background.png");

        // width [resp. height]: System variable of the processing library that stores the width
        // [resp. height] of the display window.

        //Make the array null
        tigers = new Tiger[8];
        tigers[0] = new Tiger(processing, (float)randGen.nextInt(processing.width), (float)randGen.nextInt(processing.height));
    }

    /**
     * the "builder" of the background and tigers array
     */
    public static void update()
    {
        //make a new tiger object
        Tiger tiger = new Tiger(processing);

        // Set the color used for the background of the Processing window
        processing.background(245, 255, 250);

        // Draw the background image at the center of the screen
        processing.image(backgroundImage, processing.width / 2, processing.height / 2);

        //for loop that draws a tiger picture for each Tiger obj in the array that is
        //not null
        for (int i = 0; i < tigers.length; i++)
        {
            if(tigers[i] != null)
            {
                //draw the tiger image
                tigers[i].draw();
            }
        }

    }

    /**
     * we want to see if the mouse is over A SPECIFIC tiger. This method does not
     * check to see if any tiger has the mouse over it.
     *
     * @param tiger object
     * @return a boolean value if the user's mouse is over a tiger or not
     */
    public static boolean isMouseOver(Tiger tiger)
    {
        //first look to see if the tiger object is null
        if(tiger == null)
        {
            return false;
        }

        //get the image of the tiger
        PImage tigerImage = tiger.getImage();

        //locate the position of the tiger - X axis
        float tigerX = tiger.getPositionX();

        //locate the position of the tiger - Y axis
        float tigerY = tiger.getPositionY();

        //statement to check teh boundaries of the X axis to ensure mouse is within in them
        if((tigerX - (tigerImage.width / 2) <= processing.mouseX) && (tigerX + (tigerImage.width / 2) >= processing.mouseX))
        {
            //statement to check the boundaries of the Y axis to ensure the mouse is within them
            if((tigerY - (tigerImage.height / 2) <= processing.mouseY) && (tigerY + (tigerImage.height / 2) >= processing.mouseY))
            {
                //the mouse is over an image -- return true
                return true;
            }
        }

        //mouse is not over a specific tiger -- return false
        return false;
    }

    /**
     * if the mouse is over a specifc tiger and DOWN we want to set dragging to true so that
     * the tiger can be moved around
     *
     */
    public static void mouseDown()
    {
        for (int i = 0; i < tigers.length; i++)
        {
            //we want to see if the mouse is over a specific tiger
            boolean tigerTest = isMouseOver(tigers[i]);

            //if it is..
            if(tigerTest)
            {
                //.. we set the dragging field to true for that tiger and break out of the statement
                tigers[i].setDragging(tigerTest);
                break;
            }
        }
    }

    /**
     * if the mouse is over a specifc tiger and UP : we have released the tiger and it should
     * not be dragging or being dragged anymore
     *
     */
    public static void mouseUp()
    {
        //go over the entire array of tigers
        for (int i = 0; i < tigers.length; i++)
        {
            //as long as the tiger is not null
            if(tigers[i] != null)
            {
                //we set the dragging attribute of that tiger to false
                tigers[i].setDragging(false);
            }
        }
    }

    /**
     * if one of two keys is pressed (R or T) we want to do a specific action.
     * If T is pressed -> add a tiger (up to eight)
     * If R is pressed -> remove a tiger
     *
     */
    public static void keyPressed()
    {
        //if akey is pressed
        switch (processing.key)
        {
            //and said key is either T or t
            case 't':
            case 'T':
                //iterate over the tigers array
                for (int i = 0; i < tigers.length; i++)
                {
                    //look to see if there is a null slot
                    if(tigers[i] == null)
                    {
                        //default to center of room -> add a new tiger
                        tigers[i] = new Tiger(processing, processing.width / 2, processing.height / 2);
                        return;
                    }
                }
                //get out of the case statement
                break;

            //and said key is either R or r
            case 'r':
            case 'R':
                //test to get lowest index of the tiger to remove
                for (int i = 0; i < tigers.length; i++)
                {
                    //as long as the mouse is over the tiger at that index
                    boolean tigerTest = isMouseOver(tigers[i]);
                    if(tigerTest)
                    {
                        //we remove the tiger by setting its slot in the array to null
                        tigers[i] = null;
                        break;
                    }
                }

        }
    }

    /**
     * main method that calls the application and runs it
     */
    public static void main(String args[])
    {
        Utility.startApplication();
    }
}
