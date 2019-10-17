//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           JungleParkTests.java
// Files:           JunglePark.java ParkGUI.java Animal.java Tiger.java
//                  Deer.java Button.java AddAnimalButton.java ClearButton.java
//                  Deer.java
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
 * JungleParkTests class:
 *
 * Tests all aspects of the Deer, Tiger, Animal, and JunglePark classes.
 * @author Lucas Laibly
 *
 */
import java.util.ArrayList;

public class JungleParkTests extends JunglePark
{
  // PApplet object that represents the display window of this program
  private static JunglePark park;

  /**
   * This method checks whether isClose() called by a Deer returns true if a tiger is within its
   * scanRange area and false if called with another tiger as input parameter located outside 
   * the scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1isCloseMethod()
  {
    boolean passed = true;

    // This is an example. You can define your own test scenario for this method
    // Create a deer and two tigers
    Deer d = new Deer(park);
    Tiger t1 = new Tiger(park);
    Tiger t2 = new Tiger(park);
    // Set deer at position(200,200)
    d.setPositionX(200);
    d.setPositionY(200);
    // Set first tiger at position(400,200)
    t1.setPositionX(400); // tiger is 200px away from deer
    t1.setPositionY(200);
    // Set second tiger at position(300,200)
    t2.setPositionX(300); // tiger is 100px away from deer
    t2.setPositionY(200);
    if (d.isClose(t1, 175)) { // bug! isClose() should return false here
      System.out.println("Deer's isClose is returning true when it should return false.");
      passed = false;
    }
    if (!d.isClose(t2, 175)) { // bug! isClose() should return true here
      System.out.println("Deer's isClose is returning false when it should return true.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether isClose() called by a Tiger returns false if another tiger is
   * located outside its scanRange area
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2isCloseMethod()
  {
    boolean passed = true;
    int range = 100;

    //make two tigers, and add them to the park
    Tiger first = new Tiger(park);
    Tiger second = new Tiger(park);

    park.listGUI.add(first);
    park.listGUI.add(second);

    // Set first tiger at position(200,200)
    first.setPositionX(200);
    first.setPositionY(200);
    // Set second tiger at position(400,200)
    second.setPositionX(400);
    second.setPositionY(200);

    //check to see if tigers are close, within in scan range => should be false
    if (first.isClose(second, range))
    {
      System.out.println("The tigers are not close to each other, but isClose() returns that they are.");
      passed = false;
    }


    // clear all the content of listGUI to get ready for a next scenario
    park.listGUI.clear();

    return passed;
  }

  /**
   * This method checks whether the deer detects a Tiger present at its proximity
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test1DeerScanForThreatMethod()
  {
    boolean passed = true;
    int range = 150;

    //make the new Tiger and Deer objects, add them to the park
    Deer deer = new Deer(park);
    Tiger tiger = new Tiger(park);

    park.listGUI.add(tiger);
    park.listGUI.add(deer);

    // Set deer at position(200,200)
    deer.setPositionX(200);
    deer.setPositionY(200);
    // Set first tiger at position(300,200)
    tiger.setPositionX(300); // tiger is 100px away from deer
    tiger.setPositionY(200);

    //see if tiger is at deer's proximity of its scanForThreat
    if(!deer.scanForThreat(range))
    {
      System.out.println("Deer's scanForThreat test 1 is returning false when it should return true.");
      passed = false;
    }


    // clear all the content of listGUI to get ready for a next scenario
    park.listGUI.clear();

    return passed;
  }

  /**
   * This method checks whether your scanForThreat() method returns false if no Tiger is present
   * within a specific range distance from it
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean test2DeerScanForThreatMethod()
  {
    boolean passed = true;
    int range = 100;
    Deer deer = new Deer(park);
    Tiger tiger = new Tiger(park);

    park.listGUI.add(tiger);
    park.listGUI.add(deer);

    // Set deer at position(200,200)
    deer.setPositionX(200);
    deer.setPositionY(200);
    // Set first tiger at position(300,200)
    tiger.setPositionX(400); // tiger is 200px away from deer
    tiger.setPositionY(200);

    if(deer.scanForThreat(range))
    {
      System.out.println("Deer's scanForThreat test 2 is returning true when it should return false.");
      passed = false;
    }


    // clear all the content of listGUI to get ready for a next scenario
    park.listGUI.clear();

    return passed;
  }

  /**
   * This method checks whether the tiger hops on the deer provided to the hop() method as input
   * argument. (1) The tiger should take the position of the deer. (2) The unfortunate deer should
   * be removed from the JunglePark listGUI. (3) The eatenDeerCount should be incremented.
   * 
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testTigerHopMethod() {
    boolean passed = true;
    // This is an example. You may develop different scenarios to assess further the correctness of 
    // your hop() method
    // Create one deer and one tiger
    Deer d = new Deer(park);
    Tiger t = new Tiger(park);
    // Set the deer at position(250,250)
    d.setPositionX(250);
    d.setPositionY(250);
    // Set the tiger at position(300,300) tiger is 70.71px away from deer d1
    t.setPositionX(300);
    t.setPositionY(300);
    // add the tiger and the deer to the JunglePark (i.e. to listGUI)
    park.listGUI.add(d);
    park.listGUI.add(t);
    t.hop(d); // tiger hops on the deer
    if (t.getPositionX() != d.getPositionX() && t.getPositionY() != d.getPositionY()) {
      // tiger should move to the position of the deer
      System.out.println("Tiger did not move correctly when hopping.");
      passed = false;
    }
    if (park.listGUI.contains(d)) {
      // deer should be removed from the park
      System.out.println("Deer was not removed after being hopped on.");
      passed = false;
    }
    if (t.getDeerEatenCount() != 1) {
      // deerEatenCount should be incremented. It was 0
      System.out.println("deerEatenCount should be incremented after the tiger hopped on a deer.");
      passed = false;
    }

    /////////////////////////////////////
    park.listGUI.clear(); // clear all the content of listGUI to get ready for a next scenario

    return passed;
  }

  /**
   * This method checks whether your getDeerEatenCount() method returns the correct incrementation of if
   * a tiger has eaten a deer that is close.
   *
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testGetDeerEaten()
  {
    //boolean to hold if the test has passed
    boolean passed = true;

    //make the tiger and deer objects, add them to the park
    Deer deer = new Deer(park);
    Tiger tiger = new Tiger(park);
    park.listGUI.add(tiger);
    park.listGUI.add(deer);

    // Set deer at position(205,200)
    deer.setPositionX(205);
    deer.setPositionY(200);

    // Set first tiger at position(300,200)
    tiger.setPositionX(200);
    tiger.setPositionY(200);

    //move the tiger onto the deer, consume it
    tiger.hop(deer);

    //ensure the tiger's "score" has been incremented by one
    if(tiger.getDeerEatenCount() != 1)
    {
      System.out.println("getDeerEatenCount should have incremented by 1, but did not. ");
      passed = false;
    }


    // clear all the content of listGUI to get ready for a next scenario
    park.listGUI.clear();

    return passed;
  }

  /**
   * This method checks whether your clear() function correctly removes Animals from the park
   *
   * @return true when test verifies correct functionality, and false otherwise.
   */
  public static boolean testClear()
  {
    //boolean to hold if the test has passed
    boolean passed = true;

    //add the buttons that a user could interact with
    AddAnimalButton anbTiger = new AddAnimalButton("Tiger", 43, 16, park);
    AddAnimalButton anbDeer = new AddAnimalButton("Deer", 129, 16, park);
    ClearButton clear = new ClearButton(215,16, park);

    //once the objects are created, place them into the list of ALL objects
    park.listGUI.add(anbTiger);
    park.listGUI.add(anbDeer);
    park.listGUI.add(clear);

    //make the tiger and deer objects, add them to the park
    Deer deer = new Deer(park);
    Tiger tiger = new Tiger(park);

    park.listGUI.add(tiger);
    park.listGUI.add(deer);

    // Set deer at position(205,200)
    deer.setPositionX(205);
    deer.setPositionY(200);

    // Set first tiger at position(300,200)
    tiger.setPositionX(200);
    tiger.setPositionY(200);

    //move the tiger onto the deer, consume it
    tiger.hop(deer);

    // clear all the content of listGUI to get ready for a next scenario
    park.listGUI.clear();

    //all that should remain in the park are the three buttons we added
    if(park.listGUI.size() != 0)
    {
      System.out.println("Testing to see if the park was cleared of animals has failed.");
      passed = false;
    }

    return passed;
  }

  /**
   * runs JungleParkTests program as a PApplet client
   * 
   * @param args
   */
  public static void main(String[] args) {
    // Call PApplet.main(String className) to start this program as a PApplet client application
    PApplet.main("JungleParkTests");
  }

  /**
   * This is a callback method automatically called only one time when the PApplet application
   * starts as a result of calling PApplet.main("PAppletClassName"); Defines the initial environment
   * properties of this class/program As setup() is run only one time when this program starts, all
   * your test methods should be called in this method
   */
  @Override
  public void setup()
  {
    //calls the setup() method defined
    super.setup();

    //set the park to the current instance of Jungle
    park = this;

    //test isClose()
    System.out.println("test1isCloseMethod(): " + test1isCloseMethod());
    System.out.println("test2isCloseMethod(): " + test2isCloseMethod());

    //test Hop()
    System.out.println("testTigerHopMethod(): " + testTigerHopMethod());

    //test scanForThreat()
    System.out.println("test1DeerScanForThreatMethod(): " + test1DeerScanForThreatMethod());
    System.out.println("test2DeerScanForThreatMethod(): " + test2DeerScanForThreatMethod());

    //test getDeerEaten
    System.out.println("testGetDeerEaten(): " + testGetDeerEaten());

    //test clear()
    System.out.println("testClear(): " + testClear());


    // close PApplet display window (No need for the graphic mode for these tests)
    park.exit();

  }
}
