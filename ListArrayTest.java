package aufgabenblatt1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testklasse der Klasse ListArray.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 * 
 */
public class ListArrayTest {

	@Test
	public void testSize() {
		ListArray<Integer> list = new ListArray<Integer>();
		assertEquals(0, list.size());

		try {
			list.insert(0, 49);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(1, list.size());

		try {
			list.insert(1, 22);
			list.insert(2, 10);
			list.insert(3, 42);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(4, list.size());
	}

	@Test
	public void testInsert() {
		ListArray<Integer> list = new ListArray<Integer>();
		try {
			list.insert(0, 10);
			list.insert(1, 42);
			list.insert(2, 100);
			list.insert(3, null);
		} catch (Exception e) {
		}
		assertEquals(3, list.size());
		try {
			assertEquals(-1, list.find(5));
		} catch (NullPointerException e) {

		}
		assertEquals(0, list.find(10));
		assertEquals(2, list.find(100));

	}

	@Test
	public void testFind() {
		ListArray<Integer> list = new ListArray<Integer>();

		assertEquals(-1, list.find(42));
		try {
			list.insert(0, 42);
			list.insert(1, 100);
			list.insert(2, 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(0, list.find(42));
		try {
			assertEquals(-1, list.find(null));
		} catch (NullPointerException e) {

		}
		assertEquals(2, list.find(12));
		assertEquals(-1, list.find(-12));
	}

	@Test
	public void testDelete() {
		ListArray<Integer> list = new ListArray<Integer>();

		try {
			list.delete(1);
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		}

		try {
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
		} catch (Exception e) {
		}
		assertEquals(4, list.size());
		list.delete(1);
		assertEquals(3, list.size());
		assertEquals(new Integer(42), list.retrieve(0));
		assertEquals(new Integer(44), list.retrieve(1));
		assertEquals(new Integer(45), list.retrieve(2));
		assertEquals(null, list.retrieve(3));

		try {
			list.delete(5);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("IndexOutOfBoundsException geworfen!");
		}
	}

	@Test
	public void testConcat() {
		ListArray<Integer> list1 = new ListArray<Integer>();
		ListArray<Integer> list2 = new ListArray<Integer>();
		ListArray<Integer> ergList = new ListArray<Integer>();

		try {
			list1.insert(0, 42);
			list1.insert(1, 43);
			list1.insert(2, 44);

			list2.insert(0, 45);
			list2.insert(1, 46);
			list2.insert(2, 47);

			ergList.insert(0, 42);
			ergList.insert(1, 43);
			ergList.insert(2, 44);
			ergList.insert(3, 45);
			ergList.insert(4, 46);
			ergList.insert(5, 47);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list1.concat(list2);
		assertEquals(6, list1.size());
		for (int i = 0; i < ergList.size(); i++) {
			assertEquals(ergList.retrieve(i), list1.retrieve(i));
		}

	}

	@Test
	public void testRetrieve() {
		ListArray<Integer> list = new ListArray<Integer>();

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
