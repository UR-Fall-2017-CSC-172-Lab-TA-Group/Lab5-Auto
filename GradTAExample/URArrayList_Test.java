import URList;
import URArrayList;
import URLinkedList;

public class URArrayList_Test
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
		// System.out.print("Testing add(E e): ");
		// try { testAdd(); System.out.println("Passed"); }
		// catch(FailedTestCase e) { System.out.println("Failed with \"" + e.getMessage() + "\""); }
		test_ensureCapacity();
	}

	//------------------------------------------------------------
	// Test cases
	//
	// All of these tests assume that your iterator works.
	//------------------------------------------------------------

	public static void test_ensureCapacity() {  
		URArrayList<Integer> arrayList1 = new URArrayList<Integer>();
		URArrayList<Integer> arrayList2 = new URArrayList<Integer>();

		int capacity= arrayList1.getCapacity();
		System. out.println( "Init capacity : " + capacity);

		arrayList1.ensureCapacity(1);
		capacity = arrayList1.getCapacity();
		System.out.println( "Ensure capacity 1: " + capacity);

		arrayList1.ensureCapacity(capacity*2);
		capacity=arrayList1.getCapacity();
		System.out.println( "Double capacity : " + capacity);

		arrayList1.ensureCapacity(100000);
		capacity=arrayList1.getCapacity();
		System. out.println( "Large capacity request test (1e5): " + capacity);
	}
}
