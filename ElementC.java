package aufgabenblatt1;

/**
 * Hilfsklasse für die Klasse LinkedList.
 * 
 * @author Robert Rösler (robert.roesler@haw-hamburg.de), Nico Grimm
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
	 * Zeiger auf das nächste Element
	 */
	private ElementC nextElem;

	/**
	 * Mit der Methode wird ein Object eingefügt.
	 * 
	 * @param elem
	 *            Einzufügendes Element.
	 */
	public void insert(Object elem) {
		this.elem = elem;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das Element zurück.
	 */
	public Object getElem() {
		return elem;
	}

	/**
	 * Getter
	 * 
	 * @return Gibt das nächste Element zurück.
	 */
	public ElementC getNextElem() {
		return nextElem;
	}

	/**
	 * Setter
	 * 
	 * @param nextElem
	 *            Element, welches das nächste ist.
	 */
	public void setNextElem(ElementC nextElem) {
		this.nextElem = nextElem;
	}
}
