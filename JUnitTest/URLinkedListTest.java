import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class URLinkedListTest {

private URLinkedList<Integer> testLinkedList;
	
	@BeforeClass
	public static void runsBeforeTheTest(){		
		System.out.println("Start testing URArrayList");	
	}
	
	@Before
	public void runOnceBeforeEachTestMethod(){
		//System.out.println("Run before each test method.");
		testLinkedList = new URLinkedList<Integer>();
	}
	
	@Test
	//Is Empty: True
	public void testIsEmpty(){
		//System.out.println("Test isEmpty() returns true");
		assertTrue(testLinkedList.isEmpty());
	}
	
	@Test
	//Add
	public void testAddElemWOItr(){
		//System.out.println("Test add() and print with index");
		int[] testElem = new int[]{3, 6, 5, 1, 4};
		for(int i: testElem){
			testLinkedList.add(i);
		}
		String testOut = "";
		for(int i = 0; i < 5; i++){
			testOut += (testLinkedList.get(i) + " ");
		}
		assertEquals("3 6 5 1 4 ", testOut);
	}
	
	@Test
	//Iterator
	public void testAddElemWithItr(){
		//System.out.println("Test add() and print with iterator");
		int[] testElem = new int[]{3, 6, 5, 1, 4};		
		for(int i: testElem){
			testLinkedList.add(i);
		}
		String testOut = "";
		for(int i: testLinkedList){
			testOut += (i + " ");
		}
		assertEquals("3 6 5 1 4 ", testOut);
	}
	
	@Test
	//Is Empty: False
	public void testIsNotEmpty(){
		testLinkedList.add(2);
		//System.out.println("Test isEmpty() returns false");
		assertFalse(testLinkedList.isEmpty());
	}
	
	@Test
	//Add all
	public void testAddAll(){
		//System.out.println("Test addAll() as a list and print with iterator");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testLinkedList.addAll(test);
		String testOut = "";
		for(int i: testLinkedList){
			testOut += (i + " ");
		}
		assertEquals("3 6 5 1 4 ", testOut);
	}
	
	@Test
	//Add all at index
	public void testAddAllAtIndex(){
		//System.out.println("Test addAllAtIndex() as a list");
		//System.out.println("At index 2 of (4,9,11,15), then print with iterator");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		testLinkedList.addAll(2, test);
		String testOut = "";
		for(int i: testLinkedList){
			testOut += (i + " ");
		}
		//System.out.println(testOut);
		assertEquals("4 9 3 6 5 1 4 11 15 ", testOut);
	}
	
	@Test
	//Test clear()
	public void testClear(){
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		testLinkedList.clear();
		//System.out.println("Test clear");
		assertTrue(testLinkedList.isEmpty());
	}
	
	@Test
	//Contains: Return True
	public void testContainsTrue(){
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		//System.out.println("Test contains() returns true");
		//System.out.println(testLinkedList.contains(9));
		assertTrue(testLinkedList.contains(9));
	}
	
	@Test
	//Contains: Return False
	public void testContainsFalse(){
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		//System.out.println("Test contains() returns false");
		//System.out.println(testLinkedList.contains(12));
		assertTrue(!testLinkedList.contains(12));
	}
	
	@Test
	//Contains All: Return True
	public void testContainsAllTrue(){
		//System.out.println("Test containsAll() returns true");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testLinkedList.add(4);
		testLinkedList.add(11);
		testLinkedList.add(3);
		testLinkedList.add(15);
		testLinkedList.add(6);
		testLinkedList.add(5);
		testLinkedList.add(1);
		testLinkedList.add(9);
		testLinkedList.add(4);
		//System.out.println(testLinkedList.containsAll(test));
		assertTrue(testLinkedList.containsAll(test));
	}
	
	@Test
	//Contains All: Return false
	public void testContainsAllFalse(){
		//System.out.println("Test containsAll() turns false");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		testLinkedList.add(3);
		testLinkedList.add(5);
		testLinkedList.add(4);
		//System.out.println(testLinkedList.containsAll(test));
		assertTrue(!testLinkedList.containsAll(test));
	}
	
	@Test
	//Equals: Return True
	public void testEqualsTrue(){
		URList<Integer> test1 = new URLinkedList<Integer>();
		test1.add(1);
		test1.add(110);
		test1.add(100);
		test1.add(114);
		test1.add(101);
		test1.add(115);
		URList<Integer> test2 = new URLinkedList<Integer>();
		test2.add(1);
		test2.add(110);
		test2.add(100);
		test2.add(114);
		test2.add(101);
		test2.add(115);
		//System.out.println(test1.equals(test2));
		assertTrue(test1.equals(test2));
	}
	
	@Test
	//Equals: Return False
	public void testEqualsFalse(){
		URList<Integer> test1 = new URLinkedList<Integer>();
		test1.add(1);
		test1.add(110);
		test1.add(100);
		test1.add(114);
		test1.add(101);
		test1.add(115);
		URList<Integer> test2 = new URLinkedList<Integer>();
		test2.add(15);
		test2.add(108);
		test2.add(108);
		test2.add(97);
		test2.add(114);
		test2.add(118);
		test2.add(101);
		test2.add(122);
		//System.out.println(test1.equals(test2));
		assertFalse(test1.equals(test2));
	}
	
	@Test
	//get()
	public void testGet(){
		
	}
	
	@Test
	//indexOf()
	public void testIndexOf(){
		
	}
	
	@Test
	//remove()
	public void testRemove(){
		
	}
	
	@Test
	//boolean remove() true
	public void testBoolRemoveTrue(){
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		testLinkedList.add(12);
		boolean result = testLinkedList.remove((Object) 11);
		String testOut = "";
		for(int i: testLinkedList){
			testOut += (i + " ");
		}
		//System.out.println(testOut);
		assertEquals(true, result);
		assertEquals("4 9 15 12 ", testOut);
	}
	
	@Test
	//boolean remove() false
	public void testBoolRemoveFalse(){
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		testLinkedList.add(12);
		boolean result = testLinkedList.remove((Object) 8);
		String testOut = "";
		for(int i: testLinkedList){
			testOut += (i + " ");
		}
		//System.out.println(testOut);
		assertEquals(false, result);
		assertEquals("4 9 11 15 12 ", testOut);
	}
	
	@Test
	//boolean removeAll() true
	public void testBoolRemoveAllTrue(){
		
	}
	
	@Test
	//boolean removeAll() false
	public void testBoolRemoveAllFalse(){
		
	}
	
	@Test
	//set()
	public void testSet(){
		testLinkedList.add(17);
		testLinkedList.add(19);
		testLinkedList.set(1,18);
		String testOut = "";
		for(int i: testLinkedList){
			testOut += (i + " ");
		}
		assertEquals("17 18 ", testOut);
	}
	
	@Test
	//size()
	public void testSize(){
		testLinkedList.add(4);
		testLinkedList.add(9);
		testLinkedList.add(11);
		testLinkedList.add(15);
		assertEquals(testLinkedList.size(),4);
	}
	
	@Test
	//subList()
	public void testSubList(){
		
	}
	
	@Test
	//toArray()
	public void testToArray(){
		
	}
	
	@Test
	//E peekFirst()
	public void testpeekFirst(){
		testLinkedList.add(99);
		testLinkedList.add(2);
		testLinkedList.add(3);
		testLinkedList.add(4);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(-99);
		
		assertTrue(testLinkedList.peekFirst() == 99);
	}
	
	@Test
	//E peekLast()
	public void testpeekLast(){
		testLinkedList.add(99);
		testLinkedList.add(2);
		testLinkedList.add(3);
		testLinkedList.add(4);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(1);
		testLinkedList.add(-99);
		
		assertTrue(testLinkedList.peekLast() == -99);
	}
	
	@Test
	//pollLast()
	public void testPollFirst() {
		System.out.println("Test Poll First");
		String res = ""; //holds their result
		testLinkedList.add(5);
		testLinkedList.add(9);
		testLinkedList.add(3);
		testLinkedList.add(2);
		testLinkedList.add(10);
		res += testLinkedList.pollFirst();
		String testRes = "5"; //holds what result should be
		assertEquals(testRes, res);
	}
	
	@Test
	//pollFirst()
	public void testPollLast() {
		System.out.println("Test Poll Last");
		String res = ""; //holds their result
		testLinkedList.add(5);
		testLinkedList.add(9);
		testLinkedList.add(3);
		testLinkedList.add(2);
		testLinkedList.add(10);
		res += testLinkedList.pollLast();
		String testRes = "10"; //holds what result should be
		assertEquals(testRes, res);
	}
	
	
	
	@After
	public void runOnceAfterEachTestMethod(){	
		//System.out.println("Run after each test method");
	}
	
	@AfterClass
	public static void runsAfterTheTest(){
		System.out.println("\nTests have been concluded");	
	}
	
}
