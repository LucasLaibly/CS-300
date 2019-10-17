//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Tiger.java
// Files:           JunglePark.java ParkGUI.java Animal.java JunglePark.java
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
 * Handle all creations of type Tiger, as well as Tiger function HOP
 *
 * @author Lucas Laibly
 */

/**
 * This class represents a Tiger in the JunglePark application
 */
public class Tiger extends Animal
{
  private static final int SCAN_RANGE = 100; // range dimension for scanning the neighborhood for food
  private static final String IMAGE_FILE_NAME = "images/tiger.png";
  private static int nextID = 1; // class variable that represents the identifier of the next tiger
                                 // to be created
  // Tiger's identification fields
  private static final String TYPE = "TGR"; // A String that represents the tiger type
  private final int id; // Tiger's id: positive number that represents the order of the tiger

  private int deerEatenCount; // Number of Deers that the current tiger has eaten so far


  /**
   * Creates a new Tiger object positioned at a random position of the display window
   * 
   * @param processing PApplet object that represents the display window
   */
  public Tiger(JunglePark processing)
  {
    // Set Tiger drawing parameters
    super(processing, IMAGE_FILE_NAME);

    // Set Tiger identification fields
    id = nextID;
    this.label = TYPE + id; // String that identifies the current tiger
    nextID++;
  }

  /**
   * releases the mouse, moves the position of the tiger to the food's location
   * then removes said item, increments the score of that tiger which found prey
   *
   * @param food Deer object that the Tiger is inclined to hunter for
   */
  public void hop(Deer food)
  {
    //release the mouse
    this.mouseReleased();

    //move the tiger to the food's position -> we already know we are close enough to it
    this.setPositionX(food.getPositionX());
    this.setPositionY(food.getPositionY());

    //iterate over the list
    for (int i = 0; i < processing.listGUI.size(); i++)
    {
      //find the item which is the same as food
      if(processing.listGUI.get(i).equals(food))
      {
        //then set the deer to null that was eaten
        processing.listGUI.remove(i);

        //increment score
        deerEatenCount++;

        //break out of the loop
        break;
      }
    }
  }

  /**
   * @return the deerEatenCount (tigers score for how many deer have been eaten
   */
  public int getDeerEatenCount()
  {
    return deerEatenCount;
  }

  /**
   * Tiger's behavior in the Jungle Park
   * Scans for food at the neighborhood of the current tiger. 
   * If the Tiger founds any deer at its proximity, it hops on it, and eats it
   */
  @Override
  public void action()
  {
    //iterate over the list of objects in the Park
    for (int i = 0; i < processing.listGUI.size(); i++)
    {
      //get a park item
      ParkGUI item = processing.listGUI.get(i);

      //if that item is an instanceof Deer
      if(item instanceof Deer)
      {
        //and the deer is close/within scan range
        if(isClose((Deer)item, SCAN_RANGE))
        {
          //call hop -> tigers moves to deer and eats it
          hop((Deer)item);
        }
      }
    }

    //as long as the deerEatenCount is larger than zero we are going to display the score
    if(deerEatenCount > 0)
    {
      // display deerEatenCount
      displayDeerEatenCount();
    }

  }

  /**
   * Displays the number of eaten deers if any on the top of the tiger image
   */
  public void displayDeerEatenCount()
  {
    this.processing.fill(0); // specify font color: black

    // display deerEatenCount on the top of the Tiger's image
    this.processing.text(deerEatenCount, this.getPositionX(), this.getPositionY() - this.image.height / 2 - 4);
  }
  
 
}
