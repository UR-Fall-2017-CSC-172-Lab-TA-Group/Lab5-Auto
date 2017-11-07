import static org.junit.Assert.*;

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
	public void testAddElemWithItr(){
		System.out.println("Test add 3, 6, 5, 1, 4 and print with iterator");
		int[] testElem = new int[]{3, 6, 5, 1, 4};
		String testOut = "";
		for(int i: testElem){
			testArrList.add(i);
		}
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
	
	@After
	public void runOnceAfterEachTestMethod(){	
		System.out.println("Run after each test method");
	}
	
	@AfterClass
	public static void runsAfterTheTest(){
		System.out.println("Run after all the test methods are executed");	
	}

}
