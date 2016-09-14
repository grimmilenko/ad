package aufgabenblatt1;

/**
 * Eine Klasse zur Realisierung einer Liste mit Hilfe von einfach verketteten
 * Elementen.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 * 
 * @param <T>
 */
public class LinkedList<T> implements I_Liste<T> {
	private ElementC elem = new ElementC();
	private int size = 0;

	@Override
	public void insert(int pos, T elem) throws Exception {
		if (pos >= 0 && pos <= size && elem != null) {
			ElementC temp = this.elem;
			ElementC newElem = new ElementC();
			newElem.insert(elem);
			for (int i = 0; i < pos; i++) {
				temp = temp.getNextElem();
			}
			newElem.setNextElem(temp.getNextElem());
			temp.setNextElem(newElem);
			size++;
		} else {
			throw new Exception();
		}
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos <= size) {
			ElementC temp = elem;
			for (int i = 0; i < pos; i++) {
				temp = temp.getNextElem();
			}
			temp.setNextElem(temp.getNextElem().getNextElem());
			size--;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int find(T elem) throws NullPointerException {
		if (elem == null) {
			throw new NullPointerException();
		}
		if (size > 0) {
			int pos = 0;
			ElementC temp = this.elem.getNextElem();
			while (temp != null) {
				if (temp.getElem().equals(elem)) {
					return pos;
				}
				temp = temp.getNextElem();
				pos++;
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (pos >= 0 && pos < size) {
			ElementC temp = elem;
			for (int i = 0; i <= pos; i++) {
				temp = temp.getNextElem();
			}
			return (T) temp.getElem();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public void concat(I_Liste<T> otherList) throws NullPointerException {
		ElementC temp = elem.getNextElem();
		if (otherList != null) {
			while (temp.getNextElem() != null) {
				temp = temp.getNextElem();
			}
			temp.setNextElem(((LinkedList<T>) otherList).getElem());
			size += otherList.size();
		}
	}

	@Override
	public int size() {
		return size;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das Element des nächsten zurück.
	 */
	public ElementC getElem() {
		return elem.getNextElem();
	}
}
