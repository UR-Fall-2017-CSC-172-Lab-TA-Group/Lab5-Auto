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
	public void testIsEmpty(){
		System.out.println("Test if list is empty");
		assertTrue(testArrList.isEmpty());
	}
	
	@Test
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
	public void testIsNotEmpty(){
		testArrList.add(2);
		System.out.println("Test if list is not empty");
		assertFalse(testArrList.isEmpty());
	}
	
	@Test
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
	public void testAllAllAtIndex(){
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
		assertEquals("4 9 3 6 5 1 4 11 15 ", testOut);
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
