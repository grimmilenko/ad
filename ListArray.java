package aufgabenblatt1;

/**
 * Eine Klasse zur Realisierung einer Liste anhand eines Arrays.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 * 
 * @param <T>
 */
public class ListArray<T> implements I_Liste<T> {
	/**
	 * Array, in dem die eingefügten Elemente gespeichert werden.
	 */
	private Object[] liste = new Object[10];

	/**
	 * Größe der Liste
	 */
	private int size = 0;

	private boolean isValidPos(int pos) {
		return (pos >= 0 && pos <= size) ? true : false;
	}

	private void resize(Object[] listArray, int multiplier) {
		Object[] temp = new Object[liste.length * multiplier];
		System.arraycopy(liste, 0, temp, 0, liste.length);
		liste = temp;
	}

	@Override
	public void insert(int pos, T elem) throws Exception {
		if (isValidPos(pos) && elem != null) {
			Object[] temp = new Object[liste.length];
			for (int i = 0; i < pos; i++) {
				temp[i] = liste[i];
			}
			temp[pos] = elem;
			for (int i = pos; i < size; i++) {
				temp[i + 1] = liste[i];
			}
			liste = temp;
			size++;
		} else {
			throw new Exception();
		}

		if (size == liste.length) {
			resize(liste, 2);
		}
	}

	@Override
	public void delete(int pos) throws IndexOutOfBoundsException {
		if (!isValidPos(pos)) {
			throw new IndexOutOfBoundsException();
		}
		Object[] temp = new Object[liste.length];
		for (int i = 0; i < pos; i++) {
			temp[i] = liste[i];
		}
		for (int i = pos + 1; i < size; i++) {
			temp[i - 1] = liste[i];
		}
		liste = temp;
		size--;
	}

	@Override
	public int find(T elem) throws NullPointerException {
		if (elem != null) {
			for (int i = 0; i < size; i++) {
				if (liste[i].equals(elem)) {
					return i;
				}
			}
		} else {
			throw new NullPointerException();
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T retrieve(int pos) throws IndexOutOfBoundsException {
		if (!isValidPos(pos)) {
			throw new IndexOutOfBoundsException();
		}
		return (T) liste[pos];
	}

	@Override
	public void concat(I_Liste<T> otherList) throws NullPointerException {
		if (otherList != null && otherList.size() > 0) {
			Object[] temp = new Object[size + otherList.size() + 1];
			for (int i = 0; i < size; i++) {
				temp[i] = liste[i];
			}
			for (int i = 0; i < otherList.size(); i++) {
				temp[i + size] = otherList.retrieve(i);
			}
			liste = temp;
			size = size + otherList.size();
		}
	}

	@Override
	public int size() {
		return size;
	}

}
