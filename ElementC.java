package aufgabenblatt1;

/**
 * Hilfsklasse f�r die Klasse LinkedList.
 * 
 * @author Robert R�sler (robert.roesler@haw-hamburg.de), Nico Grimm
 *         (nico.grimm@haw-hamburg.de)
 * 
 *         Algorithmen und Datenstrukturen - Praktikum AD -- SS16
 *
 * 
 */
public class ElementC {
	/**
	 * Data
	 */
	private Object elem;

	/**
	 * Zeiger auf das n�chste Element
	 */
	private ElementC nextElem;

	/**
	 * Mit der Methode wird ein Object eingef�gt.
	 * 
	 * @param elem
	 *            Einzuf�gendes Element.
	 */
	public void insert(Object elem) {
		this.elem = elem;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das Element zur�ck.
	 */
	public Object getElem() {
		return elem;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das n�chste Element zur�ck.
	 */
	public ElementC getNextElem() {
		return nextElem;
	}

	/**
	 * Setter
	 * 
	 * @param nextElem
	 *            Element, welches das n�chste ist.
	 */
	public void setNextElem(ElementC nextElem) {
		this.nextElem = nextElem;
	}
}
