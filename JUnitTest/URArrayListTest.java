import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * Created By: Sifan Ye
 * Nov. 6, 2017
 */

public class URArrayListTest {

private URArrayList<Integer> testArrList;
	
	@BeforeClass
	public static void runsBeforeTheTest(){		
		System.out.println("Run before any test method is executed");	
	}
	
	@Before
	public void runOnceBeforeEachTestMethod(){
		testArrList = new URArrayList<Integer>(5);
		System.out.println("Create new arraylist of size 5");
	}
	
	@Test
	//Is Empty
	public void testIsEmpty(){
		System.out.println("Test if list is empty");
		assertTrue(testArrList.isEmpty());
	}
	
	@Test
	//Add
	public void testAddElemWOItr(){
		System.out.println("Test add 3, 6, 5, 1, 4 and print with index");
		int[] testElem = new int[]{3, 6, 5, 1, 4};
		for(int i: testElem){
			testArrList.add(i);
		}
		String testOut = "";
		for(int i = 0; i < 5; i++){
			testOut += (testArrList.get(i) + " ");
		}
		assertEquals("3 6 5 1 4 ", testOut);
	}
	
	@Test
	//Iterator
	public void testAddElemWithItr(){
		System.out.println("Test add 3, 6, 5, 1, 4 and print with iterator");
		int[] testElem = new int[]{3, 6, 5, 1, 4};		
		for(int i: testElem){
			testArrList.add(i);
		}
		String testOut = "";
		for(int i: testArrList){
			testOut += (i + " ");
		}
		assertEquals("3 6 5 1 4 ", testOut);
	}
	
	@Test
	//Is Empty
	public void testIsNotEmpty(){
		testArrList.add(2);
		System.out.println("Test if list is not empty");
		assertFalse(testArrList.isEmpty());
	}
	
	@Test
	//Add all
	public void testAddAll(){
		System.out.println("Test add 3, 6, 5, 1, 4 as a list and print with iterator");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testArrList.addAll(test);
		String testOut = "";
		for(int i: testArrList){
			testOut += (i + " ");
		}
		assertEquals("3 6 5 1 4 ", testOut);
	}
	
	@Test
	//Add all at index
	public void testAddAllAtIndex(){
		System.out.println("Test add 3, 6, 5, 1, 4 as a list");
		System.out.println("At index 2 of (4,9,11,15), then print with iterator");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.addAll(2, test);
		String testOut = "";
		for(int i: testArrList){
			testOut += (i + " ");
		}
		System.out.println(testOut);
		assertEquals("4 9 3 6 5 1 4 11 15 ", testOut);
	}
	
	@Test
	//Test clear()
	public void testClear(){
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.clear();
		System.out.println("Test clear");
		assertTrue(testArrList.isEmpty());
	}
	
	@Test
	//Contains: Return True
	public void testContainsTrue(){
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		System.out.println("Test contains() True");
		System.out.println(testArrList.contains(9));
		assertTrue(testArrList.contains(9));
	}
	
	@Test
	//Contains: Return False
		public void testContainsFalse(){
			testArrList.add(4);
			testArrList.add(9);
			testArrList.add(11);
			testArrList.add(15);
			System.out.println("Test contains() False");
			System.out.println(testArrList.contains(12));
			assertTrue(testArrList.contains(12));
		}
	
	@Test
	//Contains All: Return True
	public void testContainsAllTrue(){
		System.out.println("Test contains all: Case True");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testArrList.add(4);
		testArrList.add(11);
		testArrList.add(3);
		testArrList.add(15);
		testArrList.add(6);
		testArrList.add(5);
		testArrList.add(1);
		testArrList.add(9);
		testArrList.add(4);
		System.out.println(testArrList.containsAll(test));
		assertTrue(testArrList.containsAll(test));
	}
	
	@Test
	//Contains All: Return false
	public void testContainsAllFalse(){
		System.out.println("Test contains all: Case False");
		List<Integer> test = new ArrayList<Integer>();
		test.add(3);
		test.add(6);
		test.add(5);
		test.add(1);
		test.add(4);
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.add(3);
		testArrList.add(5);
		testArrList.add(4);
		System.out.println(testArrList.containsAll(test));
		assertTrue(!testArrList.containsAll(test));
	}
	
	
	
	@After
	public void runOnceAfterEachTestMethod(){	
		System.out.println("Run after each test method\n");
	}
	
	@AfterClass
	public static void runsAfterTheTest(){
		System.out.println("Run after all the test methods are executed");	
	}

}
