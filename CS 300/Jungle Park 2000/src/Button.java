//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Button.java
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
 * Button class:
 *
 * Handles the implementation of the Button class
 * Location, size, and how user interacts with it
 * @author Lucas Laibly
 *
 */
public class Button implements ParkGUI
{
  // Width of the Button
  private static final int WIDTH = 85;

  // Height of the Button
  private static final int HEIGHT = 32;

  // PApplet object where the button will be displayed
  protected JunglePark processing;

  // array storing x and y positions of the Button with respect to
  // the display window
  private float[] position;
  // text/label that represents the button
  protected String label;

  /**
   * Builds the button and displays it for the size X and Y passed into the method
   *
   * @param x the x coordinate of button
   * @param y the y coordinate of button
   * @param processing PApplet object relating to the button
   *
   */
  public Button(float x, float y, JunglePark processing)
  {
    this.processing = processing;
    this.position = new float[2];
    this.position[0] = x;
    this.position[1] = y;
    this.label = "Button";
  }

  /**
   * Draws the button to the display window. Fills and applies appropriate text to the button
   */
  @Override
  public void draw() {
    this.processing.stroke(0);// set line value to black
    if (isMouseOver())
      processing.fill(100); // set the fill color to dark gray if the mouse is over the button
    else
      processing.fill(200); // set the fill color to light gray otherwise

    // draw the button (rectangle with a centered text)
    processing.rect(position[0] - WIDTH / 2.0f, position[1] - HEIGHT / 2.0f,
        position[0] + WIDTH / 2.0f, position[1] + HEIGHT / 2.0f);
    processing.fill(0); // set the fill color to black
    processing.text(label, position[0], position[1]); // display the text of the current button
  }

  /**
   * Checks if the mouse is over the given button object as long as the mouse is over said object
   *
   * print "A button was pressed" for each time the button was pressed
   */
  @Override
  public void mousePressed() {
    if (isMouseOver())
      System.out.println("A button was pressed.");
  }

  @Override
  public void mouseReleased() {}

  /**
   * Checks if the mouse is over the given tiger object
   *
   * @return true if the mouse is over the given button object, false otherwise
   */
  @Override
  public boolean isMouseOver()
  {
    //ensure the mouse is within the boundaries of the button -> return true
    if (this.processing.mouseX > this.position[0] - WIDTH / 2
        && this.processing.mouseX < this.position[0] + WIDTH / 2
        && this.processing.mouseY > this.position[1] - HEIGHT / 2
        && this.processing.mouseY < this.position[1] + HEIGHT / 2)
      return true;
    //if mouse is not within the boundaries return false
    return false;
  }
}
