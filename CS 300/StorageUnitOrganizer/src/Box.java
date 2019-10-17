//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: Box.java
// Files: Box.java LinkedBoxList.java LinkedBoxNode.java
// StorageUnitTest.java
// Course: CS 300 Summer 2019
//
// Author: Yoo Sung Jang
// Email: yjang43@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Lucas Laibly
// Partner Email: laibly@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// X Write-up states that pair programming is allowed for this assignment.
// X We have both read and understand the course Pair Programming Policy.
// X We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (identify each person and describe their help in detail)
// Online Sources: (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.*;

/**
 * 
 * This class represents any Boxes in StorageUnitOrganization program
 * @author Lucas Laibly
 * @author Yoo Sung Jang
 */
public class Box implements Comparable<Box> {
  // generator of random numbers
  private static Random randGen = new Random();

  // color of this box
  private int color;

  // weight of this box in lbs between 1 inclusive and 31 exclusive
  private int weight;

  /**
   * Creates a box, and randomizes weight/color
   */
  public Box() {
    weight = randGen.nextInt(30) + 1;
    color = randGen.nextInt();
  }

  /**
   * Creates a new Box and initializes its instance fields color and weight to the specified values
   * Throws IllegalArgumentException if the provided weight value is out of the range [1..30]
   *
   * @param color  specified integer value to set the color
   * @param weight specified integer value to set the weight
   */
  public Box(int color, int weight) throws IllegalArgumentException {
    // ensure the weight is within the range
    if (weight < 0 || weight > 31) {
      // throw proper exception
      throw new IllegalArgumentException("Weight is not between 1 and 30.");
    }

    // else -> set the color and weight with what is given
    this.color = color;
    this.weight = weight;

  }

  /**
   * equals method defined in Object class
   *
   * @param other the object under eval to see if it equals the current box
   * @return return true if box is equal false othewise
   */
  @Override
  public boolean equals(Object other)
  {
      //ensures that we haev a box type
      if(other instanceof Box)
      {
          //cast the object as a Box type
          Box temp = (Box)other;

          //if it matches in color and weight we will return true
          if(this.color == temp.color && this.weight == temp.weight)
          {
              return true;
          }
      }

      //otherwise, return false
      return false;
  }

  /**
   * compareTo method defined in Comparable<Box> interface
   *
   * @param otherBox the box which we are wanting to compare to
   * @return negative if instance is lighter 0 if same and positive if heavier
   */
  @Override
  public int compareTo(Box otherBox)
  {
    return this.getWeight() - otherBox.getWeight();
  }

  /**
   * Getter for the instance field color of this box
   * 
   * @return color
   */
  public int getColor() {
    return color;
  }

  /**
   * Getter for instance field weight of this box
   * @return box
   */
  public int getWeight() {
    return weight;
  }
}
