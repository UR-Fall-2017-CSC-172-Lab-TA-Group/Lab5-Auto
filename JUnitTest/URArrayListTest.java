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
		System.out.println("Start testing URArrayList");	
	}
	
	@Before
	public void runOnceBeforeEachTestMethod(){
		//System.out.println("Run before each test method.");
		testArrList = new URArrayList<Integer>();
	}
	
	@Test
	//Is Empty: True
	public void testIsEmpty(){
		//System.out.println("Test isEmpty() returns true");
		assertTrue(testArrList.isEmpty());
	}
	
	@Test
	//Add
	public void testAddElemWOItr(){
		//System.out.println("Test add() and print with index");
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
		//System.out.println("Test add() and print with iterator");
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
	//Is Empty: False
	public void testIsNotEmpty(){
		testArrList.add(2);
		//System.out.println("Test isEmpty() returns false");
		assertFalse(testArrList.isEmpty());
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
		//System.out.println("Test addAllAtIndex() as a list");
		//System.out.println("At index 2 of (4,9,11,15), then print with iterator");
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
		//System.out.println(testOut);
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
		//System.out.println("Test clear");
		assertTrue(testArrList.isEmpty());
	}
	
	@Test
	//Contains: Return True
	public void testContainsTrue(){
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		//System.out.println("Test contains() returns true");
		//System.out.println(testArrList.contains(9));
		assertTrue(testArrList.contains(9));
	}
	
	@Test
	//Contains: Return False
		public void testContainsFalse(){
			testArrList.add(4);
			testArrList.add(9);
			testArrList.add(11);
			testArrList.add(15);
			//System.out.println("Test contains() returns false");
			//System.out.println(testArrList.contains(12));
			assertTrue(!testArrList.contains(12));
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
		testArrList.add(4);
		testArrList.add(11);
		testArrList.add(3);
		testArrList.add(15);
		testArrList.add(6);
		testArrList.add(5);
		testArrList.add(1);
		testArrList.add(9);
		testArrList.add(4);
		//System.out.println(testArrList.containsAll(test));
		assertTrue(testArrList.containsAll(test));
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
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.add(3);
		testArrList.add(5);
		testArrList.add(4);
		//System.out.println(testArrList.containsAll(test));
		assertTrue(!testArrList.containsAll(test));
	}
	
	@Test
	//Equals: Return True
	public void testEqualsTrue(){
		URList<Integer> test1 = new URArrayList<Integer>();
		test1.add(1);
		test1.add(110);
		test1.add(100);
		test1.add(114);
		test1.add(101);
		test1.add(115);
		URList<Integer> test2 = new URArrayList<Integer>();
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
		URList<Integer> test1 = new URArrayList<Integer>();
		test1.add(1);
		test1.add(110);
		test1.add(100);
		test1.add(114);
		test1.add(101);
		test1.add(115);
		URList<Integer> test2 = new URArrayList<Integer>();
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
		//System.out.println("Test indexOf() returns index of element");
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		//System.out.println(testArrList.indexOf(11));
		assertEquals(2, testArrList.indexOf(11));
	}
	
	@Test
	//remove()
	public void testRemove(){
		//System.out.println("Test remove() remove element at indext");
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.add(12);
		testArrList.remove(2);
		String testOut = "";
		for(int i: testArrList){
			testOut += (i + " ");
		}
		//System.out.println(testOut);
		assertEquals("4 9 15 12 ", testOut);
	}
	
	@Test
	//boolean remove() true
	public void testBoolRemoveTrue(){
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.add(12);
		boolean result = testArrList.remove((Object) 11);
		String testOut = "";
		for(int i: testArrList){
			testOut += (i + " ");
		}
		//System.out.println(testOut);
		assertEquals(true, result);
		assertEquals("4 9 15 12 ", testOut);
	}
	
	@Test
	//boolean remove() false
	public void testBoolRemoveFalse(){
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		testArrList.add(12);
		boolean result = testArrList.remove((Object) 8);
		String testOut = "";
		for(int i: testArrList){
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
		testArrList.add(17);
		testArrList.add(19);
		testArrList.set(1,18);
		String testOut = "";
		for(int i: testArrList){
			testOut += (i + " ");
		}
		assertEquals("17 18 ",testOut);
	}
	
	@Test
	//size()
	public void testSize(){
		testArrList.add(4);
		testArrList.add(9);
		testArrList.add(11);
		testArrList.add(15);
		assertEquals(testArrList.size(),4);
	}
	
	@Test
	//subList()
	public void testSubList(){
		testArrList.add(6); //0
		testArrList.add(36);
		testArrList.add(0); //2
		testArrList.add(200); //3
		testArrList.add(999);
		testArrList.add(1000); //5
		URList other = testArrList.subList(3, 6);
		String res = "";
		for (int i = 0; i < 3; i++) {
			res += other.get(i) + " ";
		}
		assertEquals("200 999 1000 ", res);
	}
	
	@Test
	//toArray()
	public void testToArray(){
		testArrList.add(16);
		testArrList.add(25);
		testArrList.add(36);
		testArrList.add(49);
		Object[] objArray = testArrList.toArray();
		int[] intArray = new int[4];
		for(int i=0;i<objArray.length;i++) {
			intArray[i] = ((Integer)objArray[i]).intValue();
		}
		assertEqual(new int[]{16,25,36,49}, intArray);
	}
	
	@Test
	//ensureCapacity()
	public void testEnsureCapacity(){
		int oldCapacity =testArrList.getCapacity();
		for(int i =0; i <= oldCapacity; i++) {
			testArrList.add(42);
		}
		
		assertTrue(oldCapacity < testArrList.getCapacity());
	}
	
	@Test
	//getCapacity()
	public void testGetCapacity(){
		testArrList.add(4);
		testArrList.add(4);
		testArrList.add(4);
		testArrList.add(4);
		
		assertTrue(testArrList.size() < testArrList.getCapacity() );
		
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
