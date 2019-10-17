//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           StorageUnitTests.java
// Files:           Box.java LinkedBoxList.java LinkedBoxNode.java
//                  StorageUnitTest.java
// Course:          CS 300 Summer 2019
//
// Author:          Lucas Laibly
// Email:           laibly@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    Yoo Sung Jang
// Partner Email:   yjang43@wisc.edu
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
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
/**
 * Handle all creations of type Box
 *
 * @author Lucas Laibly
 * @author Yoo Sung Jang
 */
public class StorageUnitTests
{
    /**
     * Checks whether the behavior of equals method is correct
     */
    public static boolean testBoxEquals()
    {
        boolean passed = true;

        //create two new boxs that are different
        Box box = new Box(4,4);
        Box otherBox = new Box(5,5);

        //ensure we do evaluate them as teh same
        if(box.equals(otherBox))
        {
            System.out.println("Box's should be equal, but testBoxEquals method is incorrect");
            passed = false;
        }

        return passed;
    }

    /**
     * checks if box1 is equal to box2 returns true
     */
    public static boolean testBoxEquals2()
    {
        boolean passed = false;

        //make two new boxes that are identical
        Box boxOne = new Box(5,4 );
        Box boxTwo = new Box(5,4 );

        //make sure we eval them as the same
        if (boxOne.equals(boxTwo))
        {
            passed = true;
        }

        return passed;
    }

    /**
     * Checks whether the behavior of compareTo method is correctly implemented
     */
    public static boolean testBoxCompareTo()
    {
        boolean passed = true;

        //make two new boxs which are different
        Box box = new Box(29,29);
        Box otherBox = new Box(5,5);

        //make sure we get a 1 in return
        if(!(box.compareTo(otherBox) > 1))
        {
            System.out.println("compareTo should return 1, but testBoxCompareTo method is incorrect");
            passed = false;
        }

        return passed;
    }

    /**
     * checks if weight box1 less than weight box2 returns -1
     */
    public static boolean testBoxCompareTo2()
    {
        boolean passed = false;

        //make two new boxes that are different
        Box boxOne = new Box(1, 2);
        Box boxTwo = new Box(4, 3);

        //ensure we get a -1
        if (boxOne.compareTo(boxTwo) == -1)
        {
            passed = true;
        }

        return passed;
    }

    /**
     * checks if weight box1 greater than weight box2 returns 1
     */
    public static boolean testBoxCompareTo3()
    {
        boolean passed = false;

        //two new boxes which are differnt
        Box boxOne = new Box(1, 2);
        Box boxTwo = new Box(4, 1);

        //get a 1 -> greater tahn
        if (boxOne.compareTo(boxTwo) == 1)
        {
            passed = true;
        }

        return passed;
    }

    /**
     * Ensures the weight and the color are being made correctly
     */
    public static boolean testColorAndWeight()
    {
        boolean passed = true;
        Box box = new Box(29,29);

        //test getWeigth
        if(box.getWeight() != 29)
        {
            System.out.println("Box did not return with the correct weight.");
            passed = false;
        }

        //test getColor
        if(box.getColor() != 29)
        {
            System.out.println("Box did not return with the correct color.");
            passed = false;
        }

        return passed;
    }

    /**
     * Ensures get and set function correctly
     */
    public static boolean testGetAndSet()
    {
        boolean passed = true;

        // ultiple of the same box
        Box box = new Box(29,29);
        Box boxTw = new Box(29,29);
        Box boxThr = new Box(29,29);

        //make the nodes
        LinkedBoxNode firstNode = new LinkedBoxNode(box);
        LinkedBoxNode secondNode = new LinkedBoxNode(boxTw);
        LinkedBoxNode thirdNode = new LinkedBoxNode(boxThr);

        //link them together
        firstNode.setNext(secondNode);
        secondNode.setNext(thirdNode);

        //ensure they are linked in the correct order
        if(!firstNode.getNext().getNext().equals(thirdNode))
        {
            System.out.println("Program did not correctly chain together multiple nodes.");
            passed = false;
        }

        return passed;
    }

    /**
     * Basic Add box's
     */
    public static boolean testLinkedBoxListAdd()
    {
        boolean passed = true;

        //new list with a new capacity
        LinkedBoxList newList = new LinkedBoxList(2);

        //two new boxes to add
        Box tempBoxOne = new Box();
        Box tempBoxTwo = new Box();

        //add the new boxes
        newList.add(tempBoxOne);
        newList.add(tempBoxTwo);

        //ensure they were added
        if(newList.size() != 2)
        {
            System.out.println("List did not correctly add two new boxes.");
            passed = false;
        }

        return passed;
    }

    /**
     * Basic Add box in between two others
     */
    public static boolean testLinkedBoxListAdd2()
    {
        boolean passed = true;

        //new list with a new capacity
        LinkedBoxList newList = new LinkedBoxList(3);

        //two new boxes to add
        Box tempBoxOne = new Box(20,20);
        Box tempBoxTwo = new Box(10,10);

        //add the new boxes
        newList.add(tempBoxOne);
        newList.add(tempBoxTwo);

        //make middle box
        Box tempBoxThree = new Box(15,15);

        //add middle box
        newList.add(tempBoxThree);

        //ensure it was added in the middle
        if(!newList.get(1).equals(tempBoxThree))
        {
            System.out.println("Adding a box between two others did not correctly work.");
            System.out.println(newList.get(0).getWeight());
            System.out.println(newList.get(1).getWeight());
            System.out.println(newList.get(2).getWeight());
            passed = false;
        }


        return passed;
    }

    /**
     * Basic add null box -> test for error thrown
     */
    public static boolean testLinkedBoxListAdd3()
    {
        boolean passed = false;

        try{
            //new list with a new capacity
            LinkedBoxList newList = new LinkedBoxList(3);

            //two new boxes to add
            Box tempBoxOne = null;

            //add the null box
            newList.add(tempBoxOne);
        }
        //ensure the error is thrown
        catch(IllegalArgumentException e)
        {
            passed = true;
        }

        return passed;
    }

    /**
     * Basic Add box which exceeds the capacity
     */
    public static boolean testLinkedBoxListAdd4()
    {
        boolean passed = false;

        try{
            //new list with a new capacity
            LinkedBoxList newList = new LinkedBoxList(2);

            //two new boxes to add
            Box tempBoxOne = new Box(20,20);
            Box tempBoxTwo = new Box(10,10);

            //add the new boxes
            newList.add(tempBoxOne);
            newList.add(tempBoxTwo);

            //make the broken box
            Box tempBoxThree = new Box(5,5);

            //add box to blow out capacity
            newList.add(tempBoxThree);
        }
        //catch thrown error
        catch(IllegalStateException e)
        {
            passed = true;
        }

        return passed;
    }

    /**
     * checks LinkedBoxNode constructor
     */
    public static boolean testLinkedBoxNode()
    {
        boolean passed = true;

        //null box node
        LinkedBoxNode boxOne = new LinkedBoxNode(null);

        //ensure we dont have a null box
        if (boxOne.getBox() != null)
        {
            passed = false;
        }

        return passed;
    }

    /**
     * checks LinkedBoxNode constructor
     */
    public static boolean testLinkedBoxNode2()
    {
        boolean passed = false;

        //new box and linked node box
        Box box = new Box();
        LinkedBoxNode boxOne = new LinkedBoxNode(box);

        //test that they are equal
        if (boxOne.getBox().equals(box))
        {
            //..and not null
            if (boxOne.getNext() == null)
            {
                passed = true;
            }
        }

        return passed;
    }

    /**
     * Checks whether remove method defined in your LinkedBoxList works correctly
     */
    public static boolean testLinkedBoxListRemove()
    {
        boolean passed = true;

        //new linked list to hold two boxes -> make those boxes
        LinkedBoxList newList = new LinkedBoxList(2);
        Box tempBoxOne = new Box();
        Box tempBoxTwo = new Box();

        //add them to the list
        newList.add(tempBoxOne);
        newList.add(tempBoxTwo);

        //remove one of the nodes
        newList.remove(1);

        //ensure it was removed
        if(newList.size() != 1)
        {
            System.out.println("List did not correctly remove one box.");
            passed = false;
        }

        return passed;
    }

    /**
     * checks exception handling in remove method
     */
    public static boolean testLinkedBoxListRemove2()
    {
        boolean passed = false;
        try
        {
            //make a list of 5, and add a box
            LinkedBoxList linkedBoxList = new LinkedBoxList(5);
            linkedBoxList.add(new Box(1, 14));

            //remove from beyond where we can reach
            linkedBoxList.remove(2);
        }
        //catch the inbound exception
        catch (IndexOutOfBoundsException a)
        {
            passed = true;
        }

        return passed;
    }

    /**
     * Checks box contains method
     */
    public static boolean testLinkedBoxListContains()
    {
        boolean passed = true;

        //mkae a list of 2 and a new Box
        LinkedBoxList newList = new LinkedBoxList(2);
        Box tempBoxOne = new Box(25,25);

        //add said box
        newList.add(tempBoxOne);

        //ensure it is in the list via contains
        if(!newList.contains(tempBoxOne))
        {
            System.out.println("List does not contain the correct box.");
            passed = false;
        }

        return passed;
    }

    /**
     * Checks box clear method
     */
    public static boolean testLinkedBoxListClear()
    {
        boolean passed = true;

        //new linked list of 2 -> make a box for it
        LinkedBoxList newList = new LinkedBoxList(2);
        Box tempBoxOne = new Box();

        //add box
        newList.add(tempBoxOne);

        //clear the list
        newList.clear();

        //make sure it is not in the list anymore
        if(newList.size() != 0)
        {
            System.out.println("List did not correctly clear.");
            passed = false;
        }

        return passed;
    }

    /**
     * call all the tests
     */
    public static void main(String[] args)
    {
        //equals method tests
        System.out.println("testBoxEquals(): " + testBoxEquals());
        System.out.println("testBoxEquals2(): " + testBoxEquals2());


        //compare to method tests
        System.out.println("testBoxCompareTo(): " + testBoxCompareTo());
        System.out.println("testBoxCompareTo2(): " + testBoxCompareTo2());
        System.out.println("testBoxCompareTo3(): " + testBoxCompareTo3());

        //color weight tests
        System.out.println("testColorAndWeight(): " + testColorAndWeight());

        //get and set tests
        System.out.println("testGetAndSet(): " + testGetAndSet());

        //BoxNode function tests
        System.out.println("testLinkedBoxNode(): " + testLinkedBoxNode());
        System.out.println("testLinkedBoxNode2(): " + testLinkedBoxNode2());

        //remove method tests
        System.out.println("testLinkedBoxListRemove(): " + testLinkedBoxListRemove());
        System.out.println("testLinkedBoxListRemove2(): " + testLinkedBoxListRemove2());

        //contains test
        System.out.println("testLinkedBoxListContains(): " + testLinkedBoxListContains());

        //clear tests
        System.out.println("testLinkedBoxListClear(): " + testLinkedBoxListClear());

        //add method test
        System.out.println("testLinkedBoxListAdd(): " + testLinkedBoxListAdd());
        System.out.println("testLinkedBoxListAdd2(): " + testLinkedBoxListAdd2());
        System.out.println("testLinkedBoxListAdd3(): " + testLinkedBoxListAdd3());
        System.out.println("testLinkedBoxListAdd4(): " + testLinkedBoxListAdd4());



    }
}
