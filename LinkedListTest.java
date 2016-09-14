package aufgabenblatt1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testklasse der Klasse LinkedList.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 * 
 */
public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		assertEquals(0, list.size());

		try {
			list.insert(0, 42);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, list.size());
		try {
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
		} catch (Exception e) {
		}
		assertEquals(4, list.size());
	}

	@Test
	public void testInsert() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		try {
			// beliebiges Objekt auf Index
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
			list.insert(4, 46);

			// Null auf beliebigen Index
			list.insert(1, null);

		} catch (Exception e) {
		}
		assertEquals(0, list.find(42));
		assertEquals(2, list.find(44));
		assertEquals(4, list.find(46));

		assertEquals(new Integer(43), list.retrieve(1));
		assertEquals(new Integer(44), list.retrieve(2));
		assertEquals(new Integer(45), list.retrieve(3));
	}

	@Test
	public void testFind() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<String> leereL = new LinkedList<String>();

		assertEquals(-1, list.find(5));

		try {
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(0, list.find(42));
		try {
			leereL.find("test");
			assertEquals(-1, list.find(null));
		} catch (NullPointerException e) {
		}
		assertEquals(1, list.find(43));
		assertEquals(2, list.find(44));
	}

	@Test
	public void testDelete() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<String> leereL = new LinkedList<String>();

		try {
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
			list.insert(4, 46);
			list.insert(5, 47);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.delete(0);
		assertEquals(new Integer(43), list.retrieve(0));
		assertEquals(new Integer(47), list.retrieve(4));

		list.delete(2);
		assertEquals(4, list.size());

		try {
			list.delete(6);
			leereL.delete(1);
		} catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testConcat() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		LinkedList<Integer> ergList = new LinkedList<Integer>();

		try {
			list1.insert(0, 42);
			list2.insert(0, 43);
			list2.insert(1, 44);
			ergList.insert(0, 42);
			ergList.insert(1, 43);
			ergList.insert(2, 44);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list1.concat(list2);
		assertEquals(3, list1.size());
		for (int i = 0; i < ergList.size(); i++) {
			assertEquals(ergList.retrieve(i), list1.retrieve(i));
		}
	}

	@Test
	public void testRetrieve() {
		LinkedList<Integer> list = new LinkedList<Integer>();

		try {
			list.insert(0, 42);
			list.insert(1, 43);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(new Integer(42), list.retrieve(0));
		assertEquals(new Integer(43), list.retrieve(1));

	}
}
