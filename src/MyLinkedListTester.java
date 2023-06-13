import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//Author: Stipan Madzar

public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	
	
	@Before
	public void setUp() throws Exception {
		
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		list1.add(2, 423);
		list1.add(4, 213);
		list1.add(55);
		list1.remove(4);
		list1.set(0, 13);
		list1.set(3, 2);
	}


	@Test
	public void testGet()
	{
		try {
			
			emptyList.get(0);
			fail("Check out of bounds");
			
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}

		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		     
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	
	@Test
	public void testRemove()
	{
		assertEquals("Remove: check size correctness", 5, list1.size());
		assertEquals("Add: check element 3 is correct ", (Integer)55, list1.get(4));
		
		try {
			list1.remove(8);
			fail("Check out of bounds");
		}
		
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.remove(-1);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	
	@Test
	public void testAddEnd()
	{

		assertEquals("Add: check a size is correct ", 5, list1.size);
		assertEquals("Add: check element 2 is correct ", (Integer)423, list1.get(2));
		assertEquals("Add: check element 0 is correct ", (Integer)13, list1.get(0));
		
		try {
			list1.add(3, null);
			fail("Check is null");
		}
		catch(NullPointerException e) {
			
		}

		try {
			list1.add(43, 2);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}

	}

	@Test
	public void testSize()
	{
		if(list1.size != 5) {
			fail("Size not correct!");
		}
		
	}

	@Test
	public void testAddAtIndex()
	{
        
		assertEquals("Add: check a size is correct ", 2, shortList.size);
		assertEquals("Add: check element 2 is correct ", (Integer)423, list1.get(2));
		assertEquals("Add: check element 0 is correct ", (Integer)2, list1.get(3));
		
		try {
			list1.add(7, 20);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.add(-1, 54);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.add(3, null);
			fail("Check is null");
		}
		catch(NullPointerException e) {
			
		}
		
	}
	
	@Test
	public void testSet()
	{

		try {
			list1.set(-1, 20);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(10, 20);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list1.set(3, null);
			fail("Check is null");
		}
		catch(NullPointerException e) {
			
		}
		
		assertEquals("Set: check element 0 is correct ", (Integer)13, list1.get(0));
		assertEquals("Set: check element 3 is correct ", (Integer)2, list1.get(3));	
	}
	
	
}

