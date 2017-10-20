import URList;
import URArrayList;
import URLinkedList;
public class URLinkedList_Test
{
	//------------------------------------------------------------
	// Boilerplate stuff
	//------------------------------------------------------------

	public static class FailedTestCase extends Exception
	{
		public FailedTestCase(String message)
		{
			super(message);
		}
	}

	//------------------------------------------------------------
	// Entry point
	//------------------------------------------------------------

	public static void main(String[] args)
	{
		System.out.print("Testing add first: ");
		try { test_addFirst(); System.out.println("Passed"); }
		catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }

		System.out.print("Testing add last: ");
		try { test_addLast(); System.out.println("Passed"); }
		catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }

		System.out.print("Testing peek first: ");
		try { test_peekFirst(); System.out.println("Passed"); }
		catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }

		System.out.print("Testing peek last: ");
		try { test_peekLast(); System.out.println("Passed"); }
		catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }

		System.out.print("Testing poll first: ");
		try { test_pollFirst(); System.out.println("Passed"); }
		catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }

		System.out.print("Testing poll last: ");
		try { test_pollLast(); System.out.println("Passed"); }
		catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }
	}

	public static void test_addFirst(URLink<E> linklist) {  
		while linklist.next() !=null:
			System. out.println(linklist.element());
			linklist=linklist.next()
	return 1
	//------------------------------------------------------------
	// Test cases
	//
	// All of these tests assume that your iterator works.
	//------------------------------------------------------------

	public static void test_addFirst() {  
		URLink<int> linkList_1 = new URLink<int>();

		linkList_1.addFirst(3)
		linkList_1.addFirst(2)
		linkList_1.addFirst(1)

		Iterator<Integer> iter = linkList_1.iterator();
		if(iter.next() != 1)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 3)
			throw new FailedTestCase("Second item is incorrect");		
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static void test_addLast() {  
		URLink<int> linkList_1 = new URLink<int>();

		linkList_1.addLast(3)
		linkList_1.addLast(2)
		linkList_1.addLast(1)

		Iterator<Integer> iter = linkList_1.iterator();
		if(iter.next() != 3)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 1)
			throw new FailedTestCase("Second item is incorrect");		
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}	

	public static void test_peekFirst() {  
		URLink<int> linkList_1 = new URLink<int>();

		if (linkList_1.peekFirst()!=null):
			throw new FailedTestCase("Fail for empty case");

		linkList_1.addFirst(3)
		linkList_1.addFirst(2)
		linkList_1.addFirst(1)
	
		if (linkList_1.peekFirst()!=3):
			throw new FailedTestCase("Fail to provide right peek value");
		
		Iterator<Integer> iter = linkList_1.iterator();
		if(iter.next() != 1)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 3)
			throw new FailedTestCase("Second item is incorrect");		
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static void test_peekLast() {  
		URLink<int> linkList_1 = new URLink<int>();

		if (linkList_1.peekLast()!=null):
			throw new FailedTestCase("Fail for empty case");

		linkList_1.addFirst(3)
		linkList_1.addFirst(2)
		linkList_1.addFirst(1)
	
		if (linkList_1.peekLast()!=1):
			throw new FailedTestCase("Fail to provide right peek value");
		
		Iterator<Integer> iter = linkList_1.iterator();
		if(iter.next() != 1)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 3)
			throw new FailedTestCase("Second item is incorrect");		
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static void test_pollFirst() {  
		URLink<int> linkList_1 = new URLink<int>();

		if (linkList_1.pollFirst()!=null):
			throw new FailedTestCase("Fail for empty case");

		linkList_1.addFirst(3)
		linkList_1.addFirst(2)
		linkList_1.addFirst(1)
	
		if (linkList_1.pollFirst()!=3):
			throw new FailedTestCase("Fail to provide right peek value");
		
		Iterator<Integer> iter = linkList_1.iterator();
		if(iter.next() != 1)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Second item is incorrect");	
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static void test_pollLast() {  
		URLink<int> linkList_1 = new URLink<int>();

		if (linkList_1.pollLast()!=null):
			throw new FailedTestCase("Fail for empty case");

		linkList_1.addFirst(3)
		linkList_1.addFirst(2)
		linkList_1.addFirst(1)
	
		if (linkList_1.pollLast()!=1):
			throw new FailedTestCase("Fail to provide right peek value");
		
		Iterator<Integer> iter = linkList_1.iterator();
		if(iter.next() != 2)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 3)
			throw new FailedTestCase("Second item is incorrect");	
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}	
}