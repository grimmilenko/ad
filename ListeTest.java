package aufgabenblatt1;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Testklasse der Liste Klasse.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 * 
 */
public class ListeTest {

	@Test
	public void testSize() {
		Liste<Integer> list = new Liste<Integer>();
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
			e.printStackTrace();
		}
		assertEquals(4, list.size());
	}

	@Test
	public void testInsert() {
		Liste<Integer> list = new Liste<Integer>();
		try {
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
			list.insert(4, null);
		} catch (Exception e) {
		}
		assertEquals(5, list.size());
		try {
			list.insert(-1, 20);
		} catch (IndexOutOfBoundsException e) {
		} catch (Exception e) {
		}
		assertEquals(new Integer(45), list.retrieve(3));
		assertEquals(new Integer(43), list.retrieve(1));
	}

	@Test
	public void testDelete() {
		Liste<Integer> list = new Liste<Integer>();
		try {
			list.delete(1);
		} catch (IndexOutOfBoundsException e) {

		}

		try {
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
			list.insert(4, 46);
		} catch (Exception e) {
			e.printStackTrace();
		}

		list.delete(0);
		assertEquals(new Integer(43), list.retrieve(0));
		assertEquals(new Integer(46), list.retrieve(3));

		try {
			list.delete(5);
		} catch (IndexOutOfBoundsException e) {
		}
	}

	@Test
	public void testFind() {
		Liste<Integer> list = new Liste<Integer>();

		assertEquals(-1, list.find(42));

		try {
			list.insert(0, 42);
			list.insert(1, 43);
			list.insert(2, 44);
			list.insert(3, 45);
			list.insert(4, 46);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals(1, list.find(43));
		assertEquals(4, list.find(46));
		assertEquals(-1, list.find(41));
	}

	@Test
	public void testConcat() {
		Liste<Integer> list1 = new Liste<Integer>();
		Liste<Integer> list2 = new Liste<Integer>();
		Liste<Integer> ergList = new Liste<Integer>();

		try {
			list1.insert(0, 42);
			list1.insert(1, 43);
			list2.insert(0, 44);
			list2.insert(1, 45);

			ergList.insert(0, 42);
			ergList.insert(1, 43);
			ergList.insert(2, 44);
			ergList.insert(3, 45);
		} catch (Exception e) {
			e.printStackTrace();
		}

		list1.concat(list2);
		assertEquals(4, list1.size());
		for (int i = 0; i < ergList.size(); i++) {
			assertEquals(ergList.retrieve(i), list1.retrieve(i));
		}

	}

	@Test
	public void testRetrieve() {
		Liste<Integer> list = new Liste<Integer>();

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
