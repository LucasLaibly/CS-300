//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DictionaryWord.java
// Files:           DictionaryWord.java DictionaryBST.java DictionaryDriver.java
//                  DictionaryTest.java Dictionary.java
// Course:          CS 300 Summer 2019
//
// Author:          Lucas Laibly
// Email:           laibly@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    None
// Partner Email:   None
// Partner Lecturer's Name: Mouna Kacem
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
// Persons:         None
// Online Sources:  None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * Class to build the DictionaryWord object that holds the word, and provided meaning
 *
 * @author Lucas Laibly
 *
 */
public class DictionaryWord
{
    private final String word; // word that represents the search key for this dictionary word
    private final String meaning;   // The meaning of the word that this dictionary node defines
    private DictionaryWord leftChild;  // The leftChild of the the current WebPageNode
    private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

    /**
     * Creates a new dictionary word with the provided word and its meaning pair
     *
     * @param word the word desired to be added to the Dictionary
     * @param meaning the meaning of said word being added to the dictionary
     */
    public DictionaryWord(String word, String meaning)
    {
        //ensure the word is not null nor empty
        if(word == null || word == "")
        {
            throw new IllegalArgumentException("The word given is not accepted (null or empty).");
        }

        //ensure the meaning is not null nor empty
        if(meaning == null || meaning == "")
        {
            throw new IllegalArgumentException("The word meaning given is not accepted (null or empty).");
        }

        //set the word and meaning value
        this.word = word;
        this. meaning = meaning;
    }

    /**
     * Getter for the left child of this dictionary word
     */
    public DictionaryWord getLeftChild()
    {
        return this.leftChild;
    }

    /**
     * Setter for the left child of this dictionary word
     */
    public void setLeftChild(DictionaryWord leftChild)
    {
        this.leftChild = leftChild;
    }

    /**
     * Getter for the right child of this dictionary word
     */
    public DictionaryWord getRightChild()
    {
        return this.rightChild;
    }

    /**
     * Setter for the right child of this dictionary word
     */
    public void setRightChild(DictionaryWord rightChild)
    {
        this.rightChild = rightChild;
    }

    /**
     * Getter for the word of this dictionary word
     */
    public String getWord()
    {
        return this.word;
    }

    /**
     * Getter for the meaning of the word of this dictionary word
     */
    public String getMeaning()
    {
        return this.meaning;
    }

    /**
     * Returns a String representation of this DictionaryWord. This String is formatted as
     * follows. "word: meaning"
     *
     * @return String representing a dictionary word and its meaning
     */
    public String toString()
    {
        return this.word + ": " + this.meaning;
    }
}
