//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DictionaryBST.java
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

import java.util.NoSuchElementException;
import java.util.ArrayList;

/**
 * Class to build the Binary Search Tree which holds all the nodes of the various
 * DictionaryWords to be added to it
 *
 * @author Lucas Laibly
 *
 */
public class DictionaryBST implements Dictionary
{
    //root the tree to build from
    private DictionaryWord root;

    /**
     * This should be the only constructor of this class.
     * Creates an empty dictionaryBST.
     */
    public DictionaryBST()
    {
        root = null;
    }

    /**
     * Methods defined in the Dictionary interface
     */
    public boolean isEmpty()
    {
        //if the root is null, then there is nothing
        if(root == null)
        {
            return true;
        }

        //otherwise there is a tree
        return false;
    }

    /**
     * Add the given word with connected meaning to the tree
     *
     * @param word the word to be added
     * @param meaning the meaning of given word to be added
     */
    public boolean addWord(String word, String meaning)
    {
        //make a dictionary wrod object of hte word and meaning
        DictionaryWord newDictWord = new DictionaryWord(word, meaning);

        //check if the tree is empty -> the given becomes hte tree
        if(isEmpty())
        {
            root = newDictWord;
            return true;
        }

        //else, we call the addWordHelper to add the word and meaning
        if(addWordHelper(newDictWord, root))
        {
            return true;
        }

        //we have failed to add the word
        return false;
    }

    /**
     * Lookup the given word within the tree
     *
     * @param s the string (or word) we are looking for in the tree
     */
    public String lookup(String s)
    {
        //call helper method
        return lookupHelper(s, root);
    }

    /**
     * Find the size of the tree
     */
    public int size()
    {
        //temp int value to hold the size of the tree
        int bstSize = sizeHelper(root);

        //return that value
        return bstSize;
    }

    // Public methods not defined in the Dictionary interface
    /**
     * Computes and returns the height of this dictionaryBST, as the number of nodes
     * from root to the deepest leaf DictionaryWord node.
     *
     * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
     */
    public int height()
    {
        //temp int value to hold the height of hte tree
        int bstHeight = heightHelper(root);

        //return that value
        return bstHeight;
    }

    /**
     * Returns all the words within this dictionary sorted from A to Z
     *
     * @return an ArrayList that contains all the words within this dictionary sorted in
     *         the ascendant order
     */
    public ArrayList<String> getAllWords()
    {
        //temp arraylist to hold all the words
        ArrayList<String> allWordList = new ArrayList<String>();

        //getallwordshelper call to get all the words in the tree
        allWordList = getAllWordsHelper(root);

        //return the list of words
        return allWordList;
    }

    // Recursive private helper methods
    // Each public method should make call to the recursive helper method with the
    // corresponding name

    /**
     * Recursive helper method to add newWord in the subtree rooted at node
     *
     * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
     * @param current the current DictionaryWord that is the root of the subtree where
     *        newWord will be inserted
     * @return true if the newWordNode is successfully added to this dictionary, false otherwise
     */
    private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current)
    {
        //boolean to evaluate if we have found the word
        boolean found = false;

        //if we are less tahn the current -> go to the left of the tree
        if(newWordNode.toString().compareToIgnoreCase(current.getWord()) < 0)
        {
            //if the left is null,
            if(current.getLeftChild() == null)
            {
                //we add newWordNode as the left child
                current.setLeftChild(newWordNode);
                found = true;
            }

            //else,
            else
            {
                //go left, evalaute child to see where we should go
                addWordHelper(newWordNode, current.getLeftChild());
                found = true;
            }
        }

        //we are greater than the current -> go to the right of hte tree
        if(newWordNode.toString().compareToIgnoreCase(current.getWord()) > 0)
        {
            //if the right is null,
            if(current.getRightChild() == null)
            {
                //the right child becomes the newWordNode
                current.setRightChild(newWordNode);
                found = true;
            }

            //else,
            else
            {
                //we dig furhter to the right to find hte place of the newWordNode
                addWordHelper(newWordNode, current.getRightChild());
                found = true;
            }
        }

        //if we cannot find a spot -> we have a duplicate
        if(!found)
        {
            System.out.println("WARNING: Duplicate Entry.");
        }

        //return if we found a spot or not
        return found;
    }


    /**
     * Recursive helper method to lookup a word s in the subtree rooted at current
     *
     * @param s String that represents a word
     * @param current pointer to the current DictionaryWord within this dictionary
     * @return the meaning of the word s if it is present in this dictionary
     * @throws NoSuchElementException with significant error message if s is not found in this dictionary
     */
    private static String lookupHelper(String s, DictionaryWord current) throws NoSuchElementException
    {

        //check to ensure current is not null
        if(current == null)
        {
            //we cannot find a null vlaue
            throw new NoSuchElementException("The value entered cannot be found.");
        }

        //base case -> value is exact match
        else if(s.compareToIgnoreCase(current.getWord()) == 0)
        {
            //return the meaning
            return current.getMeaning();
        }

        //if less then -> we go left of the tree
        else if(s.compareToIgnoreCase(current.getWord()) < 0)
        {
            //go left
            return lookupHelper(s, current.getLeftChild());
        }

        //otherwise, we are going to go to the right
        return lookupHelper(s, current.getRightChild());
    }

    /**
     * Recursive helper method that returns the number of dictionary words stored in
     * the subtree rooted at current
     *
     * @param current current DictionaryWord within this dictionaryBST
     * @return the size of the subtree rooted at current
     */
    private static int sizeHelper(DictionaryWord current)
    {
        //base case -> gone through to the leaves
        if(current == null)
        {
            return 0;
        }

        //else, we go both left and right, adding 1 each time
        else
        {
            return (sizeHelper(current.getLeftChild()) + 1 + sizeHelper(current.getRightChild()));
        }
    }


    /**
     * Recursive helper method that computes the height of the subtree rooted at current
     *
     * @param current pointer to the current DictionaryWord within this DictionaryBST
     * @return height of the subtree rooted at current counting the number of
     * DictionaryWord nodes from the current node to the deepest leaf in the subtree
     * rooted at current
     */
    private static int heightHelper(DictionaryWord current)
    {
        //if current is null, base case, go back up the tree
        if(current == null)
        {
            return 0;
        }

        //else,
        else
        {
            //go down bleft hadn side of current node
            int heightL = heightHelper(current.getLeftChild());

            //go down the right hand side of hte current node
            int heightR = heightHelper(current.getRightChild());

            //if left and larger than right, add 1 to heightL
            if(heightL > heightR)
            {
                return heightL + 1;
            }

            else
            {
                //else addone to heightR
                return heightR +1;
            }
        }
    }

    /**
     * Recursive Helper method that returns a list of all the words stored in
     * the subtree rooted at current sorted alphabetically from A to Z
     *
     * @param current pointer to the current DictionaryWord within this dictionaryBST
     * @return an ArrayList of all the words stored in the subtree rooted at current
     */
    private static ArrayList<String> getAllWordsHelper(DictionaryWord current)
    {
        //temp arrayList
        ArrayList<String> getWordsList = new ArrayList<String>();

        //as long as current is not null
        if (current != null)
        {
            //get all words on left side -> continue readding to the arraylist
            getWordsList.addAll(getAllWordsHelper(current.getLeftChild()));

            //get the word of the current
            getWordsList.add(current.getWord());

            //get all words on right side -> continue readding to the arraylist
            getWordsList.addAll(getAllWordsHelper(current.getRightChild()));
        }

        //return the arraylist that now holds all the words in the list
        return getWordsList;
    }
}
