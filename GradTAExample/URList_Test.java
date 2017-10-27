import java.util.Iterator;
import java.util.ArrayList;
import URList;
import URArrayList;
import URLinkedList;

public class URList_Test
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
	//
	// An Instantiation or IllegalAccess exception means that
	// something is wrong with the constructor of your class.
	//
	// I am fully aware that this is hackish and really bad
	// practice. Please don't emulate anything you see in this
	// file. Really, you should look at this as more of an
	// example of bad practice than anything else as this whole
	// file makes heavy use of both reflection and raw types.
	//
	// To put it in perspective, if I submitted this code for
	// review at any job, I would fully expect someone to give me
	// a good one-on-one talk because any Java programmer should
	// be horrified by it.
	//
	// - Nate
	//------------------------------------------------------------

	public static void main(String[] args)
		throws InstantiationException, IllegalAccessException
	{
		testAll(URArrayList.class);
		System.out.println("");
		testAll(URLinkedList.class);
	}

	public static <T extends URList<Integer>> void testAll(Class<T> clazz)
		throws InstantiationException, IllegalAccessException
	{
		System.out.println("--- " + clazz.getName() + " ---");

		System.out.print("Testing add(E e): ");
		try { testAdd(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing add(int index, E element): ");
		try { testAddIndex(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing addAll(Collection<? extends E> c): ");
		try { testAddAll(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing clear(): ");
		try { testClear(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing contains(Object o): ");
		try { testContains(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing containsAll(Collection<?> c): ");
		try { testContainsAll(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing equals(Object o): ");
		try { testEquals(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing indexOf(Object o): ");
		try { testIndexOf(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing isEmpty(): ");
		try { testIsEmpty(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing remove(int index): ");
		try { testRemoveIndex(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing remove(Object o): ");
		try { testRemove(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing removeAll(Collection<?> c): ");
		try { testRemoveAll(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing set(int index, E element): ");
		try { testSet(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing size(): ");
		try { testSize(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing subList(int fromIndex, int toIndex): ");
		try { testSubList(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }

		System.out.print("Testing toArray(): ");
		try { testToArray(clazz); System.out.println("Passed"); }
		catch(Exception e) { System.out.println("Failed"); e.printStackTrace(); }
	}

	//------------------------------------------------------------
	// Test cases
	//
	// All of these tests assume that your iterator works. Most of
	// them assume that add works.
	//------------------------------------------------------------

	public static <T extends URList> void testAdd(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.add(1);
		Iterator<Integer> iter = l.iterator();
		if(iter.next() != 0)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 1)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testAddIndex(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.add(2);
		l.add(1, 1);
		Iterator<Integer> iter = l.iterator();

		if(iter.next() != 0)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 1)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Third item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testAddAll(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(0); c.add(1); c.add(2);
		l.addAll(c);

		Iterator<Integer> iter = l.iterator();
		if(iter.next() != 0)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 1)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Third item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testAddAllIndex(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(0); c.add(1); c.add(2);
		l.add(-1);
		l.addAll(1, c);

		Iterator<Integer> iter = l.iterator();
		if(iter.next() != -1)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 0)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.next() != 1)
			throw new FailedTestCase("Third item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Fourth item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testClear(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.clear();

		Iterator<Integer> iter = l.iterator();
		if(iter.hasNext())
			throw new FailedTestCase("List was not empty");
	}

	public static <T extends URList> void testContains(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.add(1);

		if(l.contains(2))
			throw new FailedTestCase("List claimed to contain element that was not present");
		if(!l.contains(0))
			throw new FailedTestCase("List could not find element \"0\"");
		if(!l.contains(1))
			throw new FailedTestCase("List could not find element \"1\"");
	}

	public static <T extends URList> void testContainsAll(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.add(1);
		l.add(2);

		ArrayList<Integer> bad = new ArrayList<Integer>();
		bad.add(0); bad.add(1); bad.add(3);

		ArrayList<Integer> good = new ArrayList<Integer>();
		bad.add(0); bad.add(1); bad.add(2);

		ArrayList<Integer> empty = new ArrayList<Integer>();

		if(l.containsAll(bad))
			throw new FailedTestCase("List claimed to contain element that was not present");
		if(!l.containsAll(good))
			throw new FailedTestCase("List could not find all elements");
		if(!l.containsAll(empty))
			throw new FailedTestCase("List could not find no elements");
	}

	public static <T extends URList> void testEquals(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();
		URList<Integer> m = clazz.newInstance();
		URList<Integer> n = clazz.newInstance();
		URList<Integer> o = clazz.newInstance();
		URList<Integer> p = clazz.newInstance();

		l.add(0);
		l.add(1);

		m.add(0);
		m.add(1);

		n.add(0);

		if(l.equals(n))
			throw new FailedTestCase("[0,1] does not equal [0]");
		if(!l.equals(m))
			throw new FailedTestCase("[0,1] does equal [0, 1]");
		if(!l.equals(l))
			throw new FailedTestCase("List does not equal itself");
		if(l.equals(o))
			throw new FailedTestCase("List does not equal empty list");
		if(!o.equals(p))
			throw new FailedTestCase("Empty lists are equal");
	}

	public static <T extends URList> void testIndexOf(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();
		l.add(1);
		l.add(0);

		if(l.indexOf(0) != 1)
			throw new FailedTestCase("Incorrect index for \"0\"");
		if(l.indexOf(1) != 0)
			throw new FailedTestCase("Incorrect index for \"1\"");
		if(l.indexOf(2) != -1)
			throw new FailedTestCase("Should return \"-1\" for elements the list doesn't contain");
	}

	public static <T extends URList> void testIsEmpty(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		if(!l.isEmpty())
			throw new FailedTestCase("List should be empty");

		l.add(0);
		if(l.isEmpty())
			throw new FailedTestCase("List should not be empyt");
	}

	public static <T extends URList> void testRemoveIndex(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.add(1);
		l.add(2);

		if(l.remove(1) != 1)
			throw new FailedTestCase("Removed item is incorrect");

		Iterator<Integer> iter = l.iterator();
		if(iter.next() != 0)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Third item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testRemove(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0);
		l.add(2);
		l.add(1);

		if(!l.remove(new Integer(1)))
			throw new FailedTestCase("Failed to remove integer");
		if(l.remove(new Integer(3)))
			throw new FailedTestCase("Removed value that the list doesn't contain");

		Iterator<Integer> iter = l.iterator();
		if(iter.next() != 0)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Third item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testRemoveAll(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();
		l.add(0); l.add(1); l.add(2);

		ArrayList<Integer> c = new ArrayList<Integer>();
		c.add(0); c.add(1);

		if(!l.removeAll(c))
			throw new FailedTestCase("Failed to remove all items");

		Iterator<Integer> iter = l.iterator();
		if(iter.next() != 2)
			throw new FailedTestCase("First item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testSet(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(1);
		l.add(0);

		if(l.set(0, 2) != 1)
			throw new FailedTestCase("Returned incorrect value");

		Iterator<Integer> iter = l.iterator();
		if(iter.next() != 2)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 0)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in list");
	}

	public static <T extends URList> void testSize(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		if(l.size() != 0)
			throw new FailedTestCase("Size should be 0");

		l.add(1);
		if(l.size() != 1)
			throw new FailedTestCase("Size should be 1");

		l.clear();
		if(l.size() != 0)
			throw new FailedTestCase("Size should be 0");

		l.add(0);
		if(l.size() != 1)
			throw new FailedTestCase("Size should be 1");

		l.remove(0);
		if(l.size() != 0)
			throw new FailedTestCase("Size should be 0");
	}

	public static <T extends URList> void testSubList(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0); l.add(1); l.add(2);
		URList<Integer> sublist = l.subList(1, 3);

		Iterator<Integer> iter = sublist.iterator();
		if(iter.next() != 1)
			throw new FailedTestCase("First item is incorrect");
		if(iter.next() != 2)
			throw new FailedTestCase("Second item is incorrect");
		if(iter.hasNext())
			throw new FailedTestCase("Too many items in sublist");
	}

	public static <T extends URList> void testToArray(Class<T> clazz) throws FailedTestCase, InstantiationException, IllegalAccessException{
		URList<Integer> l = clazz.newInstance();

		l.add(0); l.add(1); l.add(2);
		Object[] arr = l.toArray();

		if(arr.length != 3)
			throw new FailedTestCase("Array is wrong size");

		if(!new Integer(0).equals(arr[0]))
			throw new FailedTestCase("First item is incorrect");
		if(!new Integer(1).equals(arr[1]))
			throw new FailedTestCase("Second item is incorrect");
		if(!new Integer(2).equals(arr[2]))
			throw new FailedTestCase("Third item is incorrect");
	}
}
