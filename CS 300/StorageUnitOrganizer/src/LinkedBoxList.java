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
 * This class is the LinkedBoxList and appropriate fields
 * @author Lucas Laibly
 * @author Yoo Sung Jang
 */
public class LinkedBoxList {
  // head of this LinkedBoxList (refers to the element
  // stored at index 0 within this list)
  private LinkedBoxNode head;

  // number of boxes already stored in this list
  private int size;

  // capacity of this LinkedBoxList
  private int capacity;

  /**
   * Maximum number of box elements that this LinkedBoxList can store Creates an empty LinkedBoxList
   * with a given initial capacity
   *
   * @param capacity the amount of items the list can hold
   */
  public LinkedBoxList(int capacity) {
    // set the capacity
    this.capacity = capacity;
  }

  /**
   * Returns the size of this list
   * @return size
   */
  public int size() {
    return size;
  }

  /**
   * Return the capacity of this list
   * @return capacity
   */
  public int getCapacity() {
    return capacity;
  }

  /**
   * Expands the capacity of this LinkedBoxList with the specified number a of additional elements
   *
   * @param a the value at which to expand the capacity with
   */
  public void expandCapacity(int a) {
    capacity += a;
  }

  /**
   * Checks whether this LinkedBoxList is empty Returns true if this LinkedBoxList is empty, false
   * otherwise
   * @return true if empty false otherwise
   */
  public boolean isEmpty() {
    // if the size is 0, there is nothing in the list
    if (size == 0) {
      return true;
    }
    // otherwise, there is something in the list
    return false;
  }


  /**
   * Checks whether this LinkedBoxList is full Returns true if this list is full, false otherwise
   * @return true if full and false otherwise
   */
  public boolean isFull() {
    if (size == capacity) {
      return true;
    } 
    return false;
  }

  /**
   * Adds a new box into this sorted list Throws IllegalArgumentException if newBox is null Throws
   * IllegalStateException if this list is full
   *
   * @param newBox the new box that is to be added to the list
   * @throws IllegalArgumentException if parameter is null error
   * @throws IllegalStateException if capacity full error
   */
  public void add(Box newBox) throws IllegalArgumentException, IllegalStateException
  {
    // if the box to add is null, throw exception
    if (newBox == null) {
      throw new IllegalArgumentException("Attempt to add a null box");
    }

    // if the list is completely full, throw exception
    if (isFull()) {
      throw new IllegalStateException("List is full, cannot add any more box's");
    }

    // made the node box to add from the newBox passed
    LinkedBoxNode boxToAdd = new LinkedBoxNode(newBox);

    // if the head is null, the newest box becomes the head
    if (head == null)
    {
      // set head, and increment the size by 1
      head = boxToAdd;

      // increment the size
      size++;
    }

    else {

      // the newbox is heavier than the head
      if (head.getBox().compareTo(newBox) < 0)
      {
        // look to "swap" positions of head and newBox
        LinkedBoxNode tmp = head;
        head = boxToAdd;
        head.setNext(tmp);

        // increment the size by 1
        size++;
      }

      else {
        // make two new nodes, one that is always behind by one, and a head node
        LinkedBoxNode prevNode = null;
        LinkedBoxNode node = head;

        // iterate over the entire list
        for (int i = 0; i < size(); i++)
        {

          // if i is at at the end
          if (i == size() - 1)
          {
            // and the newBox weight is less than
            if (node.getBox().compareTo(newBox) < 0)
            {
              // insert and connect
              prevNode.setNext(boxToAdd);
              boxToAdd.setNext(node);
            }

            else {
              // otherwise, just add the box to the end
              node.setNext(boxToAdd);
            }
          }

          // if the newBox is heavier than the node in eval
          if (node.getBox().compareTo(newBox) < 0)
          {
            // connect prevNode to the newBox, then reconnect the newBox to the remaining tail
            prevNode.setNext(boxToAdd);
            boxToAdd.setNext(node);
            break;
          }

          // increment the previous node and update what node we are looking at
          prevNode = node;
          node = node.getNext();
        }

        // once the box has been added, we want to increment
        size++;
      }
    }
  }

  /**
   * Checks if this list contains a box that matches with (equals) a specific box object Returns
   * true if this list contains findBox, false otherwise
   *
   * @param findBox the box we are looking to find in the list
   * @return true if the list contains the value
   */
  public boolean contains(Box findBox) {
    // set the current node to the head of the list
    LinkedBoxNode node = head;

    // iterate over the entire list
    for (int i = 0; i < size(); i++) {
      // if hte box the node
      if (node.getBox().equals(findBox)) {
        return true;
      }
      // increment the node we are looking at
      node = node.getNext();
    }

    // if box cannot be found, return false
    return false;
  }

  /**
   * Returns a box stored in this list given its index Throws IndexOutOfBoundsException if index is
   * out of the range 0..size-1
   *
   * @param index index looking to be retreived from
   * @return get the box
   * @throws IndexOutOfBoundsException if out of bound throw an error 0 ~ size
   */
  public Box get(int index) throws IndexOutOfBoundsException {
    // ensure the index is valid within the specified range
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException("Index given is not within the list parameters in get()");
    }

    // make a temporary node pointing the head
    LinkedBoxNode temp = head;

    // iterate over the list
    for (int i = 0; i < size; i++) {
      // if the index is where we are at in the list
      if (i == index) {
        // return that node
        return temp.getBox();
      }

      // otherwise increment the node we are looking at
      else {
        temp = temp.getNext();
      }
    }

    // should never be thrown
    // but for some reason we the index we are given is within the specified range
    // AND not found in the list -> throw an Index exception
    throw new IndexOutOfBoundsException(
        "Index is out of bounds, and was not caught by earlier checks");
  }

  /*
   * 8) return value in java doc is omitted. I did not check for this for other method so we should
   * check for all
   */
  /**
   * Removes a returns the box stored at index from this LinkedBoxList Throws
   * IndexOutOfBoundsException if index is out of bounds. index should be in the range of [0..
   * size()-1]
   *
   * @param index index looking to be removed
   * @return box being removed
   * @throws IndexOutOfBoundsException if index 0 ~ 30
   */
  public Box remove(int index) throws IndexOutOfBoundsException {
    // ensure the index is within the specified range -> throw exception otherwise
    if (index < 0 || index > size() - 1) {
      throw new IndexOutOfBoundsException();
    }

    // make a node which is behind by one, and a node that is the current place we are looking
    LinkedBoxNode prevNode = null;
    LinkedBoxNode node = head;

    // iterate over the list
    for (int i = 0; i < index; i++) {
      // position ourselves at the node to remove
      prevNode = node;
      node = node.getNext();
    }

    // ensure the previous node is nto null
    if (prevNode != null) {
      // set the previous node to two ahead of itself
      prevNode.setNext(node.getNext());
    }

    // otherwise make hte head point the node two ahead of it
    else {
      head = node.getNext();
    }

    // decrement size
    size--;
    return node.getBox();
  }

  /**
   * Removes all the boxes from this list
   */
  public void clear() {
    // set head to null, and size to zero
    head = null;
    size = 0;
  }

  /**
   * Returns a String representation for this LinkedBoxList
   * @return return string representation of the instance
   */
  @Override
  public String toString() {
    StringBuilder result = new StringBuilder(); // creates a StringBuilder object
    String newLine = System.getProperty("line.separator");
    result.append("------------------------------------------------" + newLine);
    if (!isEmpty()) {
      LinkedBoxNode runner = head;
      int index = 0;
      // traverse the list and add a String representation for each box
      while (runner != null) {
        result.insert(0,
            "Box at index " + index + ": " + runner.getBox().getWeight() + " lbs" + newLine);
        runner = runner.getNext();
        index++;
      }
      result.insert(0, "Box List Content:" + newLine);
    }
    result.insert(0, "List size: " + size + " box(es)." + newLine);
    result.insert(0, "Box List is empty: " + isEmpty() + newLine);
    result.insert(0, "------------------------------------------------" + newLine);
    return result.toString();
  }
}
