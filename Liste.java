package aufgabenblatt1;

/**
 * Eine Klasse zur Realisierung einer Liste mit Hilfe eines Arrays, wobei die
 * Elemente im Array auf der vorherigen bzw nächsten Index zeigen.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 * 
 * @param <T>
 */
public class Liste<T> implements I_Liste<T> {

	/**
	 * Innere Hilfsklasse zur Realisierung der Abspeicherung von Objekten.
	 * 
	 * @author Robert Rösler & Nico Grimm
	 *
	 */
	private class Element {
		/**
		 * Abgespeichertes Element.
		 */
		private Object elem;
		/**
		 * Index der nächsten Stelle.
		 */
		private int nextPos;
		/**
		 * Index der vorherigen Stelle.
		 */
		private int prevPos;

		/**
		 * Getter
		 * 
		 * @return Gibt das aktuelle Element zurück.
		 */
		public Object getElem() {
			return elem;
		}

		/**
		 * Getter
		 * 
		 * @return Gibt den nächsten Index zurück.
		 */
		public int getNextPos() {
			return nextPos;
		}

		/**
		 * Getter
		 * 
		 * @return Gibt den vorherigen Index zurück.
		 */
		public int getPrevPos() {
			return prevPos;
		}

		public void add(int pos, Object elem) {
			this.elem = elem;
			nextPos = pos + 1;
			prevPos = pos - 1;
		}
	}

	/**
	 * Array zum abspeichern von Elementen.
	 */
	private Object[] list = new Object[10];
	/**
	 * Größe des Arrays.
	 */
	private int size = 0;
	/**
	 * Stop-Element
	 */
	private Element stopElem = new Element();

	@SuppressWarnings("unchecked")
	@Override
	public void insert(int pos, T elem) throws Exception {
		if (pos >= 0 && pos <= size) {
			list[size] = stopElem;
			Element temp1 = new Element();
			Element temp2 = (Element) list[pos];
			temp1.add(pos, elem);
			list[pos] = temp1;
			while (!temp2.equals(stopElem)) {
				temp1 = temp2;
				temp2 = (Element) list[temp1.getNextPos()];
				list[temp1.getNextPos()] = temp1;
				temp1.add(temp1.getNextPos(), temp1.getElem());
			}
			size++;
			if (size == list.length) {
				Object[] tempList = new Object[list.length * 2];
				for (int i = 0; i < list.length; i++) {
					tempList[i] = list[i];
				}
				list = tempList;
			}
			list[size] = stopElem;
		} else {
			throw new Exception();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos <= size) {
			Element temp = (Element) list[pos + 1];
			while (!temp.equals(stopElem)) {
				list[temp.getPrevPos()] = temp;
				temp.add(temp.getPrevPos(), temp.getElem());
				temp = (Element) list[temp.getNextPos() + 1];
			}
			size--;
			list[size] = stopElem;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public int find(T elem) {
		if (size > 0) {
			Element temp = (Element) list[0];
			while (!temp.equals(stopElem)) {
				if (temp.getElem().equals(elem)) {
					return temp.getNextPos() - 1;
				}
				temp = (Element) list[temp.getNextPos()];
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos <= size) {
			return (T) ((Element) list[pos]).getElem();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void concat(I_Liste<T> otherList) throws NullPointerException {
		if (otherList != null) {
			while (otherList.size() > 0) {
				try {
					insert(size, otherList.retrieve(0));
				} catch (Exception e) {
					e.printStackTrace();
				}
				otherList.delete(0);
			}
		}
	}

	@Override
	public int size() {
		return size;
	}

}
