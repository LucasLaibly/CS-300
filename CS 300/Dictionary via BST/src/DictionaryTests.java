//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           DictionaryTests.java
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
 * Class to tests all aspects of the DictionaryBST program
 *
 * @author Lucas Laibly
 *
 */
public class DictionaryTests
{
    public static boolean testDictionaryNullWord()
    {
        //boolean to eval if test passed
        boolean passed = false;

        //try making a dictionary word with null
        try
        {
            DictionaryWord nullWord = new DictionaryWord(null, "temp sentence");
        }
        catch(IllegalArgumentException e)
        {
            passed = true;
        }

        return passed;
    }

    public static boolean testDictionaryEmptyWord()
    {
        //boolean to eval if test passed
        boolean passed = false;

        //try making a dictionary word with null
        try
        {
            DictionaryWord nullWord = new DictionaryWord("", "temp sentence");
        }
        catch(IllegalArgumentException e)
        {
            passed = true;
        }

        return passed;
    }

    public static boolean testDictionaryNllMeaning()
    {
        //boolean to eval if test passed
        boolean passed = false;

        //try making a dictionary word with null
        try
        {
            DictionaryWord nullWord = new DictionaryWord("test", null);
        }
        catch(IllegalArgumentException e)
        {
            passed = true;
        }

        return passed;
    }

    public static boolean testDictionaryEmptyMeaning()
    {
        //boolean to eval if test passed
        boolean passed = false;

        //try making a dictionary word with null
        try
        {
            DictionaryWord nullWord = new DictionaryWord("test", "");
        }
        catch(IllegalArgumentException e)
        {
            passed = true;
        }

        return passed;
    }

    public static boolean testDictionaryEmptyTree()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //ensure the tree is empty
        if(!tempTree.isEmpty())
        {
            System.out.println("isEmpty incorrectly returned that the tree was empty.");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionaryNotEmptyTree()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //add a word to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");

        //ensure the tree is empty
        if(tempTree.isEmpty())
        {
            System.out.println("isEmpty incorrectly returned that the tree was empty.");
            passed = false;
        }

        return passed;
    }

    public static boolean testAdd()
    {
        //boolean to eval if test passed
        boolean passed = true;

        //temp root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //add values to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");
        tempTree.addWord("Gigantic", "adj. Huge, giant-like.");

        //ensure the tree is not empty
        if(tempTree.isEmpty())
        {
            System.out.println("Tree reported being empty, but should not be. Errors with add method.");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionaryLookUpTrue()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //add a word to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");

        //search tree for value known to be there
        try
        {
            tempTree.lookup("exceptional");
        }
        //if the NoSuchEle error is thrown -> incorrect
        catch(NoSuchElementException e)
        {
            System.out.println("Lookup deployed error when it should not.");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionaryLookUpFalse()
    {
        //boolean to eval is test passed
        boolean passed = false;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //add a word to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");

        //search tree for value known to be there
        try
        {
            tempTree.lookup("Computer");
        }
        //if the NoSuchEle error is thrown -> incorrect
        catch(NoSuchElementException e)
        {
            passed = true;
        }

        return passed;
    }

    public static boolean testDictionarySizeFull()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //add a word to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");
        tempTree.addWord("Gigantic", "adj. Huge, giant-like.");
        tempTree.addWord("Notinschool", "adj. not being in school anymore");

        //ensure the tree size returns correctly
        if(tempTree.size() != 3)
        {
            System.out.println("size incorrectly returned the size fo the tree");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionarySizeEmpty()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //ensure the tree size returns correctly
        if(tempTree.size() != 0)
        {
            System.out.println("size incorrectly returned the size fo the tree");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionaryHeight()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //add a word to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");
        tempTree.addWord("Gigantic", "adj. Huge, giant-like.");
        tempTree.addWord("Notinschool", "adj. not being in school anymore");

        //ensure the tree size returns correctly
        if(tempTree.height() != 3)
        {
            System.out.println("height incorrectly returned the height of the tree");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionaryHeightTwo()
    {
        //boolean to eval is test passed
        boolean passed = true;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //ensure the tree size returns correctly
        if(tempTree.height() != 0)
        {
            System.out.println("height incorrectly returned the height of the tree");
            passed = false;
        }

        return passed;
    }

    public static boolean testDictionaryGAW()
    {
        //boolean to eval is test passed
        boolean passed = false;

        //temporary root and tree to use
        DictionaryWord root;
        DictionaryBST tempTree = new DictionaryBST();

        //holds all the words in the tree
        ArrayList<String> tempWordList = new ArrayList<String>();

        //add a word to the tree
        tempTree.addWord("exceptional", "adj. forming an exception, unusual, outstanding.");
        tempTree.addWord("Gigantic", "adj. Huge, giant-like.");
        tempTree.addWord("Notinschool", "adj. not being in school anymore");

        //fill the wordsList
        tempWordList = tempTree.getAllWords();

        //ensure all the words are within the list
        if(tempWordList.contains("exceptional"))
        {
            if(tempWordList.contains("Gigantic"))
            {
                if(tempWordList.contains("Notinschool"))
                {
                    passed = true;
                }
            }
        }

        return passed;
    }

    public static void main(String[] args)
    {
        System.out.println("testDictionaryNullWord(): " + testDictionaryNullWord());
        System.out.println("testDictionaryEmptyWord(): " + testDictionaryEmptyWord());
        System.out.println("testDictionaryNllMeaning(): " + testDictionaryNllMeaning());

        System.out.println("testDictionaryEmptyMeaning(): " + testDictionaryEmptyMeaning());
        System.out.println("testDictionaryEmptyTree(): " + testDictionaryEmptyTree());

        System.out.println("testDictionaryNotEmptyTree(): " + testDictionaryNotEmptyTree());

        System.out.println("testAdd(): " + testAdd());

        System.out.println("testDictionaryLookUpTrue(): " + testDictionaryLookUpTrue());
        System.out.println("testDictionaryLookUpFalse(): " + testDictionaryLookUpFalse());

        System.out.println("testDictionarySizeFull(): " + testDictionarySizeFull());
        System.out.println("testDictionarySizeEmpty(): " + testDictionarySizeEmpty());

        System.out.println("testDictionaryHeight(): " + testDictionaryHeight());
        System.out.println("testDictionaryHeightTwo(): " + testDictionaryHeightTwo());

        System.out.println("testDictionaryGAW(): " + testDictionaryGAW());
    }
}
