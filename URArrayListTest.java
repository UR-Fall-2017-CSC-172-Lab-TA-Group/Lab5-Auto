import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	@After
	public void runOnceAfterEachTestMethod(){
		testArrList = null;
		System.out.println("Set testArrList to null");
	}
	
	@AfterClass
	public static void runsAfterTheTest(){
		System.out.println("Run after all the test methods are executed");	
	}

}
