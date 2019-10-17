//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Deer.java
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
 * Deer class:
 *
 * Handles the implementation of Deer objects that get put within the Park
 * extends Animal
 * @author Lucas Laibly
 *
 */
public class Deer extends Animal
{
    // scan range area to check for a threat in the neighborhood
    private static final int SCAN_RANGE = 175;
    private static final String IMAGE_FILE_NAME = "images/deer.png";

    // class variable that represents the identifier of the next deer
    // to be created
    private static int nextID = 1;

    // A String that represents the deer type
    private static final String TYPE = "DR";

    // Deer's id: positive number that represents the order of the deer
    private final int id;


    /**
     * Creates a new Deer object positioned at a random position of the display window
     *
     * @param processing PApplet object that represents the display window
     */
    public Deer(JunglePark processing)
    {
        // Set Deer drawing parameters
        super(processing, IMAGE_FILE_NAME);

        // Set Deer identification fields
        id = nextID;

        // String that identifies the current tiger
        this.label = TYPE + id;
        nextID++;
    }

    /**
     * Check if there is a threat within the given range
     *
     * @paran range the range to check within
     * @return true if the tiger is near
     */
    public boolean scanForThreat(int scanRange)
    {
        //iterate through the list of objects in the Park
        for (int i = 0; i < processing.listGUI.size(); i++)
        {
            //ensure we have an object that is an instanceof Tiger
            if(processing.listGUI.get(i) instanceof Tiger)
            {
                //get that tiger object
                Tiger tiger = (Tiger)processing.listGUI.get(i);

                //if the deer is close to said tiger,
                if(isClose(tiger, scanRange))
                {
                    //true, we have found a threat to the deer
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Defines the behavior of a Deer object in the Jungle park
     */
    @Override
    public void action()
    {
        //look for threats that are within the SCAN_RANGE (provided)
        if(scanForThreat(SCAN_RANGE))
        {
            this.processing.fill(0); // specify font color: black
            this.processing.text("THREAT!", this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);
        }

    }
}
