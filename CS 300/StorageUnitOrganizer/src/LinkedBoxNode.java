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

/**
 * This class is the LinkedBoxNode and appropriate fields
 * @author Lucas Laibly
 * @author Yoo Sung Jang
 */
public class LinkedBoxNode {
  private Box box; // box that represents the data for this Linked node
  private LinkedBoxNode next; // reference to the next Linked Box Node

  // constructors

  /**
   * creates a new LinkedBoxNode object with a given box and without referring to any next
   * LinkedBoxNode
   *
   * @param box box we are looking to make a node
   */
  public LinkedBoxNode(Box box) {
    this.box = box;
  }

  /**
   * creates a new LinkedBoxNode object and sets its instance fields box and next to the specified
   * ones
   *
   * @param box  box we are looking to make a node
   * @param next set the next node we are looking to
   */
  public LinkedBoxNode(Box box, LinkedBoxNode next) {
    this.box = box;
    this.next = next;
  }

  // getters and setters methods
  /**
   * get next address
   * @return return next
   */
  public LinkedBoxNode getNext() {
    return next;
  }

  /**
   * set the next node
   *
   * @param next the next node
   */
  public void setNext(LinkedBoxNode next) {
    this.next = next;
  }

  /**
   * get box
   * @return return box
   */
  public Box getBox() {
    return box;
  }

  /**
   * set box
   * @param box set box
   */
  public void setBox(Box box) {
    this.box = box;
  }
}
